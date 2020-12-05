package com.samplehibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    public static void main(String[] args) {
        Session session = null;
        SessionFactory sessionFactory = null;
        try {
            Configuration conf = new Configuration().addAnnotatedClass(Empleyee.class).configure();
            sessionFactory = conf.buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction txn = session.beginTransaction();
            Empleyee empleyee = new Empleyee();
            empleyee.setDept("Java");
            empleyee.setName("Anandh");
            session.save(empleyee);
            txn.commit();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }


        }

    }
}
