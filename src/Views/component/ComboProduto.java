package Views.component;

import DAOs.ProdutoDAO;
import Models.Produto;
import Views.component.utilcomp.ClienteConverter;
import Views.component.utilcomp.ProdutoConverter;
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

public class ComboProduto extends ComboBox{

    ComboBox cmbProduto;
    ProdutoDAO dao;

    public String ItemSelected;
    public String ValorUnitSelected;
    public Integer IdSelected;

    public ComboProduto(ComboBox cmb){
        this.cmbProduto = cmb;

        ObservableList allProdutos = FXCollections.observableArrayList(getSelect());
        cmbProduto.getItems().addAll(allProdutos);

        cmbProduto.setConverter(new ProdutoConverter());


        cmbProduto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Produto>() {
            @Override
            public void changed(ObservableValue<? extends Produto> observable,
                                Produto oldValue, Produto newValue) {
                cmbProdutoChanged(observable, oldValue, newValue);
            }

        });


        cmbProduto.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                cmbProdutoIndexChanged(observable, oldValue, newValue);
            }
        });

        cmbProduto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                valueChanged(cmbProduto);
            }
        });
    }

    private ProdutoDAO getInstanceDAO(){
        dao = new ProdutoDAO();
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


    private void cmbProdutoIndexChanged(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println( "Indexchanged: old = " + oldValue + ", new = " + newValue + "\n");
    }

    private void valueChanged(ComboBox<Produto> cmbProduto) {
        Produto p = cmbProduto.getValue();
        ItemSelected = p.Nome;
        ValorUnitSelected = Double.toString(p.PrecoUnitario);

    }

    private void cmbProdutoChanged(ObservableValue<? extends Produto> observable, Produto oldValue, Produto newValue) {
        String oldText = oldValue == null ? "null" : oldValue.toString();
        String newText = newValue == null ? "null" : newValue.toString();


        System.out.println("Itemchanged: old = " + oldText + ", new = " + newText + "\n");
    }

}
