package com.mycompany.hibernategym;

import com.mycompany.hibernategym.servicioscliente.ListadoClientes;
import com.mycompany.hibernategym.servicioscliente.Membresias;
import com.mycompany.hibernategym.registroclientes.DatosClientes;
import com.mycompany.hibernategym.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.hibernategym.servicioscliente.BorrarCliente;
import java.util.List;
import org.hibernate.Session;
public class Main {
    public static void main(String[] args) {
        // ============================================================
        // 1. REGISTRO DE CLIENTES (Evidencia: creación y persistencia)
        // Este bloque crea nuevos clientes y los guarda en la base de
        // datos utilizando Hibernate. Cada cliente se maneja como un
        // objeto de tipo DatosClientes y se persiste con session.persist().
        // ============================================================
        // ================================================
        // 1. REGISTRAR CLIENTES
        // ================================================
        
        Session session = HibernateUtil.getSessionFactory().openSession();   //inicia seccion
        Transaction tx = session.beginTransaction();

        DatosClientes c1 = new DatosClientes("Evelin Luna", 25, "evelin.luna@gmail.com");
        DatosClientes c2 = new DatosClientes("Jose Ortiz", 45, "jose.ortiz@gmail.com");
        DatosClientes c3 = new DatosClientes("Estefania Ardila", 31, "sthefanialean@gmail.com");
        DatosClientes c4 = new DatosClientes("Jeiler Riascos", 24, "jeiler.riascos@gmail.com");

        session.persist(c1); 
        session.persist(c2);
        session.persist(c3);
        session.persist(c4);

        tx.commit();
        session.close();

        System.out.println("Clientes ingresados correctamente!");


        // ============================================================
        // 2. ACTIVACIÓN DE MEMBRESÍA (Bloque desactivado)
        // Este bloque activa una membresía para un cliente específico.
        // Para usarlo, descomente todo el código.
        // ============================================================
        // ================================================
        // 2. ACTIVAR MEMBRESÍA (DESCOMENTAR PARA USAR)
        // ================================================

//        Membresias servicio = new Membresias();
//
//        Session session2 = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx2 = session2.beginTransaction();
//
//        DatosClientes cliente = session2.get(DatosClientes.class, 5);
//
//        if (cliente != null) {
//            servicio.activarMembresia(cliente.getId(), 30);
//            System.out.println("La membresía de " + cliente.getNombre() + " ha sido activada exitosamente.");
//            servicio.verificarMembresia(cliente.getId());
//        } else {
//            System.out.println("No se encontró el cliente con ID 5.");
//        }
//
//        tx2.commit();
//        session2.close();



        // ================================================
        // 3. BORRAR UN CLIENTE (DESCOMENTAR PARA USAR)
        //    el siguiente codigo borra una dupla al ingresar
        //    el id del cliente a borrar
        // ================================================

//        BorrarCliente bc = new BorrarCliente();
//        boolean eliminado = bc.eliminarCliente(3);
           // revisa si es verdadero luego imprime en consola
//        if (eliminado) {
//            System.out.println("Cliente eliminado correctamente.");
//        } else {
//            System.out.println("No se pudo eliminar: el cliente no existe.");
//        }



        // ================================================
        // 4. LISTAR CLIENTES (DESCOMENTAR PARA USAR)
        //    Este bloque obtiene todos los clientes registrados y los imprime
        //    en consola. Ideal para verificar el estado actual de la tabla.
        // ================================================

//        ListadoClientes listado = new ListadoClientes();
//        List<DatosClientes> clientes = listado.obtenerTodosLosClientes();
//
//        for (DatosClientes c : clientes) {
//            System.out.println("ID: " + c.getId() //imprime los datos en consola
//                    + " | Nombre: " + c.getNombre()
//                    + " | Edad: " + c.getEdad()
//                    + " | Correo: " + c.getCorreo());
//        }

    }
}

