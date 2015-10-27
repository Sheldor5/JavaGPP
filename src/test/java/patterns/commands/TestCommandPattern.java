package patterns.commands;

import at.pali.jgpp.commands.Command1;
import at.pali.jgpp.commands.Command2;
import at.pali.jgpp.commands.Command3;
import at.pali.jgpp.commands.CommandExecutor;
import org.junit.Test;

public class TestCommandPattern {

    @Test
    public void testCommandPatterns() {

        final CommandExecutor commandExecutor = CommandExecutor.getInstance();

        commandExecutor.addCommand(new Command1("1"));
        commandExecutor.addCommand(new Command2("2"));
        commandExecutor.addCommand(new Command3("3"));

        while (!commandExecutor.isEmpty()) {
            commandExecutor.executeCommands();
        }
    }

}
