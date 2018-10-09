/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendarioacs;


import java.util.Calendar;
import utilidades.fecha;

/**
 *
 * @author Emerson
 */
public class ProyectoCalendarioACS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fecha nuevaFecha = new fecha();
        
        nuevaFecha.setDay(2);
        nuevaFecha.setMonth(1);
        nuevaFecha.setYear(2018);
        
        //System.out.println(nuevaFecha.fecha_es_tupla(1, -3, 4));
        //System.out.println(nuevaFecha.bisiesto(nuevaFecha));
        
        //System.out.println(nuevaFecha.fecha_es_valida(nuevaFecha));
        
        //nuevaFecha = nuevaFecha.dia_siguiente(nuevaFecha);
        //System.out.println("dia: " +nuevaFecha.getDay());
        //System.out.println("mes: " +nuevaFecha.getMonth());
        //System.out.println("year: " +nuevaFecha.getYear());
        
        //System.out.println(nuevaFecha.días_desde_primero_enero(nuevaFecha));
        
        //System.out.println(nuevaFecha.dia_primero_enero(nuevaFecha));
        
        //nuevaFecha.imprimir_4x3(2018);
    }
  
    
}
