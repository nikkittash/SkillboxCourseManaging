import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Inserter {

    public Inserter() {}

    protected static List<Purchaselist> getPurchaseList(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Purchaselist> query = builder.createQuery(Purchaselist.class);
        Root<Purchaselist> root = query.from(Purchaselist.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    protected static void insertIntoLinked (Session session, List<Purchaselist> purchases) {
        int courseId;
        int studentId;
        for (Purchaselist purchase : purchases) {
            courseId = purchase.getKeyPurhaselist().getCourse().getId();
            studentId = purchase.getKeyPurhaselist().getStudent().getId();
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(courseId, studentId);
            session.save(linkedPurchaseList);
        }
    }

    protected static List<LinkedPurchaseList> getLinkedPurchaseList(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LinkedPurchaseList> query = builder.createQuery(LinkedPurchaseList.class);
        Root<LinkedPurchaseList> root = query.from(LinkedPurchaseList.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
}
