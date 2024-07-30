import java.io.*;
import java.sql.*;

public class GConnection {
     String type_base="postgres";
     String database="test";
     String owner="postgres";
     String password="root";
     String port="5432";
     String host = "localhost";
     String driver="org.postgresql.Driver";
     String connection;
    
    public Connection getSimpleConnection()throws Exception{
        Connection con=null;
    	if (con == null) {
           try{
               Class.forName(driver);    
               con = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+database,owner,password);
          }
          catch(Exception e){
               e.printStackTrace();
               throw new Exception("il y a un probleme avec la connection, verifier les donnees de connection");
          } 
       }
       return con;
   }
  /* public static void main(String[]args){
         try{
              Connection con=getSimpleConnection();
              //System.out.println("connection reussie");
              con.close();
         }catch(Exception e){
              e.printStackTrace();
         }
   }*/
}
