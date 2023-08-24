package model;//package model;
//
//
//
//public class ClientePremium extends Cliente{
//
//    private double cuota;
//
//    private double descuento;
//
//
//    public ClientePremium() {
//    }
//
//    public ClientePremium(double cuota, double descuento) {
//        this.cuota = cuota;
//        this.descuento = descuento;
//    }
//
//    public ClientePremium(String nombre, String domicilio, String nif, String email, String telefono, int is_premium, double cuota, double descuento) {
//        super(nombre, domicilio, nif, email, telefono, is_premium);
//        this.cuota = cuota;
//        this.descuento = descuento;
//    }
//
//    public double getCuota() {
//        return cuota;
//    }
//
//    public void setCuota(double cuota) {
//        this.cuota = cuota;
//    }
//
//    public double getDescuento() {
//        return descuento;
//    }
//
//    public void setDescuento(double descuento) {
//        this.descuento = descuento;
//    }
//
//
//    @Override
//    public String toString() {
//        return "ClientePremium{" +
//                "nombre='" + nombre + '\'' +
//                ", domicilio='" + domicilio + '\'' +
//                ", nif='" + nif + '\'' +
//                ", email='" + email + '\'' +
//                ", teléfono='" + telefono + '\'' +
//                ", cuota=" + cuota +
//                ", descuento=" + descuento +
//                '}';
//    }
//
//    @Override
//    public String tipoCliente() {
//        return "Cliente Premium";
//    }
//
//    @Override
//    public float calcAnual() {
//        return (float) this.cuota;
//    }
//
//    @Override
//    public float descuentoEnv() {
//        return (float) this.descuento;
//    }
//}
