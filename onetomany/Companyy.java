package onetomany;

import jakarta.persistence.*;
import onetoonemapping.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Companyy {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Companyid;
    private String Companyname;
    @OneToMany(mappedBy = "companyy",cascade = CascadeType.ALL,orphanRemoval = true)
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Set<Empolyee> Employee=new HashSet<>();

    public int getCompanyid() {
        return Companyid;
    }

    public void setCompanyid(int companyid) {
        Companyid = companyid;
    }

    public String getCompanyname() {
        return Companyname;
    }

    public void setCompanyname(String companyname) {
        Companyname = companyname;
    }

    public Set<Empolyee> getEmployee() {
        return Employee;
    }

    public void setEmployee(Set<Empolyee> employee) {
        Employee = employee;
    }

    @Override
    public String toString() {
        return "Companyy{" +
                "Companyid=" + Companyid +
                ", Companyname='" + Companyname + '\'' +
                ", Employee=" + Employee +
                '}';
    }
}
