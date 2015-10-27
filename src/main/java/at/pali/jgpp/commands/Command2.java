package at.pali.jgpp.commands;

/**
 * This command will be executed 1 second in the future
 */
public class Command2 extends Command {

    // 1000000000ns = 1s
    private long timeLeft = 1000000000;

    public Command2(final String paramID) {
        super(paramID);
    }

    public boolean execute(final long delta) {
        this.timeLeft -= delta;
        if (this.timeLeft <= 0) {
            System.out.println(String.format("Successfully executed Command2 with ID '%s'", this.getID()));
            return true;
        }
        return false;
    }
}
