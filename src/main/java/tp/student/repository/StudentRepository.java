package tp.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.student.entity.Groupe;
import tp.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public List<Student> findByGroupe(Groupe groupe);
}
