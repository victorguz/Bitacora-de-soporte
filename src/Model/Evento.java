/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Esta clase gestiona los eventos de las acciones que se pueden realizar en
 * esta app.
 * Estos eventos funcionan para realizar estadisticas tales como: 
 * -Tickets aplazados
 * -Tickets terminados
 * -Tickets eliminados
 * -Usuarios creados
 * -Usuarios 
 *
 * @author Licmora
 */
public class Evento {

    private int eventokey=0;
    /**
     * Evento de ticket: Eliminacion o modificacion de ticket. Evento de
     * usuario: Eliminacion o modificacion de usuario.
     */
    private String nombreEvento;
    //Es una descripcion de los eventos que se pueden realizar en esta app.
    private String descripcion;
    //Si está asociado a un ticket
    private Ticket ticketkey;
    //Si está asociado a un usuario
    private Usuario usuariokey;

    public Evento() {
    }

    public Evento(int eventokey, String nombreEvento, String descripcion, Ticket ticketkey, Usuario usuariokey) {
        this.eventokey = eventokey;
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
        this.ticketkey = ticketkey;
        this.usuariokey = usuariokey;
    }

    

    public int getEventokey() {
        return eventokey;
    }

    public void setEventokey(int eventokey) {
        this.eventokey = eventokey;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ticket getTicketkey() {
        return ticketkey;
    }

    public void setTicketkey(Ticket ticketkey) {
        this.ticketkey = ticketkey;
    }

    public Usuario getUsuariokey() {
        return usuariokey;
    }

    public void setUsuariokey(Usuario usuariokey) {
        this.usuariokey = usuariokey;
    }
@Override
    public String toString() {
        return "El usuario " + usuariokey + " realizó la siguiente acción: "
                + nombreEvento + " en el ticket " + ticketkey;
    }
}
