package Controllers;

import DAOs.*;
import Models.Cliente;
import Models.Produto;
import Models.Venda;
import Views.component.*;

import java.awt.*;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Light;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class VendaController implements Initializable, Controller, Itens {

    private final int QUANTIDADE_PAGINA = 9;

    private Venda venda;

    @FXML
    private VBox consulta;

    @FXML
    private TableView tabela;

    @FXML
    private TableColumn colunaCliente;

    @FXML
    private TableColumn colunaData;

    @FXML
    private TableColumn colunaTotal;

    @FXML
    private TableColumn colunaSituacao;

    @FXML
    private TableColumn colunaEditar;

    @FXML
    private TableColumn colunaExcluir;

    @FXML
    private TextField filtro;

    @FXML
    private Pagination paginacao;

    @FXML
    private VBox formulario;

    @FXML
    private Label rotuloCliente;

    @FXML
    private ComboBox cbCliente;

    @FXML
    private Label rotuloData;

    @FXML
    private DatePicker campoData;

    @FXML
    private Label rotuloSituacao;

    @FXML
    private HBox situacoes;

    @FXML
    private RadioButton aberta;

    @FXML
    private ToggleGroup situacao;

    @FXML
    private RadioButton finalizada;

    @FXML
    private RadioButton cancelada;

    @FXML
    private VBox itens;

    @FXML
    private Label rotuloProdutos;

    @FXML
    private TableView tabelaProdutos;

    @FXML
    private TableColumn colunaProduto;

    @FXML
    private TableColumn colunaQuantidade;

    @FXML
    private TableColumn colunaValorUnitario;

    @FXML
    private TableColumn colunaSubtotal;

    @FXML
    private TableColumn colunaRemover;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private VBox formulario1;

    @FXML
    private Label rotuloProduto;

    @FXML
    private ComboBox comboProduto;

    @FXML
    private Label rotuloQuantidade;

    @FXML
    private TextField campoQuantidade;

    @FXML
    private Label rotuloValor;

    @FXML
    private TextField campoValor;

    @FXML
    private Button botaoAdicionarItem;

    @FXML
    private Button botaoCancelarItem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataVenda"));
        colunaData.setCellFactory(new ColunaData());
        colunaTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        colunaTotal.setCellFactory(new ColunaValor());
        colunaEditar.setCellFactory(new BotaoEditar(this));
        colunaEditar.setCellValueFactory(new PropertyValueFactory<>("codigoEdicao"));
        colunaExcluir.setCellFactory(new BotaoExcluir(this));
        colunaExcluir.setCellValueFactory(new PropertyValueFactory<>("codigoEdicao"));


        ComboCliente cmbCliente = new ComboCliente(cbCliente);
        ComboProduto cp = new ComboProduto(comboProduto);


        paginacao.setPageFactory(new Callback<Integer, Node>() {

            @Override
            public Node call(Integer pagina) {
                atualizarGrade(pagina);
                return tabela;
            }
        });


        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaQuantidade.setCellFactory(new ColunaValorInteiro());
        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colunaValorUnitario.setCellFactory(new ColunaValor());
        colunaSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        colunaSubtotal.setCellFactory(new ColunaValor());
        colunaRemover.setCellFactory(new BotaoRemoverItem(this));
        colunaRemover.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        trocar(1);
        atualizarGrade(0);
    }

    private void atualizarGrade(int pagina) {
        try {
            //paginacao.setPageCount((int) Math.ceil(((double) VendaDAO.quantidade(filtro.getText())) / QUANTIDADE_PAGINA));
            //tabela.setItems(VendaDAO.listar(filtro.getText(), QUANTIDADE_PAGINA, pagina));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void trocar(int id) {
        consulta.setVisible(id == 1);
        formulario.setVisible(id == 2);
        itens.setVisible(id == 3);
    }

    @FXML
    private void filtrar() {
        atualizarGrade(0);
    }

    @FXML
    private void novo() throws Exception {
        this.venda = new Venda();
        trocar(2);
    }

    @FXML
    private void salvar() {
        rotuloCliente.setTextFill(Paint.valueOf("#333333"));
        rotuloData.setTextFill(Paint.valueOf("#333333"));

        boolean erro = false;

        try {
            if (cbCliente.getSelectionModel().isEmpty()) {
                throw new Exception("Cliente inválido!");
            }
            //venda.setCliente((Cliente) comboCliente.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            rotuloCliente.setTextFill(Paint.valueOf("red"));
            erro = true;
        }

        try {
            //venda.setDataVenda(ConversorData.converter(campoData.getValue()));
        } catch (Exception e) {
            rotuloData.setTextFill(Paint.valueOf("red"));
            erro = true;
        }

        if (aberta.isSelected()) {
            //venda.setSituacao(Situacao.ABERTA);
        } else if (finalizada.isSelected()) {
            //venda.setSituacao(Situacao.FINALIZADA);
        } else {
            //venda.setSituacao(Situacao.CANCELADA);
        }

        if (erro) {
            return;
        }
        
        /*if (venda.getSituacao() == Situacao.FINALIZADA) {
            for (Venda.ItemVenda iv : venda.getItens()) {
                try {
                    if (iv.getQuantidade() > ProdutoDAO.recuperar(iv.getProduto().getCodigo()).getQuantidade()) {
                        String msg = "Impossível finalizar.\n" + iv.getProduto() + " em falta no estoque.";
                        new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK).show();
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
        }*/

        try {
            //VendaDAO.salvar(venda);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        trocar(1);
        atualizarGrade(0);
    }

    @Override
    public void editar(int codigo) {
        try {
            /*this.venda = this.venda = VendaDAO.recuperar(codigo);
            comboCliente.getSelectionModel().select(venda.getCliente());
            campoData.setValue(ConversorData.converter(venda.getDataVenda()));
            if (venda.getSituacao() == Situacao.ABERTA) {
                aberta.setSelected(true);
            } else if (venda.getSituacao() == Situacao.FINALIZADA) {
                finalizada.setSelected(true);
            } else {
                cancelada.setSelected(true);
            }
            tabelaProdutos.setItems(venda.getItens());*/
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        trocar(2);
    }

    @Override
    public void excluir(int codigo) {
        try {
            //this.venda = this.venda = VendaDAO.recuperar(codigo);
            //venda.setSituacao(Situacao.CANCELADA);
            //VendaDAO.salvar(venda);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        atualizarGrade(0);
    }

    @FXML
    private void adicionarProduto() {
        trocar(3);
    }

    @FXML
    private void cancelar() {
        trocar(1);
    }

    @FXML
    private void atualizaValor() {
        Produto produto = (Produto) comboProduto.getSelectionModel().getSelectedItem();
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        String res =  nf.format(produto.PrecoUnitario);
        campoValor.setText(res);
    }

    @Override
    @FXML
    public void adicionarItem() throws ParseException {
        NumberFormat nf = NumberFormat.getNumberInstance();
        Venda.ItemVenda item = venda.new ItemVenda();
        Produto p = (Produto) comboProduto.getSelectionModel().getSelectedItem();
        item.setCodigo(p.Id);
        item.setProduto((Produto) comboProduto.getSelectionModel().getSelectedItem());
        item.setQuantidade(nf.parse(campoQuantidade.getText()).intValue());
        item.setValorUnitario(nf.parse(campoValor.getText()).floatValue());
        venda.addItem(item);
        tabelaProdutos.setItems(venda.getItens());
        trocar(2);
    }

    @Override
    @FXML
    public void removerItem(int codigoItem) throws ParseException {
        Venda.ItemVenda item = venda.new ItemVenda(codigoItem);
        venda.removeItem(item);
        tabelaProdutos.setItems(venda.getItens());
        trocar(2);
    }

    @FXML
    private void cancelarItem() {
        trocar(2);
    }




}
