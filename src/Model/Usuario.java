/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Victorguz
 */
public class Usuario {

    private int usuariokey;
    private String username;
    private String password;
    private String nombre;
    private String empresa;
    private String area;

    /**
     * Los roles definen que se puede hacer en la app: -Usuario bitacora: Tiene
     * total control de la app, puede gestionar usuarios y tickets. -Usuario de
     * ticket: Tiene control sobre sus propios tickets y de posponerlos, lo cual
     * se avisa de inmediato al responsable de bitacora.
     */
    private String rol;
    private String estado;
    private boolean sesion;//El estado de la sesion

    public Usuario() {
    }

    public Usuario(int usuariokey, String username, String password, String nombre, String empresa, String area, String rol) {
        this.usuariokey = usuariokey;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.empresa = empresa;
        this.area = area;
        this.rol = rol;
    }

    public int getUsuariokey() {
        return usuariokey;
    }

    public void setUsuariokey(int usuariokey) {
        this.usuariokey = usuariokey;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isEmpty() {
        return getUsername().isEmpty()
                || getNombre().isEmpty()
                || getPassword().isEmpty()
                || getRol().isEmpty();
    }

    public boolean getSesion() {
        return sesion;
    }

    public void setSesion(boolean sesion) {
        this.sesion = sesion;
    }
}
