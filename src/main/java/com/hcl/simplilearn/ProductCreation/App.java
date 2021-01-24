package com.hcl.simplilearn.ProductCreation;

import org.hibernate.Session;

import com.hcl.simplilearn.ProductCreation.entity.StudentEntity;
import com.hcl.simplilearn.ProductCreation.hibernate.HibernateUtils;



/**
 * Hello world!
 *
 */
public class App 
{
	static Session hibernateSession;
    public static void main( String[] args )
    {
    	hibernateSession = HibernateUtils.buildSessionFactory().openSession();
    	hibernateSession.beginTransaction();
    	
        StudentEntity s = new StudentEntity();
        s.setFirstName("john");
        s.setLastName("appleseed");
        s.setPercentage(85);
        hibernateSession.save(s);
        hibernateSession.getTransaction().commit();
        System.out.println(s.getFirstName()+" "+ s.getLastName()+""+ s.getPercentage());
    }
}
