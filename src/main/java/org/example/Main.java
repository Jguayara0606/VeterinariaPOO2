package com.veterinaria;

import com.veterinaria.factory.MascotaFactory;
import com.veterinaria.model.Mascota;
import com.veterinaria.service.VeterinariaService;
import com.veterinaria.exception.MascotaInvalidaException;
import java.util.Scanner; // Nueva importación

public class Main {
    public static void main(String[] args) {
        VeterinariaService servicio = VeterinariaService.getInstancia();
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- 🐾 BIENVENIDO A LA VETERINARIA POO2 🐾 ---");

        // 1. Registro automático inicial (para tener datos rápidos)
        try {
            servicio.agregarMascota(MascotaFactory.crearMascota("Perro", "Lucas", 5, "Labrador"));
            servicio.agregarMascota(MascotaFactory.crearMascota("Gato", "Michi", 2, "Persa"));
        } catch (MascotaInvalidaException e) {
            System.err.println("Error inicial: " + e.getMessage());
        }

        // 2. --- BLOQUE INTERACTIVO (NIVEL PRO) ---
        System.out.println("\n--- 📝 REGISTRO MANUAL DE MASCOTA ---");
        try {
            System.out.print("¿Tipo de mascota (Perro/Gato)?: ");
            String tipo = teclado.nextLine();

            System.out.print("¿Nombre?: ");
            String nombre = teclado.nextLine();

            System.out.print("¿Edad?: ");
            int edad = Integer.parseInt(teclado.nextLine()); // Usamos parseInt para evitar errores de buffer

            System.out.print("¿Raza?: ");
            String raza = teclado.nextLine();

            // Intentamos crear con la Factory (aquí saltará la excepción si la edad es < 0)
            Mascota nuevaMascota = MascotaFactory.crearMascota(tipo, nombre, edad, raza);
            servicio.agregarMascota(nuevaMascota);

            System.out.println("✅ ¡Excelente! Mascota agregada manualmente.");

        } catch (MascotaInvalidaException e) {
            System.out.println("⚠️ ERROR DE VALIDACIÓN: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("⚠️ ERROR: La edad debe ser un número entero.");
        }

        // 3. Reporte final con Streams
        System.out.println("\n--- 📊 ESTADO ACTUAL DEL SISTEMA ---");
        servicio.getTodasLasMascotas().forEach(m ->
                System.out.println(m.getNombre() + " (" + m.getClass().getSimpleName() + ") - Sonido: " + m.hacerSonido())
        );

        System.out.println("\n--- FIN DEL PROGRAMA ---");
        teclado.close();
    }
}