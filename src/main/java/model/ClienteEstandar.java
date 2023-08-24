package model;//package model;
//
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//public class ClienteEstandar extends Cliente{
//
//    public ClienteEstandar() {
//    }
//
//    public ClienteEstandar(String nombre, String domicilio, String nif, String email, String telefono, int is_premium) {
//        super(nombre, domicilio, nif, email, telefono, is_premium);
//    }
//
//    @Override
//    public String toString() {
//        return "ClienteEstandar{" +
//                "nombre='" + nombre + '\'' +
//                ", domicilio='" + domicilio + '\'' +
//                ", nif='" + nif + '\'' +
//                ", email='" + email + '\'' +
//                ", teléfono='" + telefono + '\'' +
//                '}';
//    }
//
//    @Override
//    public String tipoCliente() {
//        return "Cliente Estandar";
//    }
//
//    @Override
//    public float calcAnual() {
//        return 0;
//    }
//
//    @Override
//    public float descuentoEnv() {
//        return 0;
//    }
//
//
//}
