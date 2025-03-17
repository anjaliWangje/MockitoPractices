package manytomany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class studentt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int studentid;
    private  String Studentname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_student",   // The join table name
            joinColumns = @JoinColumn(name = "student_id"),    // The column in the join table that references 'student'
            inverseJoinColumns = @JoinColumn(name = "course_id")   // The column in the join table that references 'course'
    )

    //@JoinColumn(name = "student_course")
    private Set<course>course =new HashSet<>();

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return Studentname;
    }

    public void setStudentname(String studentname) {
        Studentname = studentname;
    }

    public Set<manytomany.course> getCourse() {
        return course;
    }

    public void setCourse(Set<manytomany.course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "studentt{" +
                "studentid=" + studentid +
                ", Studentname='" + Studentname + '\'' +
                ", course=" + course +
                '}';
    }
}
