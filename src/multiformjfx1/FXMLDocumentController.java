/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformjfx1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
//import javafx.scene.control.
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    
    private multiformJFX1model dt=new multiformJFX1model();
    public static model_harga dtharga=new model_harga();
    
    @FXML
    private ChoiceBox<String> chbjenis;
    @FXML
    private TextField txtluas;
    @FXML
    private TextField txtpembeli;
    @FXML
    private AnchorPane acp;
    @FXML
    private Button btnmodal;
    @FXML
    private Button btnmodel;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnubahharga;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chbjenis.setItems(FXCollections.observableArrayList(
        "Sederhana","Menengah","Mewah"));
        chbjenis.getSelectionModel().select(0);
        
        dtharga.setHrsederhana(50000000);
        dtharga.setHrmenengah(100000000);
        dtharga.setHrmewah(500000000);
        dtharga.setHtsederhana(500000);
        dtharga.setHtmenengah(800000);
        dtharga.setHtmewah(2000000);
        
        //chbjenis.getScene().getWindow().
/*                setOnCloseRequest(evt -> {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close this applicetion?", ButtonType.YES, ButtonType.NO);
    ButtonType result = alert.showAndWait().orElse(ButtonType.NO);

    if (ButtonType.NO.equals(result)) {
      // no choice or no clicked -> don't close
      evt.consume();
    }
  });*/
/*        chbjenis.getScene().getWindow().setOnCloseRequest(new 
        EventHandler<WindowEvent>() {
            public void handle(final WindowEvent windowEvent) {
                //if(JOptionPane.showConfirmDialog(
                        
                  //      , "Mau keluar","Exit",JOptionPane.YES_NO_OPTION)==0)
                   windowEvent.consume();
            }
        });*/
    }    

    @FXML
    private void modalklik(ActionEvent event) {
        if(txtluas.getText().isEmpty()){
            do{
                TextInputDialog tx=new TextInputDialog();                
                tx.setContentText("Masukkan luas tanah:");
                tx.setTitle("Input luas tanah");
                tx.showAndWait();
                txtluas.setText(tx.getResult());
            }while(txtluas.getText().isEmpty());
        }
        dt.setLuas(Integer.parseInt(txtluas.getText()));
        dt.setPembeli(txtpembeli.getText());
        dt.setPilihjenis(chbjenis.getSelectionModel().getSelectedIndex());
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_output.fxml"));    
        Parent root = (Parent)loader.load();
        FXML_outputController isidt=(FXML_outputController)loader.getController();
        isidt.getdata(dt);

        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
        
        
    }

    @FXML
    private void modelklik(ActionEvent event) {
        
        if(txtluas.getText().isEmpty()){
            ChoiceDialog<String> pilih=new ChoiceDialog<String>(chbjenis.getItems().get(0),
                    chbjenis.getItems());
            pilih.setContentText("Pilih jenis rumah:");            
            pilih.showAndWait();
            chbjenis.getSelectionModel().select(pilih.getResult());
            
            Alert al=new Alert(Alert.AlertType.ERROR, "Masukkan luas tanah",
                    ButtonType.OK);
            al.showAndWait();
            txtluas.requestFocus();
        }else{
        
        dt.setLuas(Integer.parseInt(txtluas.getText()));
        dt.setPembeli(txtpembeli.getText());
        dt.setPilihjenis(chbjenis.getSelectionModel().getSelectedIndex());
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_output.fxml"));    
        Parent root = (Parent)loader.load();
        FXML_outputController isidt=(FXML_outputController)loader.getController();
        isidt.getdata(dt);

        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.setScene(scene);
        stg.show();        
        
//        acp.getChildren().setAll(root);
        
        //((Stage)acp.getScene().getWindow()).setScene(scene);
        
        } catch (IOException e){   e.printStackTrace();   }
        
        }
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        txtpembeli.setText("");
        txtluas.setText("");
        chbjenis.getSelectionModel().select(0);
        txtpembeli.requestFocus();
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }
    /*JavaFx 2.0 main window closes despite event being consumed
 import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Test extends Application {
  @Override
  public void start(final Stage stage) throws Exception {
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
      public void handle(final WindowEvent windowEvent) {
        windowEvent.consume();
      }
    });
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
origin: stackoverflow.com
Prevent/Cancel closing of primary stage in JavaFX 2.2
 import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Boom extends Application {
  @Override
  public void start(final Stage primary)  {
    System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
    primary.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent e) {
        e.consume();
      }
    });
    primary.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}*/

    @FXML
    private void ubahhargaklik(ActionEvent event) {
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_ubahharga.fxml"));    
        Parent root = (Parent)loader.load();

        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
}
