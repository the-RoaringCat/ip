package a9527.command;
import a9527.a9527.A9527;
public class ByeCommand extends Command{
    /**
     * Executes bye command.
     * <p>
     * Prints farewell message and sets shouldExit to true.
     *
     * @see A9527
     */
    @Override
    public void execute() {
        A9527.byeUser();
        A9527.assertShouldExit();
    }
}
