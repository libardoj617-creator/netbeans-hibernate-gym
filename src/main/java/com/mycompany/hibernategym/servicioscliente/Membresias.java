package com.mycompany.hibernategym.servicioscliente;

import com.mycompany.hibernategym.registroclientes.RegistroClientes;
import com.mycompany.hibernategym.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDate;

public class Membresias {

    // Método para activar membresía por X días (máximo 30)
    public void activarMembresia(int idCliente, int diasPagados) {
        if (diasPagados <= 0 || diasPagados > 30) {
            System.out.println("Error: La cantidad de días debe ser entre 1 y 30.");
            return;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        RegistroClientes cliente = session.get(RegistroClientes.class, idCliente);
        if (cliente != null) {
            cliente.setEstadomembresia(true);
            cliente.setFechaFinMembresia(LocalDate.now().plusDays(diasPagados));
            session.update(cliente);

            System.out.println("✅ Su pago ha sido recibido exitosamente. Membresía activa por " 
                               + diasPagados + " días.");
        } else {
            System.out.println("Cliente no encontrado.");
        }

        tx.commit();
        session.close();
    }

    // Método para verificar si la membresía ya venció
    public void verificarMembresia(int idCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        RegistroClientes cliente = session.get(RegistroClientes.class, idCliente);
        if (cliente != null && cliente.getFechaFinMembresia() != null) {
            if (LocalDate.now().isAfter(cliente.getFechaFinMembresia())) {
                cliente.setEstadomembresia(false);
                session.update(cliente);
                System.out.println("⚠️ Membresía vencida. Cliente desactivado.");
            }
        }

        tx.commit();
        session.close();
    }
}


