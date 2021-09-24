import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class KeyPurhaselist implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_name", referencedColumnName = "name")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_name", referencedColumnName = "name")
    private Course course;

    public KeyPurhaselist() {
    }

    public KeyPurhaselist(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyPurhaselist)) return false;

        KeyPurhaselist that = (KeyPurhaselist) o;

        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        return course != null ? course.equals(that.course) : that.course == null;
    }

    @Override
    public int hashCode() {
        int result = student != null ? student.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }
}
