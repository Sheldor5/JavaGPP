package at.pali.jgpp.commands;

/**
 * This command will be executed every 2 second
 * and will add a Command1 command to the executor
 */
public class Command3 extends Command {

    private final CommandExecutor commandExecutor;

    // 1000000000ns = 1s
    public static final long NANOS = 1000000000l;

    private long timeLeft = NANOS;
    private long start;

    private boolean deactivated = false;

    public Command3(final String paramID) {
        super(paramID);
        this.commandExecutor = CommandExecutor.getInstance();
        this.start = System.nanoTime();
    }

    public boolean execute(final long delta) {
        this.timeLeft -= delta;
        if (this.timeLeft <= 0) {
            System.out.println(String.format("Successfully executed Command3 with ID '%s' in %dns (%dns)", this.getID(), System.nanoTime() - this.start, this.timeLeft));
            this.start = System.nanoTime();
            this.timeLeft += NANOS;
        }
        return this.deactivated;
    }

    public void deactivate() {
        this.deactivated = true;
    }
}
