
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String nombreDueno, String raza, String color, String observaciones, String alergico, String atenEsp, String celDueno) {
       
        //CREACIONES DE OBJETOS Y VALORES
       Dueno dueno = new Dueno();
       dueno.setNombre(nombreDueno);
       dueno.setCelDueno(celDueno);     
       
       Mascota masco = new Mascota();
       masco.setAlergico(alergico);
       masco.setAtencionEspecial(atenEsp);
       masco.setColor(color);
       masco.setNombre(nombreMasco);
       masco.setRaza(raza);
       masco.setObservaciones(observaciones);
       masco.setUnDueno(dueno);
       
       controlPersis.guardar(dueno,masco);
       
    }

    public List<Mascota> traerMascotas() {
     
        return controlPersis.traerMascotas();  
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
     return controlPersis.traerMascota(num_cliente);
    
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDueno, String celDueno) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencionEspecial(atenEsp);
        masco.setAlergico(alergico);
        
        //MODIFICO LA MASCOTA
        
        controlPersis.modificarMascota(masco);
        //SETEO VALORES DUEÑO
        Dueno dueno = this.buscarDienio(masco.getUnDueno().getId_Dueno());
        dueno.setNombre(nombreDueno);
        dueno.setCelDueno(celDueno);
        
        //LLAMAR MODIFICAR DUEÑO
        this.modificarDueno(dueno);
    }

    private Dueno buscarDienio(int id_Dueno) {
        return controlPersis.traerDueno(id_Dueno);
    
    }

    private void modificarDueno(Dueno dueno) {
        controlPersis.modificarDueno(dueno);
    }
}
