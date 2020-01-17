/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Esta clase se encarga de guardar algunos de los datos nuevos ingresados,
 * tales como: roles, actividades, empresas, areas, estados y medios.
 *
 * @author 57300
 */
public class Dato {

    private int datokey;
    private String nombre;
    private String dato;

    public Dato() {
    }

    public Dato(int datokey, String nombre, String dato) {
        this.datokey = datokey;
        this.nombre = nombre;
        this.dato = dato;
    }

    public int getDatokey() {
        return datokey;
    }

    public void setDatokey(int datokey) {
        this.datokey = datokey;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
