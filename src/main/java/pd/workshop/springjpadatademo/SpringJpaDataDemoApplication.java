package pd.workshop.springjpadatademo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pd.workshop.springjpadatademo.model.*;
import pd.workshop.springjpadatademo.repository.PersonIdCardRepository;
import pd.workshop.springjpadatademo.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringJpaDataDemoApplication {
	static PersonRepository personRepository;
	static PersonIdCardRepository personIdCardRepository;

	static Faker faker = new Faker();

	public SpringJpaDataDemoApplication(
			PersonRepository personRepository,
			PersonIdCardRepository personIdCardRepository){
		this.personRepository = personRepository;
		this.personIdCardRepository = personIdCardRepository;

	}
	public static void main(String[] args) {

		SpringApplication.run(SpringJpaDataDemoApplication.class, args);

		Person p1 = new Person(
				"Akansha",
				"Patel",
				"akanshapatel@gmail.com",
				18
		);
		// OneToOne
		p1.setPersonIdCard(new PersonIdCard("12234",p1));
		// OneToMany
		p1.setBooks( List.of(new
				Book("Clean Code",
				LocalDateTime.now().minusDays(4),
				p1)));
		// Embeddable class - Composite Key
		p1.addEnrollment(new Enrollment(
				new EnrollmentId(1L, 1L),
				p1,
				new Course("Computer Science", "IT"),
				LocalDateTime.now()
		));

		Person p2 = new Person(
				"Ananya",
				"Kumari",
				"anakum@gmail.com",
				25
		);
		p2.setPersonIdCard(new PersonIdCard("12834",p2));
		p2.addBook(new Book("The Clean Coder", LocalDateTime.now())); // With the help of the method
		p2.addBook(new Book("The Clean Coder", LocalDateTime.now().plusDays(4)));
				//List.of(
				//new Book("The Clean Coder", LocalDateTime.now()),
				//new Book("The Design Pattern", LocalDateTime.now())));

		Person p3 = new Person(
				"Akash",
				"Kumar",
				"akakum@gmail.com",
				24
		);
		p3.setPersonIdCard(new PersonIdCard("12238",p3));


		List<Person> people = new ArrayList<>();
		people = List.of(p1, p2, p3);

		personRepository.saveAll(people);



	}
}
