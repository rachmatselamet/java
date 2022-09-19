/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformjfx1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class MultiFormJFX1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);        
        stage.setOnCloseRequest(new 
        EventHandler<WindowEvent>() {
            public void handle(final WindowEvent windowEvent) {
                    Alert al=new Alert(Alert.AlertType.CONFIRMATION, "Mau Keluar?",
                    ButtonType.OK,ButtonType.CANCEL);
                    al.showAndWait();
                    if(al.getResult()==ButtonType.CANCEL) windowEvent.consume();
            }
        });        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
