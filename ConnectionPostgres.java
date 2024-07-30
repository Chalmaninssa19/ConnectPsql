package connection.postgres;

import java.lang.Thread.State;
import java.sql.*;

public class ConnectionPostgres {
// Attribut de la classe
    Connection co = null;
    Statement stmt;
    String url = "jdbc:postgresql://localhost:5432/test";
    String dbDriver = "org.postgresql.Driver";
    String user;
    String password;

// Function GET
    public Connection get_co() { return co; }
    public Statement get_stmt() { return stmt; }
    public String get_url() { return url; }
    public String get_dbDriver() { return dbDriver; }
    public String get_user() { return user; }
    public String get_password() { return password; }

// Function SET
    public void set_co(Connection co) { this.co = co; }
    public void set_stmt(Statement stmt) { this.stmt = stmt; }
    public void set_url(String url) { this.url = url; }
    public void set_dbDriver(String dbDriver) { this.dbDriver = dbDriver; }
    public void set_user(String user) { this.user = user; }
    public void set_password(String password) { this.password = password; }

// Constructor
    public ConnectionPostgres(String user, String password) {
        set_user(user);
        set_password(password);
    }

// Open and close connection
    public void openConnection() throws Exception{
        Class.forName(dbDriver);
        set_co(DriverManager.getConnection(url, user, password));
    }
    public void closeConnection() throws Exception {
        get_co().close();
    }
    public void creatingStatement() throws Exception{
        set_stmt(get_co().createStatement());
    }
    public void preparingConnection() throws Exception {
        openConnection();
        creatingStatement();
    }   
}