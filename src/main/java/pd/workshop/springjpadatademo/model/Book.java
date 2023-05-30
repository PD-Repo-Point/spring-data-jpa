package pd.workshop.springjpadatademo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name ="Book")
@Table(
        name = "book"
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="book_name")
    private String bookName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "id",
            foreignKey= @ForeignKey(
                    name ="person_book_fk"
            )
    )
    private Person person;


    public Book(String bookName, LocalDateTime createdAt) {
        this.bookName= bookName;
        this.createdAt=createdAt;

    }
    public Book(String bookName, LocalDateTime createdAt, Person person) {
        this.bookName= bookName;
        this.createdAt=createdAt;
        this.person = person;
    }
}
