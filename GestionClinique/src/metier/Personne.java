package metier;

public class Personne {
private int NNI;
private String Nom;
private String Prenom;

public Personne(int nNI, String nom, String prenom) {
	super();
	NNI = nNI;
	Nom = nom;
	Prenom = prenom;
}
public int getNNI() {
	return NNI;
}
public void setNNI(int nNI) {
	NNI = nNI;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
@Override
public String toString() {
	return "Personne [NNI=" + NNI + ", Nom=" + Nom + ", Prenom=" + Prenom + "]";
}

	
}
