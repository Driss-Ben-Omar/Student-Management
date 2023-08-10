package tp.student.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	Long id;
	String name;
	double note;
	@ManyToOne
	Groupe groupe;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public Student(Long id, String name, double note, Groupe groupe) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.groupe = groupe;
	}
	public Student() {
		super();
	}
	
	
}
