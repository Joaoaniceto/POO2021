import java.util.List;
import java.util.Map;

public class MenuApp {
    public static void main(String args[]) throws Exception {


        Parser p = new Parser();
        p.parse();

        new Delegate(p).run();





    }
}
