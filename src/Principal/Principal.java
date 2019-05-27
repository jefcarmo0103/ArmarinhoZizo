package Principal;

import DAOs.ClienteDAO;
import Factory.ConnectionFactory;
import Models.Cliente;
import com.sun.security.ntlm.Client;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.management.RuntimeErrorException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.Calendar;

import static Factory.ConnectionFactory.getConnection;

public class Principal extends Application {

    public static void main(String[] args) {

        try{
            Cliente cliente = new Cliente("Jeff","jeff@ftt",
                    "952382304", Calendar.getInstance());
            ClienteDAO dao = new ClienteDAO();


            String teste;
            teste = "";

        }
        catch (Exception e){
            throw new RuntimeException(e);
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
