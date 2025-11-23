package com.mycompany.hibernategym.app;

import com.mycompany.hibernategym.servicioscliente.Membresias;
import com.mycompany.hibernategym.registroclientes.RegistroClientes;
import com.mycompany.hibernategym.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        servicio.activarMembresia(3, 10);

        // Verificar si la membresía venció (simulación)
        servicio.verificarMembresia(1);

        // Confirmar cambios
        tx.commit();
        session.close();

        System.out.println("Datos del cliente fueron guardados correctamente!");
    }
}

