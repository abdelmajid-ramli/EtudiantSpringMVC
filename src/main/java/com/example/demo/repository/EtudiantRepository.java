package com.example.demo.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	
	Page<Etudiant> findByNomContains(String keyword,Pageable pageable);
}
