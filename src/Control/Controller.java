/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAOManager;
import DAO.DatosDAO;
import DAO.EventosDAO;
import DAO.TicketsDAO;
import DAO.UsuariosDAO;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.Color;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author 57300
 */
public class Controller {

    private static DAOManager manager;

    private static DAOManager getManager() {
        if (manager == null) {
            manager = new DAOManager();
        }
        return manager;
    }

    public static TicketsDAO getTickets() {
        return getManager().getTickets();
    }

    public static UsuariosDAO getUsuarios() {
        return getManager().getUsuarios();
    }

    public static EventosDAO getEventos() {
        return getManager().getEventos();
    }

    public static DatosDAO getDatos() {
        return getManager().getDatos();
    }

    public static void mensaje(String mensaje, String tipo) {
        NotifyTheme nt = NotifyTheme.Light;
        nt.setBgGrad(Color.white, Color.LIGHT_GRAY);
        DesktopNotify.setDefaultTheme(nt);
        int notify = 0;
        if (tipo.equalsIgnoreCase("aviso")) {
            notify = DesktopNotify.TIP;
        } else if (tipo.equalsIgnoreCase("exito")) {
            notify = DesktopNotify.SUCCESS;
        } else if (tipo.equalsIgnoreCase("info")) {
            notify = DesktopNotify.INFORMATION;
        } else if (tipo.equalsIgnoreCase("vacio")) {
            notify = DesktopNotify.INPUT_REQUEST;
        }
        DesktopNotify.showDesktopMessage(tipo.toUpperCase(), mensaje, notify, 5000, null);
    }

    public static void excepcion(Exception ex) {
        NotifyTheme nt = NotifyTheme.Light;
        nt.setBgGrad(Color.white, Color.LIGHT_GRAY);
        DesktopNotify.setDefaultTheme(nt);
        if (ex.getMessage().contains("sql")) {
            DesktopNotify.showDesktopMessage("AVISO", getResultOrException(ex.getMessage()), DesktopNotify.ERROR, 10000, (e) -> {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            });
        } else {
            DesktopNotify.showDesktopMessage("Error", getResultOrException(ex.getMessage()), DesktopNotify.ERROR, 10000, (e) -> {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            });
        }
    }

    public static String getResultOrException(String ex) {
        if (ex.contains("medidas.clienteKey, medidas.fecha")) {
            return "Este cliente ya tiene medidas en esta fecha";
        } else if (ex.contains("clientes.identificacion")) {
            return "Ya existe un cliente con esta identificación";
        } else if (ex.contains("planes.nombre")) {
            return "Ya existe un plan con este nombre";
        } else if (ex.contains("alxdiet.plankey, alxdiet.alimentokey, alxdiet.momento")) {
            return "Ya añadiste este alimento para este momento del día";
        } else if (ex.contains("ejercicios.nombre")) {
            return "Ya existe un ejercicio con este nombre";
        } else if (ex.contains("alimentos.nombre")) {
            return "Ya existe un alimento con este nombre";
        } else if (ex.contains("NOT NULL")) {
            String i = ex.substring(ex.indexOf("NOT NULL"));
            return "Digite un " + i.substring(i.indexOf(".") + 1, i.indexOf(")"));
        } else if (ex.contains("no such table: ")) {
            String i = ex.substring(ex.indexOf("no such table: "), ex.indexOf(")")).toLowerCase();
            return "No se encontró la tabla " + i + ", contacte al programador";
        } else if (ex.contains("no such column: ")) {
            String i = ex.substring(ex.indexOf("no such column: "));
            return "No se encontró la columna " + i + ", contacte al programador";
        } else if (ex.contains("ejxrut.plankey, ejxrut.ejerciciokey, ejxrut.momento")) {
            return "Ya añadiste este ejercicio para este momento del día";
        } else {
            return ex;
        }
    }

    public static void fadeTransition(Node node, int time) {
        FadeTransition ft = new FadeTransition(Duration.millis(time));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
}
