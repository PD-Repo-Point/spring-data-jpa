package pd.workshop.springjpadatademo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pd.workshop.springjpadatademo.model.Person;
import pd.workshop.springjpadatademo.repository.PersonRepository;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringJpaDataDemoApplication {
	static PersonRepository personRepository;

	static Faker faker = new Faker();

	public SpringJpaDataDemoApplication(PersonRepository personRepository){
		this.personRepository = personRepository;

	}
	public static void main(String[] args) {

		SpringApplication.run(SpringJpaDataDemoApplication.class, args);
		// --- Pagination
		/*100000
				page - 1 -- size - 20
				1 - 20 20 - 40 40 - 60 (Navigate)*/
		List<Person> people = IntStream.rangeClosed(1,100)
				.mapToObj( i-> new Person(
						faker.name().firstName(),
						faker.name().lastName(),
						faker.internet().emailAddress(),
						faker.number().numberBetween(18,55)
						)).toList();

		personRepository.saveAll(people);


		// END -- Pagination

		/*Person p1 = new Person(
				"Akansha",
				"Patel",
				"akanshapatel@gmail.com",
				18
		);

		Person p2 = new Person(
				"Ananya",
				"Kumari",
				"anakum@gmail.com",
				25
		);

		Person p3 = new Person(
				"Akash",
				"Kumar",
				"akakum@gmail.com",
				24
		);

		personRepository.saveAll(List.of(p1, p2, p3));

		System.out.println("Number of person : "+personRepository.count());

		personRepository
				.findById(4l)
				.ifPresentOrElse(
						System.out::println,
						() -> System.out.println("ID is not found"));

		personRepository.findAll().stream().forEach(System.out::println); */





	}

	/*@Bean
	CommandLineRunner  commandLineRunner = new CommandLineRunner() ->{
		return args ->{

		};
	};*/



}
