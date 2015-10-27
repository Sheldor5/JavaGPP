package at.pali.jgpp.commands;

public interface CommandInterface {

    // each command has to have the execute()-method which is called by the executor
    // the variable 'delta' stores the amount of time in nanoseconds between the last execution and the current execution
    boolean execute(final long delta);

}
