package com.veterinaria.model;

public class Gato extends Mascota {
    public Gato(String nombre, int edad, String raza) {
        super(nombre, edad, raza); // Llama al constructor de la clase padre (Mascota)
    }

    @Override
    public String hacerSonido() {
        return "¡Miau miau!";
    }
}