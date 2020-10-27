package rentalbook;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="BookDelivery_table")
public class BookDelivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String 수신자;
    private String 발송자;
    private String 상태;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String get수신자() {
        return 수신자;
    }

    public void set수신자(String 수신자) {
        this.수신자 = 수신자;
    }
    public String get발송자() {
        return 발송자;
    }

    public void set발송자(String 발송자) {
        this.발송자 = 발송자;
    }
    public String get상태() {
        return 상태;
    }

    public void set상태(String 상태) {
        this.상태 = 상태;
    }




}
