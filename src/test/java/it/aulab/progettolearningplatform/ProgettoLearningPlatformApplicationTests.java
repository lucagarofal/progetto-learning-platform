package it.aulab.progettolearningplatform;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import it.aulab.progettolearningplatform.models.Course;
import it.aulab.progettolearningplatform.models.Lesson;
import it.aulab.progettolearningplatform.models.Person;
import it.aulab.progettolearningplatform.models.Student;
import it.aulab.progettolearningplatform.repositories.CourseRepository;
import it.aulab.progettolearningplatform.repositories.LessonRepository;
import it.aulab.progettolearningplatform.repositories.StudentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProgettoLearningPlatformApplicationTests {

	@Autowired
	CourseRepository courseRepo;

	@Autowired
	LessonRepository lessonRepo;

	@Autowired
	StudentRepository studentRepo;



	@BeforeEach
	void load() {

		Person p1 = new Person();
		p1.setFirstname("Andrea"); 
		p1.setLastname("Mininni");

		Course c1 = new Course();
		c1.setName("Corso java");
		c1.setTeacher(p1);
		c1.setDescription("Lorem ipsum....");
		c1.setDate(LocalDate.now());
		
		courseRepo.save(c1);

		Lesson l1 = new Lesson();
		l1.setDate(LocalDate.now());
		l1.setDescription("Javascript");
		l1.setCourse(c1);

		lessonRepo.save(l1);

		List<Course> listsCourses = new ArrayList<Course>();

		Student s1 = new Student();
		s1.setCourses(listsCourses);
		s1.setData(p1);
		s1.setEmail("luca.garofalo@example.com");

		studentRepo.save(s1);
	
	}

	@Test
	void findByDescription(){
		Course c1 = courseRepo.findByDescription("Lorem ipsum....").get(0);
			assertThat(courseRepo.findByDescription("Lorem ipsum...."))
				.containsExactly(c1);
		
	}

	@Test
	void findByName(){
		Course c1 = courseRepo.findByName("Corso java").get(0);
		assertThat(courseRepo.findByName("Corso java"))
				.containsExactly(c1);

	}

	@Test
	void findByDate(){
		Lesson l1 = lessonRepo.findByDate(LocalDate.now()).get(0);
		assertThat(lessonRepo.findByDate(l1.getDate()))
		.containsExactly(l1);
	}

	@Test
	void findByEmail(){
		Student s1 = studentRepo.findByEmail("luca.garofalo@example.com").get(0);
		assertThat(studentRepo.findByEmail(s1.getEmail()))
		.containsExactly(s1);
		

	}

	




	

	

	

}
;