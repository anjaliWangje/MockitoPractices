package manytomany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int courseid;
    private  String coursename;
    @ManyToMany(mappedBy = "course")
   // @JoinTable(name = "course_name", joinColumns = @JoinColumn(name = "course_id"),
    //        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set <studentt>s=new HashSet<>();

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Set<studentt> getS() {
        return s;
    }

    public void setS(Set<studentt> s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", s=" + s +
                '}';
    }
}
