import TodosRestPackage.TodosRest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;





public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("T5UI.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("T5 - Exercises: REST API, JAVA FX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        String siteURL = "https://jsonplaceholder.typicode.com/todos";
        FileOutputStream out = null;
        TodosRest tr = new TodosRest();


        ArrayList<TodosRest.todo> todos = tr.getTodos(siteURL);
        Iterator<TodosRest.todo> iter = todos.iterator();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            while (iter.hasNext()) {
                writer.write(iter.next().gettitle() + " ");
                //System.out.println(iter.next().title+" ");
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        launch(args);




    }
}
