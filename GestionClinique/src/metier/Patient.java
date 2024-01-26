package metier;

public class Patient {
private int IDP;
private int NNI;
private String CANM;
public Patient(int iDP, int nNI, String cANM) {
	super();
	IDP = iDP;
	NNI = nNI;
	CANM = cANM;
}
public int getIDP() {
	return IDP;
}
public void setIDP(int iDP) {
	IDP = iDP;
}
public int getNNI() {
	return NNI;
}
public void setNNI(int nNI) {
	NNI = nNI;
}
public String getCANM() {
	return CANM;
}
public void setCANM(String cANM) {
	CANM = cANM;
}
@Override
public String toString() {
	return "Patient [IDP=" + IDP + ", NNI=" + NNI + ", CANM=" + CANM + "]";
}




}

