package j316;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtSend;

    @FXML
    private TextField txtHost;

    @FXML
    private TextField txtPort;

    @FXML
    private Label txtStatus;

    @FXML
    private Slider sldLoben;

    private RowCommunicator rc = new RowCommunicator();

    public void textTemplateLHI(){
        this.txtSend.setText("LH I ");
        this.txtSend.requestFocus();
    }

    public void textTemplateLHII(){
        this.txtSend.setText("LH II ");
        this.txtSend.requestFocus();
    }

    public void textTemplateLHIII(){
        this.txtSend.setText("LH III ");
        this.txtSend.requestFocus();
    }

    public void textTemplateSdH(){
        this.txtSend.setText("SdH ");
        this.txtSend.requestFocus();
    }

    public void textTemplateCHI(){
        this.txtSend.setText("CH I ");
        this.txtSend.requestFocus();
    }

    public void textTemplateCHII(){
        this.txtSend.setText("CH II ");
        this.txtSend.requestFocus();
    }

    public void textTemplateCHIII(){
        this.txtSend.setText("CH III ");
        this.txtSend.requestFocus();
    }

    /**
     * Sends input text
     */
    public void sendText() {
        String textToSend = txtSend.getText();
        sendGivenText(textToSend);
    }

    /**
     * Sends input text
     */
    public void sendLoben() {
        Double rating = sldLoben.getValue();
        int ratingLevel = rating.intValue();
        String lobTXT = null;
        if (ratingLevel == 1) {
            lobTXT = "Danke";
        } else if (ratingLevel == 2) {
            lobTXT = "Das war gut!";
        } else if (ratingLevel == 3) {
            lobTXT = "Das war sehr gut!";
        } else if (ratingLevel == 4) {
            lobTXT = "Hervorragend!";
        } else {
            lobTXT = "Engelsgesang!!";
        }

        sendGivenText(lobTXT);
    }
    /**
     * Sends input text
     */
    public void sendHello() {
        sendGivenText("Shalom!");
    }

    public void sendVermeldung() {
        sendGivenText("Bitte zurückbleiben!");
    }
    /**
     * Sends input text
     */
    public void sendBye() {
        sendGivenText("Gottes Segen!");
    }

    public void sendClear() {
        sendGivenText("");
    }


    public void sendGivenText(String text) {
        String host = txtHost.getText();
        int ip = Integer.parseInt(txtPort.getText());

        String log = rc.sendTxt(host, ip, text);

        txtStatus.setText(log);
    }

}
