import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    public Subscription() {
    }

    @EmbeddedId
    private Key key;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Student getStudentId() {
        return key.getStudentId();
    }

    public void setStudentId(Student studentId) { key.setStudentId(this.getStudentId());}

    public Course getCourseId() {
        return key.getCourseId();
    }

    public void setCourseId(Course courseId) { key.setCourseId(this.getCourseId());}

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
