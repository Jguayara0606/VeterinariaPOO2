package com.veterinaria.exception;

// Al heredar de Exception, obligamos al programador a usar try-catch
public class MascotaInvalidaException extends Exception {
    public MascotaInvalidaException(String mensaje) {
        super(mensaje);
    }
}