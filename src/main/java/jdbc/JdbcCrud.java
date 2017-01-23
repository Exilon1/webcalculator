package jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by Alexey on 23.01.2017.
 */
public class JdbcCrud {

    private JdbcCrud() {
    }

    private static class SingletonHelper {
        private static final JdbcCrud SINGLETON = new JdbcCrud();
    }

    public static JdbcCrud getInstance() {
        return JdbcCrud.SingletonHelper.SINGLETON;
    }


    private Connection connection;
    private ResourceBundle bundle;

    private static final String CREATE = "CREATE TABLE RESULTS (RESULT VARCHAR(128))";
    private static final String READ = "SELECT * FROM RESULTS";
    private static final String UPDATE = "INSERT INTO RESULTS(RESULT) VALUES(?)";

    private PreparedStatement createStatement;
    private PreparedStatement readStatement;
    private PreparedStatement updateStatement;

    public void connect(String property) {
        bundle = ResourceBundle.getBundle(property);
        try {
            connection = DriverManager.getConnection(bundle.getString("url"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if("h2Connection".equals(property))
            try {
                createStatement = connection.prepareStatement(CREATE);
                createStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        try {
            readStatement = connection.prepareStatement(READ);
            updateStatement = connection.prepareStatement(UPDATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if(createStatement != null)
            try {
                createStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(readStatement != null)
            try {
                readStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(updateStatement != null)
            try {
                updateStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void create() {
        try (Statement dataQuery = connection.createStatement()) {
            dataQuery.execute(CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read() {
        try {
            return readStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(String result) {
        try {
            updateStatement.setString(1, result);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
