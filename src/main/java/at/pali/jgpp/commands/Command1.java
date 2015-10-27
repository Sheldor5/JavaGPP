package at.pali.jgpp.commands;

/**
 * This command will be executed immediately
 */
public class Command1 extends Command {

    public Command1(final String paramID) {
        super(paramID);
    }

    public boolean execute(final long delta) {
        System.out.println(String.format("Successfully executed Command1 with ID '%s'", this.getID()));
        return true;
    }
}
