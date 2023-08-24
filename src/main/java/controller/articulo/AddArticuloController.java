package controller.articulo;


import com.example.producto5.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Articulo;
import model.dao.DAOFactory;
import util.DBConnectionUtil;

import java.io.IOException;

public class AddArticuloController  {
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
    protected void back() throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }

    @FXML
    protected void changeScene() throws IOException {
    Main m = new Main();
    m.changeScene("afterLogin.fxml");
    }

    @FXML
    protected void onHelloButtonClick() {

//        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void guardarArticulo() {
        boolean valid = true;
        double precioo = Double.MIN_VALUE;
        double dastosDEnvioo = Double.MIN_VALUE;
        double tiempoDePreparacionn = Double.MIN_VALUE;


        if (codigo1.getText().equals("")){
            messageCodigo.setText("Invalid codigo");
            valid = false;
        }else {
            Articulo articuloSearch = DBConnectionUtil.em.find(Articulo.class, codigo1.getText());
            if(articuloSearch == null){

                    valid = true;
                    messageCodigo.setText("");

            }else{
                valid = false;
                messageCodigo.setText("Ya existe un articulo con este codigo!");
                messageExito.setText("");
                codigo1.setText("");
            }

        }


        if (discripcion.getText().equals("")){
            messageDisc.setText("Invalid discripcion");
            valid = false;
        }else {
            valid = true;
            messageDisc.setText("");
        }


        try {
            precioo = Double.parseDouble(precio.getText());

            messagePrice.setText("");


        } catch (NumberFormatException ignore) {


            if (precioo == Double.MIN_VALUE){
                messagePrice.setText("Invalid Price");
            }

            valid = false;
        }


        try {
            tiempoDePreparacionn = Double.parseDouble(tiempo_de_preparacion.getText());
            messageTiempo.setText("");

        } catch (NumberFormatException ignore) {

            if (tiempoDePreparacionn == Double.MIN_VALUE){
                messageTiempo.setText("Invalid tiempo de preparacion");
            }
            valid = false;
        }


        try {
            dastosDEnvioo = Double.parseDouble(dastos_de_envio.getText());
            messageEnvio.setText("");
        } catch (NumberFormatException ignore) {

            if (dastosDEnvioo == Double.MIN_VALUE){
                messageEnvio.setText("Invalid gastos de envio");
            }
            valid = false;
        }







        if (valid == true) {
            messageTiempo.setText("");
            messageEnvio.setText("");
            messagePrice.setText("");
            messageExito.setText("Articulo Guardado!");

            Articulo articulo = new Articulo(codigo1.getText(),discripcion.getText(),Double.parseDouble(precio.getText()),Double.parseDouble(dastos_de_envio.getText()),Integer.parseInt(tiempo_de_preparacion.getText()));

            this.addArticulo(articulo);



        }else {
            messageExito.setText("");
        }


    }

    public void addArticulo(Articulo articulo) {
        factory.getArticuloDAO().save(articulo);
    }
}