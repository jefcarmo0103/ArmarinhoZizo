package Principal;

import Models.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class Principal extends Application {

    public static void main(String[] args) {

        Class<? extends Cliente> clazz = new Cliente().getClass();
        Field[] campos = clazz.getDeclaredFields();

        for(int j = 0; j < campos.length; j++){
            String campo = campos[j].getName();
            Type tipo = campos[j].getType();

        }


        launch(args);
    }

    @Override
    public void start(Stage stage){
        try{
            String url = "/Views/Menu.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Zizo's Papelaria");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }
        catch(IOException err){
            err.printStackTrace();
        }

    }
}
