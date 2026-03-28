package com.veterinaria.model;

// Clase abstracta: No se pueden crear objetos "Mascota" directamente
public abstract class Mascota {
    private String nombre;
    private int edad;
    private String raza;

    public Mascota(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    // Método abstracto: Cada hijo (Perro/Gato) decidirá cómo "hablar"

    public abstract String hacerSonido();

    // Getters y Setters (Para acceder a los datos de forma segura)
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getRaza() { return raza; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Raza: " + raza;
    }
}