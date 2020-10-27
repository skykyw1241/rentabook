package rentalbook;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Delivery_table")
public class Delivery {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long deliveryId;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(Long deliveryId) {
            this.deliveryId = deliveryId;
        }

}
