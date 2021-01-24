package com.hcl.simplilearn.ProductCreation.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hcl.simplilearn.ProductCreation.entity.StudentEntity;


public class HibernateUtils {

    static SessionFactory hibernateSessionFactory;
    public static SessionFactory buildSessionFactory() {

        /* Telling hibernate where to connect to + what entities are supported */
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(StudentEntity.class);
		

        conf.configure("hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(
                        conf.getProperties()
                ).build();

        hibernateSessionFactory = conf.buildSessionFactory(registry);
        return hibernateSessionFactory;
    }

}
