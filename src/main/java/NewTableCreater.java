import org.hibernate.Session;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewTableCreater {

    public NewTableCreater() {}

    protected static void getNewTable(Session session) throws SQLException {
        String hqlCreate = "USE skillbox; CREATE TABLE LinkedPurchaseList (student_id VARCHAR(500), course_id VARCHAR(500));";
        session.createQuery(hqlCreate);
        String hqlInsert = "INSERT INTO LinkedPurchaseList(student_id, course_id) select " +
                "Purchaselist.student_name as student_id, Purchaselist.course-name as course_id";
        session.createQuery(hqlInsert);
        String hql = "Select count(*) from LinkedPurchaseList";
        ResultSet resultSet = (ResultSet) session.createQuery(hql).getResultList();
        int i = 0;
        while (resultSet.next()) {
            i += 1;
        }
        System.out.println(i);


    }
}
