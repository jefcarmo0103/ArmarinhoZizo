package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class MenuController implements Initializable {

    @FXML
    private TabPane tabPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    @FXML
    private void abrirProdutos() {
        abrir("/Views/Produto.fxml", "Produtos");
    }

    @FXML
    private void abrirClientes() {
        abrir("/Views/Cliente.fxml", "Clientes");
    }

    @FXML
    private void abrirFornecedores() {
        abrir("/Views/Fornecedor.fxml", "Fornecedores");
    }

    @FXML
    private void abrirCompras() {
        abrir("/Views/Compra.fxml", "Compras");
    }

    @FXML
    private void abrirVendas() {
        abrir("/Views/Venda.fxml", "Vendas");
    }

    private void abrir(String url, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent content = loader.load();
            Tab tab = new Tab(title);
            tab.setContent(content);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

