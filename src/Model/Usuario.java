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
public class Usuario {

    private int usuariokey;
    private String username;
    private String password;
    private String nombre;
    /**
     * Los roles definen que se puede hacer en la app: -Usuario bitacora: Tiene
     * total control de la app, puede gestionar usuarios y tickets. -Usuario de
     * ticket: Tiene control sobre sus propios tickets y de posponerlos, lo cual
     * se avisa de inmediato al responsable de bitacora.
     */
    private String rol;

    public int getResponsablekey() {
        return usuariokey;
    }

    public void setResponsablekey(int responsablekey) {
        this.usuariokey = responsablekey;
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
