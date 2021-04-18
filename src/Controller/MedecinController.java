/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medecin;
import Entity.Specialite;
import Utlis.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mansour
 */
public class MedecinController {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public MedecinController() {
        con = Database.getInstance().getConnection();
    }
    private Statement ste;

    public void Add(Medecin u) throws SQLException {
        // the mysql insert statement
        String query = " insert into medecin (id,ref_id,email,roles,password,nom,prenom,adresse,cv,school,etat,num_telephone,image,description,specialite_id)"
                + " values (Null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1,u.getRef_id());
        preparedStmt.setString(2,u.getEmail());
        preparedStmt.setString(3,u.getRole());
        preparedStmt.setString(4,u.getPassword());
        preparedStmt.setString(5,u.getNom());
        preparedStmt.setString(6,u.getPrenom());
        preparedStmt.setString(7,u.getAdresse());
        preparedStmt.setString(8,u.getCv());
        preparedStmt.setString(9,u.getShcool());
        preparedStmt.setString(10,u.getEtat());
        preparedStmt.setString(11,u.getNum_telephone());
        preparedStmt.setString(12,u.getImage());
        preparedStmt.setString(13,u.getDesctription());
        preparedStmt.setInt(14,u.getSpecialite_id());
        preparedStmt.executeUpdate();
        con.close();
    }
 public List<Medecin> readAll() throws SQLException {
    List<Medecin> arr=new ArrayList<>();
    ste=con.createStatement();
       String sql ="select * from medecin";
     try {

	 PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id=res.getInt(1);
               String nom=res.getString("nom");
                String prenom=res.getString("nom");

                String adresse=res.getString("nom");
              
               System.out.println("---------------Medecin-------------------");
               System.out.println("Nom du medecin  = "+res.getString("nom") );
               System.out.println("Prenom du medecin  = "+res.getString("prenom") );
               System.out.println("Adresse du medecin  = "+res.getString("adresse") );

                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         return arr;
    }
 
 
  public void update(Medecin m) {
       
       
        String sql2="UPDATE medecin SET email=?,description=?,nom=?,prenom=?,school=?,num_telephone=?,adresse=? WHERE id=?";
        try{
            
             PreparedStatement pstmt = con.prepareStatement(sql2);
            
            pstmt.setString(1,m.getEmail());
            pstmt.setString(2,m.getDesctription());
            pstmt.setString(3,m.getNom());
           pstmt.setString(4,m.getPrenom());
            pstmt.setString(5,m.getShcool());
            pstmt.setString(6,m.getNum_telephone());
                            pstmt.setString(6,m.getNum_telephone());
                                                        pstmt.setString(7,m.getAdresse());

                            pstmt.setInt(8,m.getId());

            pstmt.executeUpdate();
                          System.out.println("Medecin à été bien modifier");

            pstmt.close();

            
       }catch (SQLException ex) {
       }
        //
         
    }
  
   public void supprimer(int p) {
       
         try {
              String req2 =
                      "delete from medecin where id=?";    
             
              PreparedStatement ps = 
                      con.prepareStatement(req2);
              ps.setInt(1, p);
              ps.executeUpdate();
              System.out.println("Medecin à été bien supprimer");
           
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }
 public void findMedecinById(int p) throws SQLException
 {
     String req2 =
                      "select * from medecin where ref_id=?";    
             
               PreparedStatement st= con.prepareStatement(req2);
               st.setInt(1,p);
      try {
             	    ResultSet res= st.executeQuery();
                    
                    if (res.next())
                    {
                 System.out.println("---------------Medecin-------------------");
                System.out.println("nom ="+res.getString("nom"));
                System.out.println("prenom ="+res.getString("prenom"));
                System.out.println("adresse ="+res.getString("adresse"));
                System.out.println("shcool ="+res.getString("school"));

                    }

   } catch (SQLException ex) {
              System.out.println(ex);
          }
}
 
    public void stat()throws SQLException
    {
           String req =
                      "select count(id)  from medecin";    
      
           String req2 =
                      "select count(*)  from medecin where specialite_id=1";    
                   String req3 =
                      "select count(*)   from medecin where specialite_id=2";
                   String req4 =
                      "select count(*)   from medecin where specialite_id=3";  
               PreparedStatement st= con.prepareStatement(req2);
                PreparedStatement st1= con.prepareStatement(req3);
                  PreparedStatement st2= con.prepareStatement(req4);
               PreparedStatement st3= con.prepareStatement(req);
               //int count=0;
                 try {
             	    ResultSet res= st.executeQuery();
                     ResultSet res1= st1.executeQuery();
                     ResultSet res2= st2.executeQuery();
                     ResultSet res3= st3.executeQuery();
                    
                         if ((res3.next())){ 
                             
                         if(res.next())
                     {
                    float PD=(float) res.getInt(1)/res3.getInt(1);
                    System.out.println(res.getInt(1)+ " Dentiste  => "+PD*100+"%");
                     }
                           if(res1.next())
               {
                     float Pp=(float) res1.getInt(1)/res3.getInt(1);

                        System.out.println(res1.getInt(1)+ " psychothérapeute  => "+Pp*100+"%");
               }
                             if(res2.next())
               {
                     float Pa=(float) res2.getInt(1)/res3.getInt(1);

                        System.out.println(res2.getInt(1)+ " anesthésiologie  => "+Pa*100+"%");
               }
                           
                           
                     }

   } catch (SQLException ex) {
              System.out.println(ex);
          }
                 
                 
    }
    public void showSspec(Medecin m) throws SQLException
    {
          String sql ="select libelle from specialite  S "
                + "JOIN medecin m ON m.specialite_id=S.id where m.id=?";

            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1,m.getId());
	    ResultSet res= st.executeQuery();
         try {
     while (res.next()) {        
              System.out.println("Ce Medecin est = " +res.getString("libelle"));
             
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
             }
}
