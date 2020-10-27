package rentalbook;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public void increaseStock(Long bookId, int qty) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Book book = bookOptional.get();
        book.setQty(book.getQty() - qty);

        bookRepository.save(book);
    }

    public void decreaseStock(Long bookId, int qty) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Book book = bookOptional.get();
        book.setQty(book.getQty() + qty);

        bookRepository.save(book);
    }

    public Book findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = bookOptional.get();

        return book;
    }

    public Book findByTitle(String title) {
        Optional<Book> bookOptional = bookRepository.findByTitle(title);
        Book book = bookOptional.get();

        return book;
    }

    public Book save(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Book book = null;

        try {
            book = mapper.readValue(data, Book.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookRepository.save(book);
    }
}
