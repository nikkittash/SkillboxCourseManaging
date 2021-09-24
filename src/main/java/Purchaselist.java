import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class Purchaselist implements Serializable {

    @EmbeddedId
    private KeyPurhaselist keyPurhaselist;

    public  Purchaselist() {}

    public Purchaselist(KeyPurhaselist keyPurhaselist) {
        this.keyPurhaselist = keyPurhaselist;
    }

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public KeyPurhaselist getKeyPurhaselist() {
        return keyPurhaselist;
    }

    public void setKeyPurhaselist(KeyPurhaselist keyPurhaselist) {
        this.keyPurhaselist = keyPurhaselist;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public Date getSubscriptionDate() { return subscriptionDate; }

    public void setSubscriptionDate(Date subscriptionDate) { this.subscriptionDate = subscriptionDate; }

}
