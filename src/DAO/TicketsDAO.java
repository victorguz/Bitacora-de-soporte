/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.Controller;
import Model.Ticket;
import Model.Ticket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Victorguz
 */
public class TicketsDAO implements CRUD<Ticket, Integer> {

    Connection conex;

    final String INSERT = "INSERT INTO TicketS (tipo, empresa, area, solicitante, "
            + "medio, incidente, detalles, observacion, responsablekey, "
            + "estado, clasificacion, fechaSolicitud, horaSolicitud, "
            + "fechaAproximada, horaAproximada, fechaInicio, horaInicio, "
            + "fechaFin, horaFin)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String ALL = "SELECT ticketkey, tipo, empresa, area, solicitante, "
            + "medio, incidente, detalles, observacion, responsablekey, "
            + "estado, clasificacion, fechaSolicitud, horaSolicitud, "
            + "fechaAproximada, horaAproximada, fechaInicio, horaInicio, "
            + "fechaFin, horaFin FROM TICKETS limit 100";
    final String LIKE = "SELECT ticketkey, tipo, empresa, area, solicitante, "
            + "medio, incidente, detalles, observacion, responsablekey, "
            + "estado, clasificacion, fechaSolicitud, horaSolicitud, "
            + "fechaAproximada, horaAproximada, fechaInicio, horaInicio, "
            + "fechaFin, horaFin FROM TICKETS order by tipo like %?% limit 50";
    final String ONE = "SELECT ticketkey, tipo, empresa, area, solicitante, "
            + "medio, incidente, detalles, observacion, responsablekey, "
            + "estado, clasificacion, fechaSolicitud, horaSolicitud, "
            + "fechaAproximada, horaAproximada, fechaInicio, horaInicio, "
            + "fechaFin, horaFin FROM TICKETS ticketkey = ?";
    final String UPDATE = "UPDATE TicketS SET tipo = ?, empresa = ?, area = ?, solicitante = ?, "
            + "medio = ?, incidente = ?, detalles = ?, observacion = ?, responsablekey = ?, "
            + "estado = ?, clasificacion = ?, fechaSolicitud = ?, horaSolicitud = ?, "
            + "fechaAproximada = ?, horaAproximada = ?, fechaInicio = ?, horaInicio = ?, "
            + "fechaFin = ?, horaFin = ? WHERE Ticketkey = ?";
    final String DESACTIVATE = "update Tickets set estado = ? where Ticketkey = ?";

    public TicketsDAO(Connection conex) {
        this.conex = conex;
    }

    @Override
    public void insert(Ticket a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(INSERT);
            s.setString(1, a.getTipo());
            s.setString(2, a.getEmpresa());
            s.setString(3, a.getArea());
            s.setString(4, a.getSolicitante());
            s.setString(5, a.getMedio());
            s.setString(6, a.getIncidente());
            s.setString(7, a.getDetalles());
            s.setString(8, a.getObservacion());
            s.setInt(9, a.getResponsable().getUsuariokey());
            s.setString(10, a.getEstado());
            s.setString(11, a.getClasificacion());
            s.setDate(12, Date.valueOf(a.getFechaSolicitud()));
            s.setTime(13, Time.valueOf(a.getHoraSolicitud()));
            s.setDate(14, Date.valueOf(a.getFechaAproximada()));
            s.setTime(15, Time.valueOf(a.getHoraAproximada()));
            s.setDate(16, Date.valueOf(a.getFechaInicio()));
            s.setTime(17, Time.valueOf(a.getHoraInicio()));
            s.setDate(18, Date.valueOf(a.getFechaFin()));
            s.setTime(19, Time.valueOf(a.getHoraFin()));
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Ticket");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Ticket a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(UPDATE);
            s.setString(1, a.getTipo());
            s.setString(2, a.getEmpresa());
            s.setString(3, a.getArea());
            s.setString(4, a.getSolicitante());
            s.setString(5, a.getMedio());
            s.setString(6, a.getIncidente());
            s.setString(7, a.getDetalles());
            s.setString(8, a.getObservacion());
            s.setInt(9, a.getResponsable().getUsuariokey());
            s.setString(10, a.getEstado());
            s.setString(11, a.getClasificacion());
            s.setDate(12, Date.valueOf(a.getFechaSolicitud()));
            s.setTime(13, Time.valueOf(a.getHoraSolicitud()));
            s.setDate(14, Date.valueOf(a.getFechaAproximada()));
            s.setTime(15, Time.valueOf(a.getHoraAproximada()));
            s.setDate(16, Date.valueOf(a.getFechaInicio()));
            s.setTime(17, Time.valueOf(a.getHoraInicio()));
            s.setDate(18, Date.valueOf(a.getFechaFin()));
            s.setTime(19, Time.valueOf(a.getHoraFin()));
            s.setInt(20, a.getTicketkey());
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Ticket");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void desactivate(Ticket a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(DESACTIVATE);
            s.setString(1, "inactivo");
            s.setInt(2, a.getTicketkey());
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Ticket");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Ticket select(Integer dato) {
        PreparedStatement s = null;
        ResultSet rs = null;
        Ticket c = null;
        try {
            s = conex.prepareStatement(ONE);
            s.setInt(1, dato);
            rs = s.executeQuery();
            if (rs.next()) {
                c = convertir(rs);
            } else {
                throw new SQLException("Cliente no encontrado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return c;
    }

    @Override
    public ObservableList<Ticket> all() {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Ticket> clientes = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(ALL);
            rs = s.executeQuery();
            while (rs.next()) {
                clientes.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return clientes;
    }

    @Override
    public ObservableList<Ticket> like(String dato) {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Ticket> l = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(LIKE);
            s.setString(1, dato.toLowerCase());
            rs = s.executeQuery();
            while (rs.next()) {
                l.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return l;
    }

    @Override
    public Ticket convertir(ResultSet rs) {
        try {
            Ticket a = new Ticket();
            a.setTipo(rs.getString("tipo"));
            a.setEmpresa(rs.getString("empresa"));
            a.setArea(rs.getString("area"));
            a.setSolicitante(rs.getString("solicitante"));
            a.setMedio(rs.getString("medio"));
            a.setIncidente(rs.getString("incidente"));
            a.setDetalles(rs.getString("detalles"));
            a.setObservacion(rs.getString("observacion"));
            a.setResponsable(Controller.getUsuarios().select(rs.getInt("ticketkey")));
            a.setEstado(rs.getString("estado"));
            a.setClasificacion(rs.getString("clasificacion"));
            a.setFechaSolicitud(rs.getDate("fechasolicitud").toLocalDate());
            a.setHoraSolicitud(rs.getTime("horasolicitud").toLocalTime());
            a.setFechaAproximada(rs.getDate("fechaAproximada").toLocalDate());
            a.setHoraAproximada(rs.getTime("horaAproximada").toLocalTime());
            a.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            a.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
            a.setFechaFin(rs.getDate("fechaFin").toLocalDate());
            a.setHoraFin(rs.getTime("horaFin").toLocalTime());
            a.setTicketkey(rs.getInt("ticketkey"));
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
