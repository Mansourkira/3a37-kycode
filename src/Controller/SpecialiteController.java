/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Utlis.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entity.Specialite;

/**
 *
 * @author Mansour
 */
public class SpecialiteController {
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */        
        Connection con;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

    public SpecialiteController() {
        con =Database.getInstance().getConnection();

    }
    
     
     private Statement ste;
  public void Add(Specialite u) throws SQLException
    {
 // the mysql insert statement
      String query = " insert into specialite (libelle)"
        + " values (?)";   
      PreparedStatement preparedStmt = con.prepareStatement(query);
    preparedStmt.setString(1, u.getLibelle());
    preparedStmt.executeUpdate();
    //con.close();
    }
  
  // liste des specialite
  
  public List<Specialite> readAll() throws SQLException {
    List<Specialite> arr=new ArrayList<>();
    ste=con.createStatement();
       String sql ="select * from specialite";
     try {

	 PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id=res.getInt(1);
               String libelle=res.getString("libelle");
               System.out.println("Specialite  = "+res.getString("libelle"));
              
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         return arr;
    }
  
    public boolean delete(int id) throws SQLException {
        ste = con.createStatement();
        String requeteDelete ="DELETE FROM  `native1`.`specialite` WHERE `specialite` . id ='"+id+"'";
        return ste.executeUpdate(requeteDelete)==1;
    }
    
    
    
    public boolean update(Specialite u) throws SQLException {
        String query  ="UPDATE specialite SET `libelle`=?  WHERE id =?";
       // con.setAutoCommit(false);
        preparedStatement = con.prepareStatement(query);        
        preparedStatement.setString(1, u.getLibelle());
        preparedStatement.setInt(2, u.getId());
        System.out.println("Specialité à été bien modifier");
        return preparedStatement.executeUpdate()==1;
        
        
        
    }
    
     public void supprimer(int p) {
       
         try {
              String req2 =
                      "delete from specialite where id=?";    
             
              PreparedStatement ps = 
                      con.prepareStatement(req2);
              ps.setInt(1, p);
              ps.executeUpdate();
                         System.out.println("Specialite à été bien supprimer");

          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }
    
    

  
}

