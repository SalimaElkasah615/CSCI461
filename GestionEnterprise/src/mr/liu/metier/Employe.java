package mr.liu.metier;

public class Employe {

	private int numero;
	private String nom;
	private String grade;
	private String nomDepartment;
	
	public Employe(int numero, String nom, String grade, String nomDepartment) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.grade = grade;
		this.nomDepartment = nomDepartment;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getnomDepartment() {
		return nomDepartment;
	}
	public void setnomDepartment(String nomDep) {
		this.nomDepartment = nomDep;
	}

	@Override
	public String toString() {
		return "Employe [numero=" + numero + ", nom=" + nom + ", grade=" + grade + ", nomDep=" + nomDepartment + "]";
	}
	
}
