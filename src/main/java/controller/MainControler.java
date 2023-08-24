package controller;

import com.example.producto5.Main;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class MainControler {
    @FXML
    private MenuItem addArticulo;

    @FXML
    private MenuItem mostrarArticulos;

    @FXML
    private MenuItem addCliente;


    @FXML
    protected void changeSceneNuevoCliente() throws IOException {
        Main m = new Main();
        m.changeScene("./cliente/nuevo-cliente-view.fxml");
    }

    @FXML
    protected void changeSceneNuevoArticulo() throws IOException {
        Main m = new Main();
        m.changeScene("./articulo/nuevo-articulo-view.fxml");
    }


    @FXML
    protected void changeSceneMostrarArticulos() throws IOException {
        Main m = new Main();
        m.changeScene("./articulo/mostrar-articulos-view.fxml");
    }

    @FXML
    protected void changeSceneMostrarTodosLosClientes() throws IOException {
        Main m = new Main();
        m.changeScene("./cliente/mostrar-todos-los-clientes-view.fxml");
    }

    @FXML
    protected void changeSceneMostrarClientesEstandar() throws IOException {
        Main m = new Main();
        m.changeScene("./cliente/mostrar-clientes-estandar-view.fxml");
    }

    @FXML
    protected void changeSceneMostrarClientesPremium() throws IOException {
        Main m = new Main();
        m.changeScene("./cliente/mostrar-clientes-premium-view.fxml");
    }
    @FXML
    protected void changeSceneMostrarPedidosEnviados() throws IOException {
        Main m = new Main();
        m.changeScene("./pedido/mostrar-pedidos-enviados-view.fxml");
    }

    @FXML
    protected void changeSceneMostrarPedidosPendientesDeEnvio() throws IOException {
        Main m = new Main();
        m.changeScene("./pedido/mostrar-pedidos-pendientes-de-envio-view.fxml");
    }


    @FXML
    protected void changeSceneAddPedido() throws IOException {
        Main m = new Main();
        m.changeScene("./pedido/nuevo-pedido-view.fxml");
    }

    @FXML
    protected void changeSceneBorrarPedido() throws IOException {
        Main m = new Main();
        m.changeScene("./pedido/borrar-pedido-view.fxml");
    }










}
