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

           /////1.Codigo para registro de clientes
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        // Crear un objeto Persona-PARA REGISTRO DE DATOS
//        DatosClientes p = new DatosClientes("Evelin Luna", 25,"evelinluna@gmail.com");
//        session.persist(p); // Guardar en la base de datos
//        // Confirmar cambios
//        tx.commit();
//        session.close();
//        System.out.println("Datos del cliente fueron ingresados correctamente!");
        
        
           /////// 2.codigo para activar membresia-descomentar para activarlo//////
        // Crear instancia del servicio
        Membresias servicio = new Membresias();
// Abrir sesión para obtener el cliente
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

// Buscar cliente por ID
DatosClientes cliente = session.get(DatosClientes.class, 5);

if (cliente != null) {
    // Activar membresía por 10 días
    servicio.activarMembresia(cliente.getId(), 30);

    // Mensaje personalizado con el nombre del cliente
    System.out.println("✅ La membresía de " + cliente.getNombre() + " ha sido activada exitosamente.");
    
    // Verificar si la membresía venció (simulación)
    servicio.verificarMembresia(cliente.getId());
} else {
    System.out.println("❌ No se encontró el cliente con ID 1.");
}
tx.commit(); ////guarda cambios y confirma
session.close(); /////aqui termina el codigo para activar membresia-cierra session

        
            //// 4. AQUI INICIA EL CODIGO PARA BORRAR CLIENTE
            
//            Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();BorrarCliente bc = new BorrarCliente();
//            boolean eliminado = bc.eliminarCliente(3);
//
//           if (eliminado) {
//         System.out.println("Cliente eliminado correctamente.");
//             } else {
//          System.out.println("No se pudo eliminar: el cliente no existe.");
//          }   /////aqui termina codigo para borrar cliente
            
            
//           // 5. para pedir listado de clientes
//        ListadoClientes listado = new ListadoClientes();
//          Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();BorrarCliente bc = new BorrarCliente();  
//        List<DatosClientes> clientes = listado.obtenerTodosLosClientes();
////
//        for (DatosClientes c : clientes) {
//            System.out.println("ID: " + c.getId() +
//                               " | Nombre: " + c.getNombre() +
//                               " | Edad: " + c.getEdad() +
//                               " | Correo: " + c.getCorreo());
//        }  //// TERMINA EL CODIGO listado de clientes
 

        


    }
}

