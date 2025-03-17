package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class demo {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory session= cfg.buildSessionFactory();
        course course1= new course();
        course1.setCoursename(" java");
        course course2= new course();
        course2.setCoursename(" python");

        studentt student1= new studentt();
        student1.setStudentname( "anuja");
        studentt student2= new studentt();
        student2.setStudentname("pallvi");
        Set<course>student11=new HashSet<>();
        student11.add(course1);
        student11.add(course2);
        student1.setCourse(student11);

        Set<course>student12=new HashSet<>();
        student12.add(course1);
        //student12.add(course2);
        student2.setCourse(student12);



        // student1.getCourse().add(course1);
      //  student1.getCourse().add(course2);
      //  student2.getCourse().add(course1);



        Session s= session.openSession();
        s.save(course1);
        s.save(course2);
        s.save(student1);
        s.save(student2);



        Transaction txt= s.beginTransaction();
    }
}
