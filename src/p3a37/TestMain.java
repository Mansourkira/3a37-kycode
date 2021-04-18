/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p3a37;

import Controller.MedecinController;
import Controller.SpecialiteController;
import Entity.Medecin;
import Entity.Specialite;
import java.sql.SQLException;


/**
 *
 * @author Mansour
 */
public class TestMain {
       public static void main(String[] args) throws SQLException {
           //   Specialite p = new Specialite("Psycatre");
           SpecialiteController pc = new SpecialiteController();
           MedecinController mc = new MedecinController();
            //  pc.Add(p);
             /* pc.readAll();
            pc.delete(4);*/
           Medecin m1 = new Medecin("Leo", "Messi", "Barcelona", "", "Bernabio", "1", "29598701", "", "best doctor ever", "ROLES_MEDECIN", "leo@gmail.com", "123456", 67, 1);
            // mc.Add(m1);
           //  mc.readAll();
           //   int p=67;
            //mc.findMedecinById(p);   
           /*---update*/
           Medecin m2 = new Medecin(9,"Leo", "Messi", "Barcelona", "Bernabio", "29598701", "best doctor ever","leoa@gmail.com");

           Specialite s = new Specialite(5,"dermatologie");
            //pc.update(s);
            // mc.update(m2);
            mc.stat();
            // mc.findMedecinById(67);
            // mc.showSspec(m2);

    }
    
}
