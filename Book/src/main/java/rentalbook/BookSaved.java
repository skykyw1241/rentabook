package rentalbook;

public class BookSaved extends AbstractEvent {

    private Long id;

    public BookSaved(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
