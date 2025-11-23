package com.mycompany.hibernategym.registroclientes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "datosclientes")
public class RegistroClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "correo", unique = true, nullable = false, length = 150)
    private String correo;

    @Column(name = "estadomembresia", nullable = false)
    private boolean estadomembresia;

    @Column(name = "fecha_fin_membresia")
    private LocalDate fechaFinMembresia;

    // Constructor vacío (requerido por Hibernate)
    public RegistroClientes() {}

    // Constructor con parámetros
    public RegistroClientes(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.estadomembresia = false; // por defecto
    }

    // Getters y setters
    public int getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public boolean isEstadomembresia() { return estadomembresia; }
    public void setEstadomembresia(boolean estadomembresia) { this.estadomembresia = estadomembresia; }

    public LocalDate getFechaFinMembresia() { return fechaFinMembresia; }
    public void setFechaFinMembresia(LocalDate fechaFinMembresia) { this.fechaFinMembresia = fechaFinMembresia; }

    @Override
    public String toString() {
        return "DatosClientes [id=" + id + ", nombre=" + nombre + ", edad=" + edad +
               ", correo=" + correo + ", estadomembresia=" + estadomembresia +
               ", fechaFinMembresia=" + fechaFinMembresia + "]";
    }
}

