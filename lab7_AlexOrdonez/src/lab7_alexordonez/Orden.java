/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_alexordonez;

import java.util.ArrayList;

/**
 *
 * @author Alex Ordonez
 */
public class Orden {
    private Cajeros cajero;
    private Cliente cliente;
    ArrayList<Producto> productos=new ArrayList();

    public Orden() {
    }

    public Orden(Cajeros cajero, Cliente cliente) {
        this.cajero = cajero;
        this.cliente = cliente;
    }

    public Cajeros getCajero() {
        return cajero;
    }

    public void setCajero(Cajeros cajero) {
        this.cajero = cajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return cajero+" "+cliente;
    }
    
    
}
