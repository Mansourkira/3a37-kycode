package Utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String url = "jdbc:mysql://localhost:3306/native1";
    String login = "root";
    String pwd = "";
    public  static Database db;
    public Connection con;
    public Database() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    
    
    public static Database getInstance()
    {if(db==null)
        db=new Database();
    return db;
    }     
     
     
}