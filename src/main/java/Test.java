import jdbc.JdbcCrud;

/**
 * Created by Alexey on 23.01.2017.
 */
public class Test {

    public static void main(String[] args) {
        JdbcCrud repo = JdbcCrud.getInstance();
        repo.connect("h2Connection");
        repo.update("smth");
        repo.close();
    }
}
