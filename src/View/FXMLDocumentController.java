/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Licmora
 */
public class FXMLDocumentController implements Initializable {
    
    VBox Config;
    VBox Dash;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Config = FXMLLoader.load(new File("src/vista/fxml/Config.fxml").toURL());
            Dash = FXMLLoader.load(new File("src/vista/fxml/Dash.fxml").toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
