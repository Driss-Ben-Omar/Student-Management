package tp.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tp.student.entity.Student;
import tp.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudent(int page,int size,String field){
		Pageable pageRequest=PageRequest.of(page, size, Sort.by(field));
		Page<Student> students=studentRepository.findAll(pageRequest);
		return students.getContent();
	}
}
