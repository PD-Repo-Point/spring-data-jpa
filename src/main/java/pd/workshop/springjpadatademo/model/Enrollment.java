package pd.workshop.springjpadatademo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "Enrollment")
@Table(name = "enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id; // person_id and course_id

    @Column(name ="created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(
            name="person_id",
            foreignKey = @ForeignKey(
                    name = "enrollment_person_id_fk")
    )
    private Person person;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name="course_id",
            foreignKey = @ForeignKey(
                    name = "enrollment_course_id_fk")
    )
    private Course course;

    public Enrollment(EnrollmentId id,
                      Person person,
                      Course course,
                      LocalDateTime createdAt) {
        this.id = id;
        this.person = person;
        this.course = course;
        this.createdAt = createdAt;

    }
}
