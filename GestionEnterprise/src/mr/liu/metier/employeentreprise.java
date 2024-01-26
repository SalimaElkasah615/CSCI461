package mr.liu.metier;

public class employeentreprise {

	private int idEntreprise;
	private int numero;
	private String contrat;
	
	public employeentreprise(int idEntreprise, int numero, String contrat) {
		super();
		this.idEntreprise = idEntreprise;
		this.numero = numero;
		this.contrat = contrat;
	}

	public int getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getContrat() {
		return contrat;
	}

	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "Travail [idEntreprise=" + idEntreprise + ", numero=" + numero + ", contrat=" + contrat + "]";
	}
	
}
