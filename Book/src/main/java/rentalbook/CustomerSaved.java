package rentalbook;

public class CustomerSaved extends AbstractEvent {

    private Long id;

    public CustomerSaved(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
