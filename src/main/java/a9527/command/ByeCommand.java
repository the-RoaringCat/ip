package a9527.command;
import a9527.a9527.A9527;
public class ByeCommand extends Command{
    @Override
    public void execute() {
        A9527.byeUser();
        A9527.assertShouldExit();
    }
}
