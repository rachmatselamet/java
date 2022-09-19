/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformjfx1;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML_outputController implements Initializable {

    @FXML
    private Label lblpembeli;
    @FXML
    private Label lbljenisrumah;
    @FXML
    private Label lblhargarumah;
    @FXML
    private Label lblluastanah;
    @FXML
    private Label lblhargatanah;
    @FXML
    private Label lblhasiltanah;
    @FXML
    private Label lblsubtotal;
    @FXML
    private Label lblpajak;
    @FXML
    private Label lbltotal;
    @FXML
    private Button btnkembali;

    /**
     * Initializes the controller class.
     * @param d
     */
    
    public void getdata(multiformJFX1model d){
        int hrumah=0,htanah=0,pajak=0;
        String jenis="";
        switch(d.getPilihjenis()){
            case 0 :  hrumah=FXMLDocumentController.dtharga.getHrsederhana();
                      htanah=FXMLDocumentController.dtharga.getHtsederhana();                      
                      jenis="Sederhana";pajak=0;break;
            case 1 :  hrumah=FXMLDocumentController.dtharga.getHrmenengah();
                      htanah=FXMLDocumentController.dtharga.getHtmenengah();
                      jenis="Menengah";pajak=0;break;
            case 2 :  hrumah=FXMLDocumentController.dtharga.getHrmewah();
                      htanah=FXMLDocumentController.dtharga.getHtmewah();
                      jenis="Mewah";pajak=(int)Math.round(hrumah*0.1);break;
            default : jenis="tidak ada";hrumah=0;htanah=0;pajak=0;                      
        }
        int hasiltanah=htanah*d.getLuas();
        int sub=hasiltanah+hrumah;
        int total=sub+pajak;
        
        lblpembeli.setText(d.getPembeli());        
        lbljenisrumah.setText(jenis);
        lblhargarumah.setText(String.valueOf(hrumah));
        lblluastanah.setText(String.valueOf(d.getLuas()));
        lblhargatanah.setText(String.valueOf(htanah));
        lblhasiltanah.setText(String.valueOf(hasiltanah));
        lblsubtotal.setText(String.valueOf(sub));
        lblpajak.setText(String.valueOf(pajak));
        lbltotal.setText(String.valueOf(total));        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void kembaliklik(ActionEvent event) {
        btnkembali.getScene().getWindow().hide();;    
    }
    
}
