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
 * @author Victorguz
 */
public class Ticket {

    /**
     * Clave primaria
     */
    private int ticketkey;
    private String tipo;
    private String empresa;
    private String area;
    private String solicitante;
    private String medio;
    private String incidente;
    private String detalles;
    private String observacion;
    private String responsable;
    private String estado;
    private String clasificacion;//Software o hardware
    private LocalDate fechaSolicitud;
    private LocalDate fechaAproximada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaSolicitud;
    private LocalTime horaAproximada;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public int getTicketkey() {
        return ticketkey;
    }

    public void setTicketkey(int ticketkey) {
        this.ticketkey = ticketkey;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaAproximada() {
        return fechaAproximada;
    }

    public void setFechaAproximada(LocalDate fechaAproximada) {
        this.fechaAproximada = fechaAproximada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(LocalTime horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }
    

}
