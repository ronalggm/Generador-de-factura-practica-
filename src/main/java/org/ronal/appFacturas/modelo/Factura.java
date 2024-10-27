package org.ronal.appFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura items[];
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    public Factura(Cliente cliente, String descripcion) {
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
        this.cliente = cliente;
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item) {


        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        } else {
            System.out.println("el maximo de items permitidos es 10");
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (int i = 0; i < items.length; i++) {

            if (items[i] == null) {
                continue;
            }
            total += items[i].calcularImporte();

        }
        return total;
    }


    //Calucular total con bucle forEach

    public float calcularTotalforEach() {
        float total = 0.0f;
        for (ItemFactura items : this.items) {
            if (items == null) {
                continue;
            }
            total += items.calcularImporte();
        }
        return total;
    }

    @Override
    public String toString() {
        return generarDetalle();
    }

    //DETALLE FACTURA
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N: ");
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
// String fechaFormateada=sd.format(this.fecha);

        sb.
                append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\n")
                .append("Descripcion: ")
                .append(this.descripcion)
                .append("\n")
                .append("\n#\tNombre\t$\tCantidad.\tTotal\n")
                .append("Fecha Emision: ").append(sd.format(this
                        .fecha)).append("\n");

        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item.toString())//se pone el metodo toString de forma explicita
                    //para que podamos entrar al metodo en la depuracion, si bien no es
                    //obligatorio ponerlo, ya que es un metodo implicito

                    .append("\n");
        }

        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();

    }

}
