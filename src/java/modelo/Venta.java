
package modelo;

import java.time.LocalTime;
import java.util.Date;


public class Venta {
    private int id;
    private Cliente id_cliente;
    private Venta id_venta;
    private Date fecha;
    private LocalTime hora;
    private int cantidad;
    
     public Venta(){
        this.fecha = new Date();
        this.hora = LocalTime.now();
    }
         public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
      public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
}
