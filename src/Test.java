import TodosRestPackage.TodosRest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

//import javafx.fxml.JavaFXBuilderFactory;
//import javafx.util.JavaFXBuilderFactory;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.BuilderFactory;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;





public class Test extends Application {
    private static Stage stage;
    private static FXMLLoader loader;
    private static Controller sceneController;

    @Override
    public void start(Stage primarystage) throws Exception {
        stage = primarystage;

        gotoMain();
        stage.show();
        System.out.println("asd");


    }

    private void gotoMain() {
        try {
            replaceSceneContent("T5UI.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Parent replaceSceneContent(String fxml) throws Exception {
        loader = new FXMLLoader(Test.class.getResource("T5UI.fxml"));
        Parent root = loader.load(Test.class.getResource("T5UI.fxml"), null);
        sceneController = loader.getController();

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(root);
            //scene.getStylesheets().add(Test.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(root);
        }
        stage.sizeToScene();
        return root;
    }



    public static void main(String[] args) {
//        String siteURL = "https://jsonplaceholder.typicode.com/todos";
//        FileOutputStream out = null;
//        TodosRest tr = new TodosRest();
//
//
//        ArrayList<TodosRest.todo> todos = tr.getTodos(siteURL);
//        Iterator<TodosRest.todo> iter = todos.iterator();
//        try{
//            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
//            String s = "";
//            while (iter.hasNext()) {
//                s = iter.next().gettitle();
//                writer.write(s + " ");
//                //System.out.println(iter.next().title+" ");
//                //sceneController.setFirstTextField("asdasd");
//            }
//            writer.close();
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }


        System.out.println("Lanuching app");

        launch(args);







    }
}
