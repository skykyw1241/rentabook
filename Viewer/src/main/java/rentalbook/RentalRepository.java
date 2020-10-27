package rentalbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {


}