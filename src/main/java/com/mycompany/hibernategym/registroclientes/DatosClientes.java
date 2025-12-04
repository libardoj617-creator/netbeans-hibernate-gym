package com.mycompany.hibernategym.registroclientes;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entidad DatosClientes
 * Representa la tabla "datosclientes" en la base de datos mediante Hibernate.
 * Cada instancia de esta clase corresponde a un registro almacenado.
 */
@Entity
@Table(name = "datosclientes")
public class DatosClientes {

    /**
     * Campo ID autoincremental.
     * Es la clave primaria de la tabla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre completo del cliente.
     * No puede ser nulo y su longitud máxima es 100 caracteres.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * Edad del cliente.
     * Es un dato obligatorio.
     */
    @Column(name = "edad", nullable = false)
    private int edad;

    /**
     * Correo electrónico del cliente.
     * Debe ser único y no puede ser nulo.
     */
    @Column(name = "correo", unique = true, nullable = false, length = 150)
    private String correo;

    /**
     * Estado de membresía del cliente.
     * false = inactiva, true = activa.
     * Por defecto se establece en false.
     */
    @Column(name = "estadomembresia", nullable = false)
    private boolean estadomembresia;

    /**
     * Fecha en la que finaliza la membresía del cliente.
     * Puede ser nula si el cliente no tiene membresía activa.
     */
    @Column(name = "fecha_fin_membresia")
    private LocalDate fechaFinMembresia;

    /**
     * Constructor vacío requerido por Hibernate.
     */
    public DatosClientes() {}

    /**
     * Constructor con parámetros principales para crear un cliente nuevo.
     * La membresía se inicializa como inactiva por defecto.
     */
    public DatosClientes(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.estadomembresia = false;  // Valor por defecto
    }

    // ============================
    //     GETTERS Y SETTERS
    // ============================

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

    /**
     * Representación en texto del objeto DatosClientes.
     * Útil para depuración, listados y registros de consola.
     */
    @Override
    public String toString() {
        return "DatosClientes [id=" + id + ", nombre=" + nombre + ", edad=" + edad +
               ", correo=" + correo + ", estadomembresia=" + estadomembresia +
               ", fechaFinMembresia=" + fechaFinMembresia + "]";
    }
}

