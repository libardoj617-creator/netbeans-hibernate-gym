package com.mycompany.hibernategym.servicioscliente;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.hibernategym.util.HibernateUtil;
import com.mycompany.hibernategym.registroclientes.DatosClientes;


public class BorrarCliente {

    public boolean eliminarCliente(int id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            DatosClientes cliente = session.get(DatosClientes.class, id);

            if (cliente == null) {
                tx.rollback(); // buena práctica: cerrar transacción si no se hace nada
                return false;
            }

            session.remove(cliente);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}


