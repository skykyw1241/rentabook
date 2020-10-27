package rentalbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findById(@Param("id") Long id);
    List<Book> findByTitle(@Param("title") String title);
    List<Book> findByAuthor(@Param("author") String author);
    List<Book> findByPublisher(@Param("publisher") String publisher);

}