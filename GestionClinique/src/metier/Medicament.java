package metier;

public class Medicament {
	private int codeM;
	private String libellet;

	public Medicament(int codeM, String libellet) {
		super();
		this.codeM = codeM;
		this.libellet = libellet;
	}

	public int getCodeM() {
		return codeM;
	}

	public void setCodeM(int codeM) {
		this.codeM = codeM;
	}

	public String getLibellet() {
		return libellet;
	}

	public void setLibellet(String libellet) {
		this.libellet = libellet;
	}

	@Override
	public String toString() {
		return "Medicament [codeM=" + codeM + ", libellet=" + libellet + "]";
	}

	}


