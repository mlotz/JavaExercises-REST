
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    private int count = 1 ;

    @FXML
    private Label label1 ;

    @FXML
    private void button_i_action() {
        count++;
        label1.setText("Count: "+count);
    }

}
