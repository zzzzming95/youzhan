package pers.szm.system.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired
    private SessionFactory sessionFactory;
  
    private Session getSession()  
    {  
        return this.sessionFactory.getCurrentSession();    
    }  
    
    public void getStu(){
    	Session s = getSession();
    	System.out.println(s.createQuery("FROM Student").list().toString());
    }
    
    

}
