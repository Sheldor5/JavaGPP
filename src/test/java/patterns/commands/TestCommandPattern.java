package patterns.commands;

import at.pali.jgpp.commands.*;
import org.junit.Assert;
import org.junit.Test;

public class TestCommandPattern {

    @Test
    public void testCommandPatterns() {

        final CommandExecutor2 commandExecutor = CommandExecutor2.getInstance();

        commandExecutor.addCommand(new Command4("40"));

        while (true) {
            commandExecutor.executeCommands();
        }
    }

    @Test
    public void testCommandPatterns2() {

        final CommandExecutor2 commandExecutor = CommandExecutor2.getInstance();

        commandExecutor.addCommand(new Command4("40"));

        while (true) {
            commandExecutor.executeCommands();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
