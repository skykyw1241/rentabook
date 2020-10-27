package rentalbook;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRentalRepository extends PagingAndSortingRepository<BookRental, Long>{


}