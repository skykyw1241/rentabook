package rentalbook;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Rental_table")
public class Rental {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long rentalId;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getRentalId() {
            return rentalId;
        }

        public void setRentalId(Long rentalId) {
            this.rentalId = rentalId;
        }

}
