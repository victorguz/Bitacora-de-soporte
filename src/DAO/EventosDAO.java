/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.Controller;
import Model.Evento;
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
public class EventosDAO implements CRUD<Evento, Integer> {

    Connection conex;

    final String INSERT = "INSERT INTO EventoS (nombre,descripcion,ticketkey,fecha,hora)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
    final String ALL = "SELECT eventokey,nombre,descripcion,ticketkey,fecha,hora FROM EVENTOS";
    final String LIKE = "SELECT eventokey,nombre,descripcion,ticketkey,fecha,hora FROM EVENTOS order by nombre like %?%";
    final String ONE = "SELECT eventokey,nombre,descripcion,ticketkey,fecha,hora FROM EVENTOS where eventokey = ?";

    public EventosDAO(Connection conex) {
        this.conex = conex;
    }

    @Override
    public void insert(Evento a) throws DAOException {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(INSERT);
            s.setString(1, a.getNombre());
            s.setString(2, a.getDescripcion());
            s.setInt(3, a.getTicket().getTicketkey());
            s.setDate(4, Date.valueOf(LocalDate.now()));
            s.setTime(5, Time.valueOf(LocalTime.now()));
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Evento");
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
        }
    }

    @Override
    public void update(Evento a) {
    }

    @Override
    public void desactivate(Evento a) {
    }

    @Override
    public Evento select(Integer dato) throws DAOException {
        PreparedStatement s = null;
        ResultSet rs = null;
        Evento c = null;
        try {
            s = conex.prepareStatement(ONE);
            s.setInt(1, dato);
            rs = s.executeQuery();
            if (rs.next()) {
                c = convertir(rs);
            } else {
                throw new SQLException("Evento no encontrado");
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
        }
        return c;
    }

    @Override
    public ObservableList<Evento> all() throws DAOException {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Evento> Eventos = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(ALL);
            rs = s.executeQuery();
            while (rs.next()) {
                Eventos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
        }
        return Eventos;
    }

    @Override
    public ObservableList<Evento> like(String dato) throws DAOException {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Evento> l = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(LIKE);
            s.setString(1, dato.toLowerCase());
            rs = s.executeQuery();
            while (rs.next()) {
                l.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    throw new DAOException(ex);
                }
            }
        }
        return l;
    }

    @Override
    public Evento convertir(ResultSet rs) throws DAOException {
        try {
            Evento c = new Evento();
            c.setEventokey(rs.getInt("Eventokey"));
            c.setNombre(rs.getString("nombre"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setTicket(Controller.getTickets().select(rs.getInt("ticketkey")));
            c.setFecha(rs.getDate("fecha").toLocalDate());
            c.setHora(rs.getTime("hora").toLocalTime());
            return c;
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }
}
