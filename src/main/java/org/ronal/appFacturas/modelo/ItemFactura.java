package org.ronal.appFacturas.modelo;

public class ItemFactura {

    private Producto producto;
    private int cantidad;


    public ItemFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return producto.toString() +//en este caso es lo mismo sepone explicito para...
                "\t" + cantidad +
                "\t" + calcularImporte()
                ;
    }

    public float calcularImporte() {
        return this.cantidad * this.producto.getPrecio();
    }


}


