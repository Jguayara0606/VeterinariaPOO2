package com.veterinaria.factory;

import com.veterinaria.model.*;
import com.veterinaria.exception.MascotaInvalidaException;

public class MascotaFactory {

    public static Mascota crearMascota(String tipo, String nombre, int edad, String raza) throws MascotaInvalidaException {

        // --- VALIDACIONES (Gestión de errores) ---
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MascotaInvalidaException("El nombre no puede estar vacío.");
        }
        if (edad < 0 || edad > 30) {
            throw new MascotaInvalidaException("La edad '" + edad + "' no es válida para una mascota.");
        }

        // --- LÓGICA DEL PATRÓN FACTORY ---
        if (tipo.equalsIgnoreCase("Perro")) {
            return new Perro(nombre, edad, raza);
        } else if (tipo.equalsIgnoreCase("Gato")) {
            return new Gato(nombre, edad, raza);
        } else {
            throw new MascotaInvalidaException("Tipo de mascota desconocido: " + tipo);
        }
    }
}