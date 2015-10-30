package at.pali.jgpp.commands;

/**
 * This command will be executed every second
 * and will add a Command1 command to the executor
 */
public class Command4 extends Command {

    public static final long NANOS = 1000000000;

    private long timeLeft = NANOS;
    private long start;

    public Command4(final String paramID) {
        super(paramID);
        this.start = System.nanoTime();
    }

    public boolean execute(final long delta) {
        this.timeLeft -= delta;
        if (this.timeLeft <= 0) {
            final long time = System.nanoTime() - this.start;
            this.start = System.nanoTime();
            System.out.println(String.format("Successfully executed Command4 with ID '%s' in %dns (%dns)", this.getID(), time, this.timeLeft));
            this.timeLeft += NANOS;
            return true;
        }
        return false;
    }

}
