package tp.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.student.entity.Groupe;
import tp.student.entity.Student;
import tp.student.repository.GroupeRepository;
import tp.student.repository.StudentRepository;
import tp.student.service.GroupeService;

@RestController
public class GroupeControllerJPA {

	@Autowired
	GroupeService groupeService;
	
	@GetMapping("data/groupe")
	public List<Groupe> getAll(){
		return groupeService.getAll();
	}
	@GetMapping("data/groupe/{id}")
	public Groupe getById(@PathVariable Long id) {
		return groupeService.getById(id);
	}
	@GetMapping("data/groupe/{id}/student")
	public List<Student> getStudentByGroupeId(@PathVariable Long id){
		return groupeService.getStudentByGroupeId(id);
	}
	@PostMapping("data/groupe/{id}/student")
	public Student addStudentToGroupe(@PathVariable Long id,@RequestBody Student student){
		return groupeService.addStudentToGroupe(id,student);
	}
	@PostMapping("data/groupe")
	public Groupe addGroupe(@RequestBody Groupe groupe) {
		return groupeService.addGroupe(groupe);
	}
	@DeleteMapping("data/groupe/{id}")
	public void deleteGroupe(@PathVariable Long id) {
		groupeService.deleteGroupe(id);
	}
	@DeleteMapping("data/groupe")
	public void deleteGroupe(@RequestBody Groupe groupe) {
		groupeService.deleteGroupe(groupe);
	}
	@PutMapping("data/groupe")
	public Groupe updateGroupe(@RequestBody Groupe groupe) {
		return groupeService.updateGroupe(groupe);
	}
}
