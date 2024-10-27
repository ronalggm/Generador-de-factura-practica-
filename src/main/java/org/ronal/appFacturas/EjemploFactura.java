package org.ronal.appFacturas;

import org.ronal.appFacturas.modelo.*;


import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Pedro");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura");
        String descripcion = entrada.nextLine();
        Factura factura = new Factura(cliente, descripcion);
        //completando los items de factura
        ItemFactura[] items = new ItemFactura[5];
        System.out.println("Ingrese los datos de la factura:");

        Producto producto;


        System.out.println();
        //en este bucle se esta creando el producto y el itemFactura
        for (int i = 0; i < 4; i++) {
            producto = new Producto();
            System.out.println("Ingese el nombre del producto nO: " + producto.getCodigo() + ": ");

            producto.setNombre(entrada.nextLine());
            System.out.println("ingrese el precio del producto");
            producto.setPrecio(entrada.nextFloat());
            System.out.println("Ingrese la candidad ");
            entrada.nextLine();
            factura.addItemFactura(new ItemFactura(producto, entrada.nextInt()));
            entrada.nextLine();
            System.out.println();
        }
        System.out.println(factura);

    }
}
