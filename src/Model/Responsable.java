/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Licmora
 */
public class Responsable {
    private int responsablekey;
    private String username;
    private String password;
    private String nombre;
    /**
     * Los roles definen que se puede hacer en la app:
     * -Responsable bitacora: Tiene total control de la app, puede gestionar usuarios y tickets.
     * -Responsable de ticket: Tiene control sobre sus propios tickets, de posponerlos 
     */
    private String rol;

    public int getResponsablekey() {
        return responsablekey;
    }

    public void setResponsablekey(int responsablekey) {
        this.responsablekey = responsablekey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
