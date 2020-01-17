/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase gestiona los eventos de las acciones que se pueden realizar en
 * esta app. Estos eventos funcionan para realizar estadisticas tales como:
 -Ticket aplazados -Ticket terminados -Ticket eliminados -Usuarios creados
 -Usuarios
 *
 * @author Victorguz
 */
public class Evento {

    private int eventokey = 0;
    /**
     * Evento de ticket: Eliminacion o modificacion de ticket. Evento de
     * usuario: Eliminacion o modificacion de usuario.
     */
    private String nombre;
    //Es una descripcion de los eventos que se pueden realizar en esta app.
    private String descripcion;
    //Si está asociado a un ticket
    private Ticket ticket;
    private LocalDate fecha;
    private LocalTime hora;

    public Evento() {
    }

    public Evento(int eventokey, String nombreEvento, String descripcion, Ticket ticketkey) {
        this.eventokey = eventokey;
        this.nombre = nombreEvento;
        this.descripcion = descripcion;
        this.ticket = ticketkey;
    }

    public int getEventokey() {
        return eventokey;
    }

    public void setEventokey(int eventokey) {
        this.eventokey = eventokey;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Se realizó la siguiente acción: "
                + getNombre() + " en el ticket " + getTicket().getTicketkey() +" "+getTicket().getIncidente();
    }

}
