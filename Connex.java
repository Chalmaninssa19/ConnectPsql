package connection;
import java.sql.*;

public class Connex
{
    String DB_base = "jdbc:postgresql://localhost:5432/test";
    Connection connection = null;

    // Encapsulation
    public void setConnection(Connection connection){this.connection = connection;}
    public Connection getConnection(){return this.connection;}

    // Constructeur
    public Connex(){}

    public Connection DBconnect(){
        try{
            // user Oracle and mdp
            String username = "postgres";
            String mdp = "root";

            //etape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");
            
            //etape 2: creer l'objet de connexion
            setConnection(DriverManager.getConnection(DB_base,username,mdp));
        }
        catch(Exception e){ 
            System.out.println(e); 
        }
        return this.connection;
    }

     public void coupeConnection(){
        try{
           this.connection.close();
        }
        catch(Exception e){ 
            System.out.println(e); 
        }
    }

}