
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

class DBconnector {

    private static String id = "SEM2_GR03";						
    private static String pw = "SEM2_GR03";
 
    public Connection getConnection() {
        Connection con = null;
        try {
            System.out.println("DBconnector - 1");
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:DAT", id, pw);
            System.out.println("DBconnector - 2");

        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("eror in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}