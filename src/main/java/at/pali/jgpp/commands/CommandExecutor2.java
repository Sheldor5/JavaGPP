package at.pali.jgpp.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandExecutor2 {

    private static CommandExecutor2 instance;

    private final List<Command> commands = new ArrayList<Command>();

    private long lastExecutionTime;

    private CommandExecutor2() {
        // defeat instantiation
        this.lastExecutionTime = System.nanoTime();
    }

    // singleton instance getter
    public static CommandExecutor2 getInstance() {
        if (null == instance) {
            instance = new CommandExecutor2();
        }
        return instance;
    }

    public void addCommand(final Command paramCommand) {
        this.commands.add(paramCommand);
    }

    public synchronized void executeCommands() {
        for (final Command command : this.commands) {
            command.execute(System.nanoTime() - this.lastExecutionTime);
        }
        //this.commands.clear();
        this.lastExecutionTime = System.nanoTime();
    }
}
