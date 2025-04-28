package com.aluracursos.almacen.productos;

public class Producto implements Comparable<Producto>{
    String nombre;
    double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    @Override
    public String toString(){
        return "\nNombre: "+nombre+"\nPrecio: "+ precio;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return this.nombre.compareToIgnoreCase(otroProducto.getNombre());
    }
}
