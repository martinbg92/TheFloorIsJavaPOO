package controller.pedido;


import com.example.producto5.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Articulo;
import model.Cliente;
import model.Pedido;
import model.dao.DAOFactory;
import util.DBConnectionUtil;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class AddPedidoController {
    private static DAOFactory factory = new DAOFactory();

    @FXML
    private Label messageExito;
    @FXML
    private Label messageEmailCliente;
    @FXML
    private Label messageCodigoArticulo;
    @FXML
    private Label messageCantidad;


    @FXML
    private TextField emailCliente;
    @FXML
    private TextField codigoArticulo;
    @FXML
    private TextField cantidad;

    @FXML
    private Button back;

    @FXML
    protected void back() throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }





    @FXML
    protected void guardarPedido() {
        boolean valid = true;
        int cantidadInput = Integer.MIN_VALUE;

        Cliente cliente = factory.getClienteDAO().get(emailCliente.getText());
        if (cliente == null) {
            messageEmailCliente.setText("El cliente no existe!");
            valid = false;
        }else{
            valid = true;
            messageEmailCliente.setText("");
        }


        Articulo articulo = factory.getArticuloDAO().get(codigoArticulo.getText());
        if (articulo == null) {
             messageCodigoArticulo.setText("El articulo no existe!");
                valid = false;
        }else{
            valid = true;
            messageCodigoArticulo.setText("");
        }

        try {
            cantidadInput = Integer.parseInt(cantidad.getText());

            cantidad.setText("");


        } catch (NumberFormatException ignore) {

            if (cantidadInput == Integer.MIN_VALUE){
                messageCantidad.setText("Invalid cantidad");
            }
            valid = false;
        }






        if (valid == true) {
            messageCantidad.setText("");
            messageExito.setText("Pedido Guardado!");

            factory.getPedidoDAO().save(new Pedido(cliente, articulo, cantidadInput, LocalDateTime.now()));

        }else {
            messageExito.setText("");
        }


    }


}