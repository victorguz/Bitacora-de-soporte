/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Licmora
 */
public class Ticket {

    /**
     * Clave primaria
     */
    private int ticketkey;
    private int ticket;
    private String tipo;
    private String empresa;
    private String area;
    private String solicitante;
    private String medio;
    private String incidente;
    /**
     * Informacion para quien hace el ticket
     */
    private String detalles;
    /**
     * Cuando se resuelve el ticket se muestra este dato
     */
    private String observacion;
    private Responsable responsable;
    private String estado;
    /**
     * Cuando un ticket es modificado se le asigna un nuevo ticketkey y
     * almacenarlo aquí será lo que dice quien es el que se muestra en la lista,
     * para que no se repitan.
     */
    private int nuevoticket;
    private LocalDate modificado;
    private LocalDate fechaSolicitud;
    private LocalTime horaSolicitud;
    /**
     * Hora aproximada de respuesta
     */
    private LocalTime horaAproximada;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public int getTicketkey() {
        return ticketkey;
    }

    public void setTicketkey(int ticketkey) {
        this.ticketkey = ticketkey;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getIncidente() {
        return incidente;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNuevoticket() {
        return nuevoticket;
    }

    public void setNuevoticket(int nuevoticket) {
        this.nuevoticket = nuevoticket;
    }

    public LocalDate getModificado() {
        return modificado;
    }

    public void setModificado(LocalDate modificado) {
        this.modificado = modificado;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalTime getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(LocalTime horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public LocalTime getHoraAproximada() {
        return horaAproximada;
    }

    public void setHoraAproximada(LocalTime horaAproximada) {
        this.horaAproximada = horaAproximada;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    

}
