package tp.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.student.entity.Student;

@RestController
public class StudentController {

	List<Student> students=new ArrayList<>();
	
	@GetMapping("student")
	public List<Student> findAll(){
		return this.students;
	}
	@PostMapping("student")
	public Student addStudent(@RequestBody Student student) {
		this.students.add(student);
		return student;
	}
	@DeleteMapping("student/{id}")
	public void deleteById(@PathVariable Long id) {
		this.students.removeIf(e->(e.getId()==id));
	}
	@DeleteMapping("student")
	public void deleteById(@RequestBody Student student) {
		this.students.remove(student);
	}
	@PutMapping("student")
	public Student updateStudent(@RequestBody Student student) {
		int i=0;
		for(Student stu:students) {
			if(stu.getId()==student.getId()) {
				this.students.set(i, student);
				break;
			}
			i++;
		}
		return student;
	}
}
