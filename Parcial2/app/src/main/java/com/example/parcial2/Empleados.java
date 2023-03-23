package com.example.parcial2;

public class Empleados {
    private String nombre;
    private String cargo;
    private String compania;

    public Empleados(String nombre, String cargo, String compania) {
        this.nombre=nombre;
        this.cargo=cargo;
        this.compania=compania;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public String getCompania() {
        return compania;
    }
}
