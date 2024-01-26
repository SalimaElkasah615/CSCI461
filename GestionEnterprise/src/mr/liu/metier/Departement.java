package mr.liu.metier;

public class Departement {

	private String nomDepartment;
	private String localisation;
	
	public Departement(String nomDep, String localisation) {
		super();
		this.nomDepartment = nomDep;
		this.localisation = localisation;
	}
	
	public String getNomDepartment() {
		return nomDepartment;
	}
	public void setNomDep(String nomDep) {
		this.nomDepartment = nomDep;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	@Override
	public String toString() {
		return "Departement [nomDep=" + nomDepartment + ", localisation=" + localisation + "]";
	}
	
}
