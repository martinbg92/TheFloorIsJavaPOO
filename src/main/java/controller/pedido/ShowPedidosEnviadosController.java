package controller.pedido;


import com.example.producto5.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Pedido;
import model.dao.ClienteDAO;
import model.dao.PedidoDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowPedidosEnviadosController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TableView<Pedido> tableview;
    @FXML
    private TableColumn<Pedido, String> colId;
    @FXML
    private TableColumn<Pedido, String> colCantidad;
    @FXML
    private TableColumn<Pedido, Boolean > colEnviado;
    @FXML
    private TableColumn<Pedido, String > colRealizadoEn;
    @FXML
    private TableColumn<Pedido, String > colArticulo;
    @FXML
    private TableColumn<Pedido, String > colCliente;


    @FXML
    protected void back() throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(new PropertyValueFactory<>("NumeroDePedido"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        colEnviado.setCellValueFactory(new PropertyValueFactory<>("Enviado"));
        colRealizadoEn.setCellValueFactory(new PropertyValueFactory<>("FechaYHoraDelPedido"));
        colArticulo.setCellValueFactory(new PropertyValueFactory<>("CodigoArticulo"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("EmailCliente"));
        tableview.setItems(observableList);

    }
    ObservableList<Pedido> observableList = FXCollections.observableList( new PedidoDAO().getPedidosEnviados());


}

