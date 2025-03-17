package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class mainclass {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory session= cfg.buildSessionFactory();
        Companyy c1= new Companyy();
        c1.setCompanyname("tata tech");

        Empolyee e1= new Empolyee();
        e1.setEmpolyeename("anjali wangje");
        e1.setCompanyy(c1);
        Empolyee e2=new Empolyee();
        e2.setEmpolyeename("prgti satpute");
        e2.setCompanyy(c1);
        //c1.getEmployee().add(e1);
        Set<Empolyee> employee=new HashSet<>();
        employee.add(e1);
        employee.add(e2);


        Session s= session.openSession();
        s.save(e1);
        s.save(e2);
        s.save(c1);







        Transaction txt=s.beginTransaction();




        txt.commit();
        session.close();
        s.close();




    }
}
