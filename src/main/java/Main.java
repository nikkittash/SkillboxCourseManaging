import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String hibernateFail = "hibernate.cfg.xml";

        HibernateStarter.initializationConnection(hibernateFail);
//        NewTableCreater.getNewTable(HibernateStarter.getSession());
//        GetterInfo.getInfo(HibernateStarter.getSession());
        List<Purchaselist> purchases = Inserter.getPurchaseList(HibernateStarter.getSession());
        Inserter.insertIntoLinked(HibernateStarter.getSession(), purchases);
        System.out.println(Inserter.getLinkedPurchaseList(HibernateStarter.getSession()).size());
        HibernateStarter.closeConnection();
    }
}
