package onetomany;

import jakarta.persistence.*;
import onetoonemapping.Employee;

@Entity
public class Empolyee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Employeeid;
    private  String empolyeename;
    @ManyToOne
    @JoinColumn(name="Company_id")
    private  Companyy companyy;

    public int getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(int employeeid) {
        Employeeid = employeeid;
    }

    public String getEmpolyeename() {
        return empolyeename;
    }

    public void setEmpolyeename(String empolyeename) {
        this.empolyeename = empolyeename;
    }

    public Companyy getCompanyy() {
        return companyy;
    }

    public void setCompanyy(Companyy companyy) {
        this.companyy = companyy;
    }

    @Override
    public String toString() {
        return "Empolyee{" +
                "Employeeid=" + Employeeid +
                ", empolyeename='" + empolyeename + '\'' +
                ", companyy=" + companyy +
                '}';
    }
}
