package rentalbook;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="BookRental_table")
public class BookRental {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Long deliveryId;
    private Long qty;
    private String 상태;
    private Long customerId;

    @PrePersist
    public void onPrePersist(){
        BookRentSaved bookRentSaved = new BookRentSaved();
        BeanUtils.copyProperties(this, bookRentSaved);
        bookRentSaved.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        rentalbook.external.BookRental bookRental = new rentalbook.external.BookRental();
        // mappings goes here
        RentalApplication.applicationContext.getBean(rentalbook.external.BookRentalService.class)
            .deliverySaving(bookRental);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
    public String get상태() {
        return 상태;
    }

    public void set상태(String 상태) {
        this.상태 = 상태;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }




}
