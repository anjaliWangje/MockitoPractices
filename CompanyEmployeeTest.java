package org.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import onetoonemapping.Company;
import onetoonemapping.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
public class CompanyEmployeeTest {

                @Mock
                private SessionFactory mockSessionFactory;

                @Mock
                private Session mockSession;

                @Mock
                private Transaction mockTransaction;

                @Mock
                private Company mockCompany;

                @Mock
                private Employee mockEmployee;

                @Before
                public void setUp() {
                     MockitoAnnotations.initMocks(this);

                    when(mockSessionFactory.openSession()).thenReturn(mockSession);

                    when(mockSession.beginTransaction()).thenReturn(mockTransaction);
                }

                @Test
                public void testSaveCompanyAndEmployee() {

                    mockCompany = new Company();
                    mockCompany.setCompanyname("Tata Technologies");

                    mockEmployee = new Employee();
                    mockEmployee.setEmployeename("Anjali Wangje");
                    mockEmployee.setCompany(mockCompany);

                    mockSession.save(mockEmployee);
                    mockSession.save(mockCompany);

                    mockTransaction.commit();

                    verify(mockSession ).save(mockEmployee);
                    verify(mockSession).save(mockCompany);

                    verify(mockTransaction).commit();

                    assertEquals("Tata Technologies", mockCompany.getCompanyname());
                    assertEquals("Anjali Wangje", mockEmployee.getEmployeename());
                }
            }
