package tp.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tp.student.entity.Groupe;
import tp.student.entity.Student;
import tp.student.repository.GroupeRepository;
import tp.student.repository.StudentRepository;

@Service
public class GroupeService {
	
	@Autowired
	GroupeRepository groupeRepository;
	
	@Autowired
	StudentRepository studentRepository;
	

	public List<Groupe> getAll(){
		return groupeRepository.findAll();
	}

	public Groupe getById(Long id) {
		return groupeRepository.findById(id).get();
	}

	public List<Student> getStudentByGroupeId(Long id){
		Groupe groupe=groupeRepository.findById(id).get();
		return studentRepository.findByGroupe(groupe);
	}

	public Student addStudentToGroupe(Long id,Student student){
		Groupe groupe=groupeRepository.findById(id).get();
		student.setGroupe(groupe);
		return studentRepository.save(student);
	}

	public Groupe addGroupe(Groupe groupe) {
		return groupeRepository.save(groupe);
	}

	public void deleteGroupe(Long id) {
		List<Student> students=studentRepository.findByGroupe(groupeRepository.findById(id).get());
		for(Student s:students) {
			s.setGroupe(null);
		}
		groupeRepository.deleteById(id);
	}

	public void deleteGroupe(Groupe groupe) {
		groupeRepository.delete(groupe);
	}

	public Groupe updateGroupe(Groupe groupe) {
		return groupeRepository.save(groupe);
	}
}
