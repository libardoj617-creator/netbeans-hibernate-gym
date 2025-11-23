package com.mycompany.hibernategym.app;

import com.mycompany.hibernategym.servicioscliente.ListadoClientes;
import com.mycompany.hibernategym.servicioscliente.Membresias;
import com.mycompany.hibernategym.registroclientes.DatosClientes;
import com.mycompany.hibernategym.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.hibernategym.servicioscliente.BorrarCliente;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Abrir sesión
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Crear un objeto Persona
        //DatosClientes p = new DatosClientes("Estefania Ardila", 31,"esthefanialean@gmail.com");
        //session.persist(p); // Guardar en la base de datos

        // Crear instancia del servicio
        Membresias servicio = new Membresias();

        // Activar membresía por 10 días para el cliente con id=1
        servicio.activarMembresia(3, 0);

        // Verificar si la membresía venció (simulación)
        servicio.verificarMembresia(1);
        
        
            // PROBAR BORRAR CLIENTE
            BorrarCliente bc = new BorrarCliente();
            boolean eliminado = bc.eliminarCliente(3);

            if (eliminado) {
        System.out.println("Cliente eliminado correctamente.");
            } else {
        System.out.println("No se pudo eliminar: el cliente no existe.");
        }
           // Probar listado de clientes
        ListadoClientes listado = new ListadoClientes();
        List<DatosClientes> clientes = listado.obtenerTodosLosClientes();

        for (DatosClientes c : clientes) {
            System.out.println("ID: " + c.getId() +
                               " | Nombre: " + c.getNombre() +
                               " | Edad: " + c.getEdad() +
                               " | Correo: " + c.getCorreo());
        }
 

        // Confirmar cambios
        tx.commit();
        session.close();

        System.out.println("Datos del cliente fueron guardados correctamente!");
    }
}

