package rentalbook;

public class BookRentSaved extends AbstractEvent {

    private Long id;

    public BookRentSaved(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
