package Views.component;

import DAOs.ClienteDAO;
import Models.Cliente;
import Views.component.utilcomp.ClienteConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class ComboCliente extends ComboBox {
    ComboBox cmbCliente;
    ClienteDAO dao;

    public String ItemSelected;

    public ComboCliente(ComboBox cmb){
        this.cmbCliente = cmb;

        ObservableList allClientes = FXCollections.observableArrayList(getSelect());
        cmbCliente.getItems().addAll(allClientes);

        cmbCliente.setConverter(new ClienteConverter());


        cmbCliente.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cliente>() {
            @Override
            public void changed(ObservableValue<? extends Cliente> observable,
                                Cliente oldValue, Cliente newValue) {
                cmbClienteChanged(observable, oldValue, newValue);
            }

        });

        cmbCliente.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                cmbClienteIndexChanged(observable, oldValue, newValue);
            }
        });

        cmbCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                valueChanged(cmbCliente);
            }
        });
    }

    private ClienteDAO getInstanceDAO(){
        dao = new ClienteDAO();
        return dao;
    }

    private ArrayList getSelect(){

        ArrayList list;
        try{
            list = getInstanceDAO().SelecionarTodos();

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

        return list;
    }


    private void cmbClienteIndexChanged(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println( "Indexchanged: old = " + oldValue + ", new = " + newValue + "\n");
    }

    private void valueChanged(ComboBox<Cliente> cmbCliente) {
        Cliente c = cmbCliente.getValue();
        ItemSelected = c.Nome;
        System.out.println(ItemSelected);
    }

    private void cmbClienteChanged(ObservableValue<? extends Cliente> observable, Cliente oldValue, Cliente newValue) {
        String oldText = oldValue == null ? "null" : oldValue.toString();
        String newText = newValue == null ? "null" : newValue.toString();

        System.out.println("Itemchanged: old = " + oldText + ", new = " + newText + "\n");
    }


}
