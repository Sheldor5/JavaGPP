package at.pali.jgpp.commands;

public abstract class Command implements CommandInterface {

    private String ID = "";

    private Command() {
        // don't allow this
    }

    Command(final String paramID) {
        this.ID = paramID;
    }

    public String getID() {
        return this.ID;
    }

}
