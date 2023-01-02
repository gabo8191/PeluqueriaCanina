
package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dueno implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_Dueno;
    private String nombre;
    private String celDueno;

    public Dueno() {
    }

    public Dueno(int id_Dueno, String nombre, String celDueno) {
        this.id_Dueno = id_Dueno;
        this.nombre = nombre;
        this.celDueno = celDueno;
    }

    public int getId_Dueno() {
        return id_Dueno;
    }

    public void setId_Dueno(int id_Dueno) {
        this.id_Dueno = id_Dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelDueno() {
        return celDueno;
    }

    public void setCelDueno(String celDueno) {
        this.celDueno = celDueno;
    }
    
    
    
}
