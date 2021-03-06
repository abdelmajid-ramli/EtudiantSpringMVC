package com.example.demo.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EtudiantRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EtudiantController {
	private EtudiantRepository etudiantRepository;
	
	
    @GetMapping(path="/user")
    @ResponseBody
    public String user(){
        return "user hii";
    }
    
    @GetMapping(path="/admin")
    @ResponseBody
    public String admin(){
        return "admin hii";
    }
	
	
	
	
	
    @GetMapping( "/")
    public String home(){
        return "home";
    }
    
    @GetMapping( "/403")
    public String error(){
        return "403";
    }
	
	@GetMapping(path="/user/etudiants")
	public String patients(Model model,
						   @RequestParam(name = "page",defaultValue = "0") int page,
						   @RequestParam(name = "size",defaultValue = "6") int size,
						   @RequestParam(name = "keyword",defaultValue = "") String keyword) {
		Page<Etudiant> etudiantsPage=etudiantRepository.findByNomContains(keyword,PageRequest.of(page, size));
		model.addAttribute("listEtudiants",etudiantsPage.getContent());
		model.addAttribute("pages",new int[etudiantsPage.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",keyword);
		return "etudiants";
	}
	
	@GetMapping(path="/admin/formEtudiant")
	public String formEtudiant(Model model) {
		
		model.addAttribute("etudiant",new Etudiant());
		
		return "formEtudiant";
	}
	
	@PostMapping(path="/admin/save")
	public String save(Model model, Etudiant etudiant, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String keyword) {
		
		if(bindingResult.hasErrors()) {
			return "formEtudiant";
		}
		etudiantRepository.save(etudiant);
		
		return "redirect:/user/etudiants?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping(path="/admin/editEtudiant")
	public String editPatient(Model model,Long id,int page,String keyword) {
		Etudiant etudiant=etudiantRepository.findById(id).orElse(null);
		if(etudiant==null) {
		throw new RuntimeException("etudiant n'existe pas");
		}
		model.addAttribute("etudiant",etudiant);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "editEtudiant";
	}
	
	@GetMapping(path="/user/showEtudiant")
	public String showPatient(Model model,Long id,int page,String keyword) {
		Etudiant etudiant=etudiantRepository.findById(id).orElse(null);
		if(etudiant==null) {
		throw new RuntimeException("etudiant n'existe pas");
		}
		model.addAttribute("etudiant",etudiant);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "showEtudiant";
	}
	
	@GetMapping(path="/admin/delete")
	public String deletePatient(Model model,@RequestParam(name = "id",defaultValue = "0") Long id,
			   				@RequestParam(name = "page",defaultValue = "0") int page,
			   				@RequestParam(name = "keyword",defaultValue = "")String keyword) {
		etudiantRepository.deleteById(id);
		return "redirect:/user/etudiants?page="+page+"&keyword="+keyword;
	}

}
