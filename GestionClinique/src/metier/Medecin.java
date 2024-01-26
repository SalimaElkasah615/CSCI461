package metier;

public class Medecin {
	private int IDm;
	private int  NNI;
	private String Specialite;
	public Medecin(int iDm, int nNI, String specialite) {
		super();
		IDm = iDm;
		NNI = nNI;
		Specialite = specialite;
	}
	public int getIDm() {
		return IDm;
	}
	public void setIDm(int iDm) {
		IDm = iDm;
	}
	public int getNNI() {
		return NNI;
	}
	public void setNNI(int nNI) {
		NNI = nNI;
	}
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
	@Override
	public String toString() {
		return "Medecin [IDm=" + IDm + ", NNI=" + NNI + ", Specialite=" + Specialite + "]";
	}
	
	
}