import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    @EmbeddedId
    private KeyForLinked keyForLinked;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList (int courseId, int studentId) {
        this.keyForLinked = new KeyForLinked(courseId, studentId);
    }

    public KeyForLinked getKeyForLinked() {
        return keyForLinked;
    }

    public void setKeyForLinked(KeyForLinked keyForLinked) {
        this.keyForLinked = keyForLinked;
    }
}
