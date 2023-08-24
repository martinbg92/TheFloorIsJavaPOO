package controller.articulo;


import com.example.producto5.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Articulo;
import model.dao.DAOFactory;
import util.DBConnectionUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowArticulosController implements Initializable {
    private static DAOFactory factory = new DAOFactory();
    @FXML
    private Button change;
    @FXML
    private Label messageDisc;
    @FXML
    private Label messageCodigo;
    @FXML
    private Label messageExito;
    @FXML
    private Label messagePrice;
    @FXML
    private Label messageEnvio;
    @FXML
    private Label messageTiempo;
    @FXML
    private TextField codigo1;
    @FXML
    private TextField discripcion;
    @FXML
    private TextField precio;
    @FXML
    private TextField dastos_de_envio;
    @FXML
    private TextField tiempo_de_preparacion;
    @FXML
    private Button back;

    @FXML
    private TableView<Articulo> tableview;
    @FXML
    private TableColumn<Articulo, String> colCodigo;
    @FXML
    private TableColumn<Articulo, String> colDescripcion;
    @FXML
    private TableColumn<Articulo, Double> colPrecio;
    @FXML
    private TableColumn<Articulo, Double> colEnvio;
    @FXML
    private TableColumn<Articulo, Double> colPreparacion;

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


        colCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        colEnvio.setCellValueFactory(new PropertyValueFactory<>("GastosDeEnvio"));
        colPreparacion.setCellValueFactory(new PropertyValueFactory<>("TiempoDePreparacion"));
        tableview.setItems(observableList);

    }

    ObservableList<Articulo> observableList = FXCollections.observableList( factory.getArticuloDAO().getAll());
}