package controller.cliente;


import com.example.producto5.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Cliente;
import model.dao.DAOFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowAllClientesController implements Initializable {
    private static DAOFactory factory = new DAOFactory();

    @FXML
    private Button back;

    @FXML
    private TableView<Cliente> tableview;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colDomicilio;
    @FXML
    private TableColumn<Cliente, String > colNif;
    @FXML
    private TableColumn<Cliente, String > colEmail;
    @FXML
    private TableColumn<Cliente, String > colTelefono;
    @FXML
    private TableColumn<Cliente, Integer> colIs_premium;
    @FXML
    private TableColumn<Cliente, Double> colCuota;
    @FXML
    private TableColumn<Cliente, Double> colDescuento;

    @FXML
    protected void back() throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }

    @FXML
    protected void changeScene() throws IOException {
    Main m = new Main();
    m.changeScene("afterLogin.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("Domicilio"));
        colNif.setCellValueFactory(new PropertyValueFactory<>("Nif"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        colIs_premium.setCellValueFactory(new PropertyValueFactory<>("Is_premium"));
        colCuota.setCellValueFactory(new PropertyValueFactory<>("Cuota"));
        colDescuento.setCellValueFactory(new PropertyValueFactory<>("Descuento"));
        tableview.setItems(observableList);

    }

    ObservableList<Cliente> observableList = FXCollections.observableList( factory.getClienteDAO().getAll());
}