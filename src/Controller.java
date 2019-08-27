import TodosRestPackage.TodosRest;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private int count = 1 ;

    private static ArrayList<TextField> textFields = new ArrayList<TextField>();

    @FXML
    private Label label1 ;

    @FXML
    private TextField firstTextField ;

    @FXML
    private AnchorPane textFieldsAnchorPane;

    @FXML
    private void button_i_action() {
        count++;
        label1.setText("Count: "+count);
    }

    @FXML
    private void button_r_action() {


    }

    @FXML
    public void setFirstTextField(String s){
        firstTextField.setText(s);
        return;
    }

    public void initialize(URL location, ResourceBundle resources){
        Integer mult = 0;

        String siteURL = "https://jsonplaceholder.typicode.com/todos";
        FileOutputStream out = null;
        TodosRest tr = new TodosRest();

        TodosRest.todo todo_temp;
        ArrayList<TodosRest.todo> todos = tr.getTodos(siteURL);
        Iterator<TodosRest.todo> iter = todos.iterator();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            String s = "";
            while (iter.hasNext()) {
                //s = iter.next().gettitle();

                todo_temp = iter.next();
                s = todo_temp.gettitle();


                writer.write(s + " ");
                //System.out.println(iter.next().title+" ");
                label1.setText(s);
                firstTextField.setText(s);
                textFields.add(new TextField(s));
                (textFields.get(textFields.size() - 1)).setLayoutX(14.0);
                (textFields.get(textFields.size() - 1)).setLayoutY(14.0+26.0*mult);
                (textFields.get(textFields.size() - 1)).setPrefWidth(522.0);
                if(todo_temp.getcompleted() == true){
                    (textFields.get(textFields.size() - 1)).setStyle("-fx-text-inner-color: green;");
                }else {
                    (textFields.get(textFields.size() - 1)).setStyle("-fx-text-inner-color: red;");
                }
                //System.out.println(textFieldsAnchorPane.getChildren());
                textFieldsAnchorPane.getChildren().add(textFields.get(textFields.size() - 1));
                mult += 1;
            }
            //System.out.println(textFieldsAnchorPane);
            writer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }



}
