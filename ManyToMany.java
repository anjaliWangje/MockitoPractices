package org.example;
import static org.mockito.Mockito.*;
import manytomany.course;
import manytomany.studentt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.HashSet;
import java.util.Set;
public class ManyToMany {

        @Mock
        private SessionFactory mockSessionFactory;

        @Mock
        private Session mockSession;

        @Mock
        private Transaction mockTransaction;

        @Mock
        private course mockCourse1;

        @Mock
        private course mockCourse2;

        @Mock
        private studentt mockStudent1;

        @Mock
        private studentt mockStudent2;

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        }

        @Test
        public void testSaveCourseAndStudents() {

            mockCourse1 = new course();
            mockCourse1.setCoursename("Java");

            mockCourse2 = new course();
            mockCourse2.setCoursename("Python");

            mockStudent1 = new studentt();
            mockStudent1.setStudentname("Anuja");

            mockStudent2 = new studentt();
            mockStudent2.setStudentname("Pallavi");

            Set<course> student1Courses = new HashSet<>();
            student1Courses.add(mockCourse1);
            student1Courses.add(mockCourse2);
            mockStudent1.setCourse(student1Courses);

            Set<course> student2Courses = new HashSet<>();
            student2Courses.add(mockCourse1);
            mockStudent2.setCourse(student2Courses);

            mockSession.save(mockCourse1);
            mockSession.save(mockCourse2);
            mockSession.save(mockStudent1);
            mockSession.save(mockStudent2);

            mockTransaction.commit();

            verify(mockSession).save(mockCourse1);
            verify(mockSession).save(mockCourse2);
            verify(mockSession).save(mockStudent1);
            verify(mockSession).save(mockStudent2);

            verify(mockTransaction).commit();
        }
    }


