package org.example;
import static org.mockito.Mockito.*;
import onetomany.Companyy;
import onetomany.Empolyee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.HashSet;
import java.util.Set;
public class OneToMany {



        @Mock
        private SessionFactory SessionFactory;

        @Mock
        private Session Session;

        @Mock
        private Transaction Transaction;

        @Mock
        private Companyy mockCompanyy;

        @Mock
        private Empolyee mockEmployee1;

        @Mock
        private Empolyee mockEmployee2;

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);

            when(SessionFactory.openSession()).thenReturn(Session);

            when(Session.beginTransaction()).thenReturn(Transaction);
        }

        @Test
        public void testSaveCompanyAndEmployees() {
            mockCompanyy = new Companyy();
            mockCompanyy.setCompanyname("Tata Tech");
            mockEmployee1 = new Empolyee();
            mockEmployee1.setEmpolyeename("Anjali Wangje");
            mockEmployee1.setCompanyy(mockCompanyy);
            mockEmployee2 = new Empolyee();
            mockEmployee2.setEmpolyeename("Pragti Satpute");
            mockEmployee2.setCompanyy(mockCompanyy);

            Set<Empolyee> employees = new HashSet<>();
            employees.add(mockEmployee1);
            employees.add(mockEmployee2);

            mockCompanyy.setEmployee(employees);

            Session.save(mockEmployee1);
            Session.save(mockEmployee2);
            Session.save(mockCompanyy);

            Transaction.commit();

            verify(Session).save(mockEmployee1);
            verify(Session).save(mockEmployee2);
            verify(Session).save(mockCompanyy);

            verify(Transaction).commit();
        }
    }

