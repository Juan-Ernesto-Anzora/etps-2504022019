package com.example.guia4_ejercicio4;

public class Person {
    private String nombre;
    private int edad;
    private String direccion;

    public Person(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }
}
