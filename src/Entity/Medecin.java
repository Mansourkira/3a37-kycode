/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.Objects;

/**
 *
 * @author Mansour
 */
public class Medecin {
    
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String cv;
    private String shcool;
    private String etat;
    private String num_telephone;
    private String image;
    private String desctription;
    private String role;
    private String email;
    private String password;
    private int ref_id;
    private int specialite_id ;

    @Override
    public String toString() {
        return "Medecin{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cv=" + cv + ", shcool=" + shcool + ", etat=" + etat + ", num_telephone=" + num_telephone + ", image=" + image + ", desctription=" + desctription + ", role=" + role + ", email=" + email + ", password=" + password + ", ref_id=" + ref_id + ", specialite_id=" + specialite_id + '}';
    }

    public Medecin(String nom, String prenom, String adresse, String cv, String shcool, String etat, String num_telephone, String image, String desctription, String role, String email, String password, int ref_id, int specialite_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cv = cv;
        this.shcool = shcool;
        this.etat = etat;
        this.num_telephone = num_telephone;
        this.image = image;
        this.desctription = desctription;
        this.role = role;
        this.email = email;
        this.password = password;
        this.ref_id = ref_id;
        this.specialite_id = specialite_id;
    }

    public Medecin(int id, String nom, String prenom, String adresse, String shcool, String num_telephone, String desctription, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.shcool = shcool;
        this.num_telephone = num_telephone;
        this.desctription = desctription;
        this.email = email;
    }
public Medecin( String nom, String prenom, String adresse, String shcool, String num_telephone,  String email,int specialite_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.shcool = shcool;
        this.num_telephone = num_telephone;
        this.email = email;
        this.specialite_id=specialite_id;
    }


    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medecin other = (Medecin) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.cv, other.cv)) {
            return false;
        }
        if (!Objects.equals(this.specialite_id, other.specialite_id)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }
    

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getShcool() {
        return shcool;
    }

    public void setShcool(String shcool) {
        this.shcool = shcool;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesctription() {
        return desctription;
    }

    public void setDesctription(String desctription) {
        this.desctription = desctription;
    }

    public int getSpecialite_id() {
        return specialite_id;
    }

    public void setSpecialite_id(int specialite_id) {
        this.specialite_id = specialite_id;
    }
        public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    
}
