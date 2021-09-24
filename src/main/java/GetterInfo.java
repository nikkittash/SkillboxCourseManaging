import org.hibernate.Session;
import java.util.List;

public class GetterInfo {

    public GetterInfo() {}

    protected static void getInfo(Session session) {
        Student student = session.get(Student.class, 1);
        List<Course> courseList = student.getCourses();
        for (Course course : courseList) {
            System.out.println(course.getName());
        }
        List<Subscription> subscriptionList = student.getSubscriptions();
        for (Subscription subscription : subscriptionList) {
            System.out.println(subscription.getSubscriptionDate());
        }
        System.out.println("\n----------------------");
    }
}
