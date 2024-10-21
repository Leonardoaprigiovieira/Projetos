package cone;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {

    private static final String url = "jdbc:myslq://localhost:3306/banco";
    private static final String user = "root";
    private static final String password = "leo12345";

    private static Connection conn;

    public static Connection getconexao() {
        try {
            if (conn == null) {

                conn = DriverManager.getConnection(url, url, password);
                return conn;
            }else{
                return conn;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
