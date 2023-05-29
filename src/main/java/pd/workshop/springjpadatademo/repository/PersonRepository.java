package pd.workshop.springjpadatademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pd.workshop.springjpadatademo.model.Person;

import java.util.List;
import java.util.Optional;

//JPARepository ---> PagingAndSortingRepository ----> CrudRepository ----> Repository


public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.email = ?1") // JPQL | POSITIONAL PARAMETER
    Optional<Person> findStudentByEmail(String email);

    @Query("SELECT p FROM Person p WHERE p.firstName = ?1 AND p.age >= ?2")
    List<Person> selectPersonWhereFirstNameAndAgeGreaterOrEqual(
            String firstName, Integer age);

    // Native Query
    @Query(
            value = "SELECT * FROM person where first_name= :firstName OR age>= :age",
            nativeQuery = true
    )
    List<Person> selectPersonWhereFirstNameOrAgeGreaterOrEqual(
            @Param("firstName") String firstName,
            @Param("age") Integer age);

}
