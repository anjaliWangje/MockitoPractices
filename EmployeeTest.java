package org.example;

import static org.mockito.Mockito.*;

import CompositeKey.Employee;
import CompositeKey.EmployeeId;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class EmployeeTest {
    //
        @Mock
        private SessionFactory mockSessionFactory;
        @Mock
        private Session mockSession;
        @Mock
        private Transaction mockTransaction;

        @BeforeEach
        public void setUp() {

            mockSessionFactory = mock(SessionFactory.class);
            mockSession = mock(Session.class);
            mockTransaction = mock(Transaction.class);
            when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession);
            when(mockSession.beginTransaction()).thenReturn(mockTransaction);
            when(mockSession.getTransaction()).thenReturn(mockTransaction);
        }

        @Test
        public void testSaveEmployee() {

            EmployeeId employeeId = new EmployeeId(1, "IT");


            Employee employee = new Employee(employeeId, "Anjali Wangje");

            //  transaction begin
            mockSession.beginTransaction();

            //  not actually saving to DB
            mockSession.save(employee);

            // Commit transaction
            mockSession.getTransaction().commit();

            // Verify that the methods were called
            verify(mockSession).save(employee);
            // Verifies that the transaction was started
            verify(mockSession).beginTransaction();
            // Verifies that the commit was called
            verify(mockSession.getTransaction()).commit();
        }
    }
