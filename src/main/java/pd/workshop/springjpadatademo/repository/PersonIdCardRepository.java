package pd.workshop.springjpadatademo.repository;

import org.springframework.data.repository.CrudRepository;
import pd.workshop.springjpadatademo.model.PersonIdCard;

public interface PersonIdCardRepository extends CrudRepository<PersonIdCard, Long> {
}
