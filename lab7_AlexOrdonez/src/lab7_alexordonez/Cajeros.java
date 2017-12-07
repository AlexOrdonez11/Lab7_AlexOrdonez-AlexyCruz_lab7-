/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_alexordonez;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Alex Ordonez
 */
public class Cajeros implements Runnable {

    private String nombre;
    private int id;
    JFrames f;
    ArrayList<Orden> ordenes = new ArrayList();

    public Cajeros() {
    }

    public Cajeros(String nombre, int id, JFrames l) {
        this.nombre = nombre;
        this.id = id;
        f = l;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("a");
            for (Orden ordene : ordenes) {
                System.out.println("5");
                f.setCliente(ordene.getCliente().getNombre());
                for (Producto p: ordene.productos) {
                    f.setProducto(p.getNombre());
                    System.out.println("1");
                    try {
                        Thread.sleep((p.getTiempo()*1000));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cajeros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    DefaultTableModel m = (DefaultTableModel) f.getTabla().getModel();
                    m.addRow(new Object[]{p.getNombre(), ordene.getCliente().getNombre(), p.getTiempo()});
                    f.getTabla().setModel(m);
                }
                ordenes.remove(ordene);
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }

}
