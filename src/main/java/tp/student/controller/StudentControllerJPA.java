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

import tp.student.entity.Student;
import tp.student.repository.StudentRepository;
import tp.student.service.StudentService;

@RestController
public class StudentControllerJPA {

	@Autowired
	StudentService studentService;
	
	@GetMapping("data/student")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	@PostMapping("data/student")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	@DeleteMapping("data/student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	@DeleteMapping("data/student")
	public void deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
	}
	@PutMapping("data/student")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@GetMapping("data/student/{page}/{size}/{field}")
	public List<Student> getAllStudent(@PathVariable int page,@PathVariable int size,@PathVariable String field){
		return studentService.getAllStudent(page, size, field);
	}
}
