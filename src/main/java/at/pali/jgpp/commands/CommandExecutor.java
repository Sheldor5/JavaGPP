package at.pali.jgpp.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandExecutor {

    private static CommandExecutor instance;

    private final List<Command> commands = new ArrayList<Command>();
    private final List<Command> tmp = new ArrayList<Command>();

    private long lastExecutionTime = System.nanoTime();
    private long delta = 0;

    private volatile boolean isLocked = false;

    private CommandExecutor() {
        // defeat instantiation
    }

    // singleton instance getter
    public static CommandExecutor getInstance() {
        if (null == instance) {
            instance = new CommandExecutor();
        }
        return instance;
    }

    public void addCommand(final Command paramCommand) {
        if (this.isLocked) {
            this.tmp.add(paramCommand);
        } else {
            this.commands.add(paramCommand);
        }
    }

    public synchronized void executeCommands() {

        // lock executor so no other thread can modify the list of commands
        this.isLocked = true;

        // thread-safe execution of all commands
        synchronized (this.commands) {
            // iterate all commands in the list
            final Iterator<Command> iterator = this.commands.iterator();
            while (iterator.hasNext()) {
                final Command command = iterator.next();
                if (command.execute(this.delta)) {
                    // if the command returns 'true' the command has finished and can be removed from the list
                    // otherwise the command may finishes in the next call
                    iterator.remove();
                }
                // the time between the executeCommands()-call and the execute()-call of the current command
                this.delta = System.nanoTime() - this.lastExecutionTime;
            }
            // move all commands which were added during the execution to the current list
            this.commands.addAll(this.tmp);
        }

        // thread-safe unlocking
        synchronized (this.tmp) {
            // unlock executor
            this.isLocked = false;

            // clear the temporary list of commands
            this.tmp.clear();
        }
        // get reference time
        this.lastExecutionTime = System.nanoTime();
    }

    public boolean isEmpty() {
        return this.commands.isEmpty();
    }
}
