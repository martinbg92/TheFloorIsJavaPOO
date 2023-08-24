package controller.cliente;


import com.example.producto5.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Cliente;
import model.dao.DAOFactory;
import util.DBConnectionUtil;

import java.io.IOException;
import java.math.BigInteger;

public class AddClienteController {
    private static DAOFactory factory = new DAOFactory();

    @FXML
    private Label messageExito;
    @FXML
    private Label messageNombre;
    @FXML
    private Label messageDomiciolio;
    @FXML
    private Label messageNif;
    @FXML
    private Label messageEmail;
    @FXML
    private Label messageTelefono;

    @FXML
    private TextField nombre;
    @FXML
    private TextField domicilio;
    @FXML
    private TextField nif;
    @FXML
    private TextField email;
    @FXML
    private TextField telefono;
    @FXML
    private CheckBox is_premium;
    @FXML
    private Button back;

    @FXML
    protected void back() throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }





    @FXML
    protected void guardarCliente() {
        boolean valid = true;
        BigInteger telefonoo = new BigInteger("-600");

        if (email.getText().equals("")){
            messageEmail.setText("Invalid email");
            valid = false;
        }else {
            Cliente clienteSearch = DBConnectionUtil.em.find(Cliente.class, email.getText());
            if(clienteSearch == null){

                    valid = true;
                    messageEmail.setText("");

            }else{
                valid = false;
                messageEmail.setText("Ya existe un cliente con este email!");
                messageExito.setText("");
                email.setText("");
            }

        }


        if (nombre.getText().equals("")){
            messageNombre.setText("Invalid nombre");
            valid = false;
        }else {
            valid = true;
            messageNombre.setText("");
        }

        if (domicilio.getText().equals("")){
            messageDomiciolio.setText("Invalid Domiciolio");
            valid = false;
        }else {
            valid = true;
            messageDomiciolio.setText("");
        }

        if (nif.getText().equals("")){
            messageNif.setText("Invalid NIF");
            valid = false;
        }else {
            valid = true;
            messageNif.setText("");
        }


        try {
            telefonoo = new BigInteger(telefono.getText());

            messageTelefono.setText("");


        } catch (NumberFormatException ignore) {


            if (telefonoo.equals(new BigInteger("-600"))){
                messageTelefono.setText("Invalid Telefono");
            }

            valid = false;
        }




        if (valid == true) {
            messageTelefono.setText("");
            messageExito.setText("Cliente Guardado!");
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre.getText());
            cliente.setDomicilio(domicilio.getText());
            cliente.setNif(nif.getText());
            cliente.setEmail(email.getText());
            cliente.setTelefono(telefono.getText());
            if (is_premium.isSelected()){

                cliente.setIs_premium(1);
                cliente.setCuota(30);
                cliente.setDescuento(20);
            }else {

                cliente.setIs_premium(0);
                cliente.setCuota(0);
                cliente.setDescuento(0);
            }

            this.addCliente(cliente);



        }else {
            messageExito.setText("");
        }


    }

    public void addCliente(Cliente cliente) {
        factory.getClienteDAO().save(cliente);
    }
}