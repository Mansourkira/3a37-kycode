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
public class User {
    private int id;
    private int id_patient;
    private int id_medecin;
        private String type;

    @Override
    public int hashCode() {
        int hash = 7;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_patient != other.id_patient) {
            return false;
        }
        if (this.id_medecin != other.id_medecin) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    public User(int id, int id_patient, int id_medecin, String type) {
        this.id = id;
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", id_patient=" + id_patient + ", id_medecin=" + id_medecin + ", type=" + type + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
}
