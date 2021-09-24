import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class KeyForLinked implements Serializable {

    @Column(name = "course_id")
    int courseId;

    @Column(name = "student_id")
    int studentId;

    public KeyForLinked() {
    }

    public KeyForLinked(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyForLinked)) return false;

        KeyForLinked that = (KeyForLinked) o;

        if (courseId != that.courseId) return false;
        return studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + studentId;
        return result;
    }

    @Override
    public String toString() {
        return "Course Id = " + courseId + "\t\tStudent Id = " + studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}

