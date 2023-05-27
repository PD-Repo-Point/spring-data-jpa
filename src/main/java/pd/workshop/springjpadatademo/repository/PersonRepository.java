package pd.workshop.springjpadatademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pd.workshop.springjpadatademo.model.Person;

//JPARepository ---> PagingAndSortingRepository ----> CrudRepository ----> Repository

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
