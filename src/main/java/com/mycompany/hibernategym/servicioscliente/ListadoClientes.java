package com.mycompany.hibernategym.servicioscliente;

import com.mycompany.hibernategym.registroclientes.DatosClientes;
import com.mycompany.hibernategym.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ListadoClientes {

    public List<DatosClientes> obtenerTodosLosClientes() {
        Transaction tx = null;
        List<DatosClientes> clientes = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            // Consulta HQL: Hibernate entiende que DatosClientes está mapeado a la tabla "datosclientes"
            clientes = session.createQuery("FROM DatosClientes", DatosClientes.class).list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return clientes;
    }
}


