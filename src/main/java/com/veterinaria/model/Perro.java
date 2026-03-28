package com.veterinaria.model;

public class Perro extends Mascota {
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad, raza);
    }

    @Override
    public String hacerSonido() {
        return "¡Guau guau!";
    }
}