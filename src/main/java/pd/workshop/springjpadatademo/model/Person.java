package pd.workshop.springjpadatademo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entity(O) ---> class ------- Table(R) ---> database table ----> Mapping --> Hibernate
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="Person")
@Table(
        name = "person",
        uniqueConstraints = {
                @UniqueConstraint(name = "person_email_unique", columnNames = "email")
        }
)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    public Person(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
