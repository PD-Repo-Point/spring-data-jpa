package pd.workshop.springjpadatademo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name ="Course")
@Table(
        name = "course"
)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "course_name")
    private String name;
    @Column(name = "department")
    private String department;

    @OneToMany(
            mappedBy = "course",
            orphanRemoval = true,
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void addEnrollment(Enrollment enrollment) {
        if(!this.enrollments.contains(enrollment)){
            this.enrollments.add(enrollment);
            enrollment.setCourse(this);
        }
    }
    public void removeEnrollment(Enrollment enrollment){
        if(this.enrollments.contains(enrollment)){
            this.enrollments.remove(enrollment);
            enrollment.setCourse(null);
        }
    }
}
