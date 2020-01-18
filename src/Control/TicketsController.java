/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAOException;
import Model.Dato;
import Model.Ticket;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Licmora
 */
public class TicketsController extends Controller implements Initializable {

    @FXML
    private TextField textBuscar;

    @FXML
    private ComboBox<Ticket> comboTickets;

    @FXML
    private TextField textTicket;

    @FXML
    private TextField textSolicitante;

    @FXML
    private TextField textEmpresa;

    @FXML
    private TextField textArea;

    @FXML
    private TextField textMedio;

    @FXML
    private TextField textIncidencia;

    @FXML
    private TextArea textDetalle;

    @FXML
    private TextField textResponsable;

    @FXML
    private TextField textEstado;

    @FXML
    private CheckBox checkSolicitud;

    @FXML
    private JFXDatePicker fechaSolicitud;

    @FXML
    private JFXDatePicker horaSolicitud;

    @FXML
    private CheckBox checkRespuesta;

    @FXML
    private JFXDatePicker fechaRespuesta;

    @FXML
    private JFXDatePicker horaRespuesta;

    @FXML
    private JFXDatePicker fechaInicio;

    @FXML
    private JFXDatePicker horaInicio;

    @FXML
    private JFXDatePicker fechaFin;

    @FXML
    private JFXDatePicker horaFin;

    @FXML
    private TextField textFechaFin;

    @FXML
    private TextField textFechaInicio;

    @FXML
    private TextField textFechaSolicitud;

    @FXML
    private TextField textFechaRespuesta;

    @FXML
    private TextArea textObservacion;

    @FXML
    private TextArea textTicketRespuesta;

    ObservableList<Ticket> tickets = FXCollections.observableArrayList();

    ObservableList<String> solicitantes = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoSolicitantes;

    ObservableList<String> empresas = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoEmpresas;

    ObservableList<String> incidencias = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoIncidencias;

    ObservableList<String> areas = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoAreas;

    ObservableList<String> medios = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoMedios;

    ObservableList<String> responsables = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoResponsables;

    ObservableList<String> estados = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoEstados;

    ObservableList<String> buscar = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoBuscar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setDatos();
        fechaSolicitud.setValue(LocalDate.now());
        horaSolicitud.setTime(LocalTime.now());
        fechaRespuesta.setValue(LocalDate.now());
        horaRespuesta.setTime(LocalTime.now());
        setFechaFin();
        setFechaInicio();
        setFechaSolicitud();
        setFechaRespuesta();
    }

    public void addSolicitante() {
        if (!textSolicitante.getText().isEmpty()) {
            if (!solicitantes.contains(textSolicitante.getText())) {
                try {
                    addBuscar(textSolicitante.getText());
                    solicitantes.add(textSolicitante.getText());
                    getDatos().insert(new Dato("solicitante", textSolicitante.getText().toUpperCase()));
                    if (autoSolicitantes != null) {
                        autoSolicitantes.dispose();
                    }
                    autoSolicitantes = TextFields.bindAutoCompletion(textSolicitante, solicitantes);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addEmpresa() {
        if (!textEmpresa.getText().isEmpty()) {
            if (!empresas.contains(textEmpresa.getText())) {
                try {
                    addBuscar(textEmpresa.getText());
                    empresas.add(textEmpresa.getText());
                    getDatos().insert(new Dato("empresa", textEmpresa.getText().toUpperCase()));
                    if (autoEmpresas != null) {
                        autoEmpresas.dispose();
                    }
                    autoEmpresas = TextFields.bindAutoCompletion(textEmpresa, empresas);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addArea() {
        if (!textArea.getText().isEmpty()) {
            if (!areas.contains(textArea.getText())) {
                try {
                    addBuscar(textArea.getText());
                    areas.add(textArea.getText());
                    getDatos().insert(new Dato("area", textArea.getText().toUpperCase()));
                    if (autoAreas != null) {
                        autoAreas.dispose();
                    }
                    autoAreas = TextFields.bindAutoCompletion(textArea, areas);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addIncidencia() {
        if (!textIncidencia.getText().isEmpty()) {
            if (!incidencias.contains(textIncidencia.getText())) {
                try {
                    addBuscar(textIncidencia.getText());
                    incidencias.add(textIncidencia.getText());
                    getDatos().insert(new Dato("incidencia", textIncidencia.getText().toUpperCase()));
                    if (autoIncidencias != null) {
                        autoIncidencias.dispose();
                    }
                    autoIncidencias = TextFields.bindAutoCompletion(textIncidencia, incidencias);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addMedio() {
        if (!textMedio.getText().isEmpty()) {
            if (!medios.contains(textMedio.getText())) {
                try {
                    addBuscar(textMedio.getText());
                    medios.add(textMedio.getText());
                    getDatos().insert(new Dato("medio", textMedio.getText().toUpperCase()));
                    if (autoMedios != null) {
                        autoMedios.dispose();
                    }
                    autoMedios = TextFields.bindAutoCompletion(textMedio, medios);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addResponsable() {
        if (!textResponsable.getText().isEmpty()) {
            if (!responsables.contains(textResponsable.getText())) {
                try {
                    addBuscar(textResponsable.getText());
                    responsables.add(textResponsable.getText());
                    getDatos().insert(new Dato("responsable", textResponsable.getText().toUpperCase()));
                    if (autoResponsables != null) {
                        autoResponsables.dispose();
                    }
                    autoResponsables = TextFields.bindAutoCompletion(textResponsable, responsables);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addEstado() {
        if (!textEstado.getText().isEmpty()) {
            if (!estados.contains(textEstado.getText())) {
                try {
                    addBuscar(textEstado.getText());
                    estados.add(textEstado.getText());
                    getDatos().insert(new Dato("estado", textEstado.getText().toUpperCase()));
                    if (autoEstados != null) {
                        autoEstados.dispose();
                    }
                    autoEstados = TextFields.bindAutoCompletion(textEstado, estados);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addBuscar(String text) {
        if (!buscar.contains(text)) {
            buscar.add(text);
            autoBuscar = TextFields.bindAutoCompletion(textBuscar, buscar);
        }
    }

    public void setDatos() {
        try {
            ObservableList<Dato> datos = getDatos().all();
            setBuscar(datos);
            for (Dato dato : datos) {
                if (dato.getNombre().equalsIgnoreCase("medio")) {
                    medios.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("incidencia")) {
                    incidencias.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("area")) {
                    areas.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("empresa")) {
                    empresas.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("solicitante")) {
                    solicitantes.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("responsable")) {
                    responsables.add(dato.getDato());
                }
            }
            autoSolicitantes = TextFields.bindAutoCompletion(textSolicitante, solicitantes);
            autoEmpresas = TextFields.bindAutoCompletion(textEmpresa, empresas);
            autoAreas = TextFields.bindAutoCompletion(textArea, areas);
            autoIncidencias = TextFields.bindAutoCompletion(textIncidencia, incidencias);
            autoMedios = TextFields.bindAutoCompletion(textMedio, medios);
            autoResponsables = TextFields.bindAutoCompletion(textResponsable, responsables);
        } catch (DAOException ex) {
            excepcion(ex);
        }

    }

    public void setBuscar(ObservableList<Dato> datos) {
        for (Dato dato : datos) {
            buscar.add(dato.getDato());
        }
        autoBuscar = TextFields.bindAutoCompletion(textBuscar, buscar);
    }

    public void buscar() {
        try {
            tickets = getTickets().like(textBuscar.getText());
            comboTickets.getItems().setAll(tickets);
        } catch (DAOException ex) {
            excepcion(ex);
        }
    }

    public void crear() {
        Ticket a = captar();
        if (a.isEmpty()) {
            mensaje("A este ticket le faltan datos", "Error");
        } else {
            try {
                getTickets().insert(a);
            } catch (DAOException ex) {
                excepcion(ex);
            }
        }
    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public Ticket captar() {
        Ticket a = new Ticket();
        a.setTicket(textTicket.getText());
        a.setSolicitante(textSolicitante.getText());
        a.setEmpresa(textEmpresa.getText());
        a.setArea(textArea.getText());
        a.setMedio(textMedio.getText());
        a.setIncidente(textIncidencia.getText());
        a.setDetalles(textDetalle.getText());
        a.setResponsable(textResponsable.getText());
        a.setEstado(textEstado.getText());
        a.setFechaSolicitud(fechaSolicitud.getValue());
        a.setHoraSolicitud(horaSolicitud.getTime());
        a.setFechaAproximada(fechaRespuesta.getValue());
        a.setHoraAproximada(horaRespuesta.getTime());
        a.setFechaInicio(fechaInicio.getValue());
        a.setHoraInicio(fechaInicio.getTime());
        a.setFechaFin(fechaFin.getValue());
        a.setHoraFin(fechaFin.getTime());
        a.setObservacion(textObservacion.getText());
        return a;
    }

    public void mostrar(Ticket a) {
        if (a != null) {
            textTicket.setText(a.getTicket());
            textSolicitante.setText(a.getSolicitante());
            textEmpresa.setText(a.getEmpresa());
            textArea.setText(a.getArea());
            textMedio.setText(a.getMedio());
            textIncidencia.setText(a.getIncidente());
            textDetalle.setText(a.getDetalles());
            textResponsable.setText(a.getResponsable());
            textEstado.setText(a.getEstado());
        } else {
            mensaje("No hay nada que mostrar", "error");
        }
    }

    public void getTicket() {
        if (!textTicket.getText().isEmpty()) {
            try {
                Ticket a = getTickets().select(textTicket.getText());
                mostrar(a);
            } catch (DAOException ex) {
                excepcion(ex);
            }
        }
    }

    public void disableSolicitud() {
        if (checkSolicitud.isSelected()) {
            fechaSolicitud.setDisable(true);
            horaSolicitud.setDisable(true);
        } else {
            fechaSolicitud.setDisable(false);
            horaSolicitud.setDisable(false);
        }
    }

    public void disableRespuesta() {
        if (checkRespuesta.isSelected()) {
            fechaRespuesta.setDisable(true);
            horaRespuesta.setDisable(true);
        } else {
            fechaRespuesta.setDisable(false);
            horaRespuesta.setDisable(false);
        }
    }

    public void setFechaSolicitud() {
        textFechaSolicitud.setText(fechaSolicitud.getValue() + " " + ((horaSolicitud.getTime() == null) ? null : horaSolicitud.getTime().toString().substring(0, 5)));
    }

    public void setFechaRespuesta() {
        textFechaRespuesta.setText(fechaRespuesta.getValue() + " " + ((horaRespuesta.getTime() == null) ? null : horaRespuesta.getTime().toString().substring(0, 5)));
    }

    public void setFechaInicio() {
        textFechaInicio.setText(fechaInicio.getValue() + " " + ((horaInicio.getTime() == null) ? null : horaInicio.getTime().toString().substring(0, 5)));
    }

    public void setFechaFin() {
        textFechaFin.setText(fechaFin.getValue() + " " + ((horaFin.getTime() == null) ? null : horaFin.getTime().toString().substring(0, 5)));
    }

    public void updated() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        //TODO HERE
                        if (checkRespuesta.isSelected()) {
                            fechaRespuesta.setValue(LocalDate.now());
                            horaRespuesta.setTime(LocalTime.now());
                            setFechaRespuesta();
                        }
                        if (checkSolicitud.isSelected()) {
                            fechaSolicitud.setValue(LocalDate.now());
                            horaSolicitud.setTime(LocalTime.now());
                            setFechaSolicitud();
                        }

                    }
                };
                while (true) {
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException ex) {
                    }
                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
