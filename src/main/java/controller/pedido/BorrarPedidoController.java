package controller.pedido;


import com.example.producto5.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Articulo;
import model.Pedido;
import model.dao.DAOFactory;
import util.DBConnectionUtil;
import view.old.PedidoView;

import java.io.IOException;
import java.time.LocalDateTime;

public class BorrarPedidoController {
    private static DAOFactory factory = new DAOFactory();



    @FXML
    private Label messageCodigo;
    @FXML
    private Label messageExito;

    @FXML
    private TextField codigo;

    @FXML
    private Button back;

    @FXML
    protected void back() throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }


    @FXML
    protected void borrarPedido() {
        boolean valid = true;
        String id;
        if (codigo.getText().equals("")){
            messageCodigo.setText("Invalid codigo");
            valid = false;
        }else {
            String str = codigo.getText();
            Pedido pedido = factory.getPedidoDAO().get(str);

            if (pedido == null) {
                valid = false;
                messageCodigo.setText("No hay pedidos con este id");
            } else if (LocalDateTime.now().isAfter(pedido.getFechaYHoraDelPedido().plusMinutes(pedido.getArticulo().getTiempoDePreparacion()))  || pedido.getEnviado() ==1){
                valid = false;
                messageCodigo.setText("El pedido ya ha sido enviado!");
            }else {
                if (valid == true) {
                    messageCodigo.setText("");
                    messageExito.setText("Pedido Borrado!");
                    this.borrarPedido(pedido);
                }else {
                    messageExito.setText("");
                }
            }
        }





    }

    public void borrarPedido(Pedido pedido) {
        String id = String.valueOf(pedido.getNumeroDePedido());
        factory.getPedidoDAO().delete(id);
    }
}