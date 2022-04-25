package com.example.demo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Genre;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.security.entities.AppRole;
import com.example.demo.security.entities.AppUser;
import com.example.demo.security.repositories.AppRoleRepository;
import com.example.demo.security.repositories.AppUserRepository;

@SpringBootApplication
public class EtudiantMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantMvcApplication.class, args);
		System.out.println("hii");
	}
	
	
	
	//@Bean
	public CommandLineRunner cmdRunner(EtudiantRepository etudiantRep) {
		return args -> {
			etudiantRep.save(new Etudiant(null,"ali","ali","ali@email.com",new Date(),Genre.MASCULIN,true));
			etudiantRep.save(new Etudiant(null,"ahmed","ahmed","ahmed@email.com",new Date(),Genre.MASCULIN,true));
			etudiantRep.save(new Etudiant(null,"khalid","khalid","khalid@email.com",new Date(),Genre.MASCULIN,true));
			etudiantRep.save(new Etudiant(null,"samir","samir","samir@email.com",new Date(),Genre.MASCULIN,true));
			
			etudiantRep.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
			System.out.println("test");
		};
	}
	
	//@Bean
	public CommandLineRunner cmdRunner2(AppUserRepository appUserRepository,AppRoleRepository appRoleRepository) {
		return args -> {
			AppRole role1=appRoleRepository.save(new AppRole(null,"USER"));
			AppRole role2=appRoleRepository.save(new AppRole(null,"ADMIN"));
			List<AppRole> roles=new ArrayList<>();
			roles.add(role1);
			roles.add(role2);
			
			List<AppRole> roles2=new ArrayList<>();
			roles.add(role1);
			
			appUserRepository.save(new AppUser("1","ali","ali",true,roles2 ));
			appUserRepository.save(new AppUser("2","ahmed","ahmed",true,roles));

			System.out.println("test users");
		};
	}

}
