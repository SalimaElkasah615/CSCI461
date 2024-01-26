package mr.liu.metier;

public class Entreprise {
	
	private int IDentreprise;
	private String nom;
	private String siege;
	
	public Entreprise(int id, String nom, String siege) {
		super();
		this.IDentreprise = id;
		this.nom = nom;
		this.siege = siege;
	}
	
	public int getIDentreprise() {
		return IDentreprise;
	}
	public void setIdEntreprise(int id) {
		this.IDentreprise = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSiege() {
		return siege;
	}
	public void setSiege(String siege) {
		this.siege = siege;
	}

	@Override
	public String toString() {
		return "Entreprise [idEntreprise=" + IDentreprise + ", nom=" + nom + ", siege=" + siege + "]";
	}

}
