
package com.veterinaria.service;

import com.veterinaria.model.Mascota;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinariaService {

    // 1. Lista que actúa como nuestra "Base de Datos" en memoria
    private List<Mascota> listaMascotas = new ArrayList<>();

    // 2. --- PATRÓN SINGLETON ---
    private static VeterinariaService instancia;

    // Constructor privado para que nadie use "new" desde fuera
    private VeterinariaService() {}

    public static VeterinariaService getInstancia() {
        if (instancia == null) {
            instancia = new VeterinariaService();
        }
        return instancia;
    }

    // 3. --- MÉTODOS DE LÓGICA ---

    public void agregarMascota(Mascota mascota) {
        listaMascotas.add(mascota);
    }

    // --- AQUÍ APLICAMOS PROGRAMACIÓN FUNCIONAL (STREAMS) ---

    // Filtrar mascotas por especie (Uso de Filter y Lambda)
    public List<Mascota> filtrarPorEspecie(String clase) {
        return listaMascotas.stream()
                .filter(m -> m.getClass().getSimpleName().equalsIgnoreCase(clase))
                .collect(Collectors.toList());
    }

    // Obtener solo los nombres (Uso de Map)
    public List<String> obtenerNombresMascotas() {
        return listaMascotas.stream()
                .map(Mascota::getNombre)
                .collect(Collectors.toList());
    }

    // Buscar una mascota específica por nombre
    public Mascota buscarPorNombre(String nombre) {
        return listaMascotas.stream()
                .filter(m -> m.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Mascota> getTodasLasMascotas() {
        return listaMascotas;
    }
}