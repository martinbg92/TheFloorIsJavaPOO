package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Column(name ="nombre" , nullable = false)
    protected String nombre;
    @Column(name ="domicilio" , nullable = false)
    protected String domicilio;
    @Column(name ="nif" , nullable = false)
    protected String nif;
    @Id
    @Column(name ="email")
    protected String email;
    @Column(name ="telefono" , nullable = false)
    protected String telefono;

    @Column(name ="is_premium" , nullable = false)
    protected int is_premium;

    @Column(name ="cuota")
    private double cuota;
    @Column(name ="descuento")
    private double descuento;



    public Cliente() {
    }

    public Cliente(String nombre, String domicilio, String nif, String email, String telefono, int is_premium) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        this.telefono = telefono;
        this.is_premium = is_premium;
    }

    public Cliente(String nombre, String domicilio, String nif, String email, String telefono, int is_premium, double cuota, double descuento) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        this.telefono = telefono;
        this.is_premium = is_premium;
        this.cuota = cuota;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIs_premium() {
        return is_premium;
    }

    public void setIs_premium(int is_premium) {
        this.is_premium = is_premium;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", teléfono='" + telefono + '\'' +
                '}';
    }


    public String tipoCliente(){
        String toReturn = "";
        if (getIs_premium() == 0){
            toReturn = "Cliente Estandar";
        }else if(getIs_premium() == 1) {
            toReturn = "Cliente Premium";
        }
        return toReturn;
    }
    public float calcAnual(){
        float toReturn = 0;
        if (getIs_premium() == 0){
            toReturn = 0;
        }else if(getIs_premium() == 1) {
            toReturn = (float) this.cuota;
        }

        return toReturn;
    };
    public float descuentoEnv(){
        float toReturn = 0;
        if (getIs_premium() == 0){
            toReturn = 0;
        }else if(getIs_premium() == 1) {
            toReturn = (float) this.descuento;
        }

        return toReturn;

    };


}
