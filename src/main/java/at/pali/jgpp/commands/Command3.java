package at.pali.jgpp.commands;

/**
 * This command will be executed every 2 second
 * and will add a Command1 command to the executor
 */
public class Command3 extends Command {

    private final CommandExecutor commandExecutor;

    // 2000000000ns = 2s
    private long timeLeft = 2000000000;
    private long start;

    private boolean deactivated = false;

    private int count = 10;

    public Command3(final String paramID) {
        super(paramID);
        this.commandExecutor = CommandExecutor.getInstance();
        this.start = System.nanoTime();
    }

    public boolean execute(final long delta) {
        this.timeLeft -= delta;
        if (this.timeLeft <= 0) {
            final long d = System.nanoTime() - this.start;
            this.start = System.nanoTime();
            System.out.println(String.format("Successfully executed Command3 with ID '%s' in %dns (%dns)", this.getID(), d, this.timeLeft));
            commandExecutor.addCommand(new Command1(String.valueOf(this.count++)));
            this.timeLeft = 2000000000l;
        }
        return this.deactivated;
    }

    public void deactivate() {
        this.deactivated = true;
    }
}
