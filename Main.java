import java.lang.Thread.State;
import java.sql.*;
import connection.Connex;
public class Main {
    public static void main( String [] args ) throws Exception {
        Connex gc = new Connex();
        Connection c = gc.DBconnect();
        Statement rq = c.createStatement();
        ResultSet res = rq.executeQuery("select * from testing");
        while ( res.next()) {
            System.out.println(res.getString(1));
        }
    }
}