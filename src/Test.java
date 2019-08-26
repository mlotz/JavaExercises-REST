import TodosRestPackage.TodosRest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

//import javafx.fxml.JavaFXBuilderFactory;
//import javafx.util.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;





public class Test extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("T5UI.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("T5 - Exercises: REST API, JAVA FX");
        stage.setScene(scene);
        stage.show();
        System.out.println("asd");


    }

    private void gotoLogin() {
        try {
            replaceSceneContent("login.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(Test.class.getResource(fxml), null);
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            //scene.getStylesheets().add(Test.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
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

        try {
            replaceSceneContent("a.fxml");
        }
        catch(Exception e){}




    }
}
