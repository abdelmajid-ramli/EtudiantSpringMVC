

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Genre;
import com.example.demo.repository.EtudiantRepository;

@SpringBootApplication
public class EtudiantMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantMvcApplication.class, args);
		System.out.println("hii");
	}
	
	@Bean
	public CommandLineRunner cmdRunner(EtudiantRepository etudiantRep) {
		return args -> {
			/*etudiantRep.save(new Etudiant(null,"ali","ali","ali@email.com",new Date(),Genre.MASCULIN,true));
			etudiantRep.save(new Etudiant(null,"ahmed","ahmed","ahmed@email.com",new Date(),Genre.MASCULIN,true));
			etudiantRep.save(new Etudiant(null,"khalid","khalid","khalid@email.com",new Date(),Genre.MASCULIN,true));
			etudiantRep.save(new Etudiant(null,"samir","samir","samir@email.com",new Date(),Genre.MASCULIN,true));
			
			etudiantRep.findAll().forEach(p->{
				System.out.println(p.getNom());
			});*/
			System.out.println("test");
		};
	}

}
