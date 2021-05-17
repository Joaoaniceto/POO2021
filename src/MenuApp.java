import java.util.List;
import java.util.Map;

public class MenuApp {
    public static void main(String args[]) throws Exception {

        Data d = Parser.parse();

        new Delegate(d).run();

    }
}
