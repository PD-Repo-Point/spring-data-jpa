package pd.workshop.springjpadatademo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="PersonIdCard")
@Table(
        name = "person_id_card",
        uniqueConstraints = {
                @UniqueConstraint(name = "person_id_card_unique", columnNames = "card_number")
        }
)
public class PersonIdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "person_card_id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable=false,
            length= 15
    )
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "id",
            foreignKey = @ForeignKey(
                    name="person_id_fk"
            )
    )
    private Person person;

    public PersonIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public PersonIdCard(String cardNumber, Person person) {
        this.cardNumber = cardNumber;
        this.person = person;
    }
}
