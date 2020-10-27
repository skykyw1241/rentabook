package rentalbook;

public interface BookService {

    void increaseStock(Long bookId, int qty);
    void decreaseStock(Long bookId, int qty);

    Book getById(Long id);
    Book getByTitle(String title);
    Book getByAuthor(String author);
    Book getByPublisher(String publisher);

    Book save(String data);
}
