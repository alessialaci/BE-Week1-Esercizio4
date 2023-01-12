
public class Dipendente {
	
	public static double stipendioBase = 1000;
	
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(String matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = Dipendente.stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}
	
	public Dipendente(String matricola, Dipartimento dipartimento, double stipendio, double importoOrarioStraordinario, Livello livello) {
		this(matricola, dipartimento);
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public double getStipendio() {
		return stipendio;
	}
	
	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Livello getLivello() {
		return livello;
	}

	public void stampaDatiDipendente() {
		System.out.println("Matricola n.: " + this.matricola);
		System.out.println("Livello: " + this.livello);
		System.out.println("Dipartimento: " + this.dipartimento);
		System.out.printf("Stipendio minimo: €%.2f%n", this.stipendio);
		System.out.println("---------------------------------");
	}
	
	public Livello promuovi() {
		if(this.livello == Livello.OPERAIO) {
			this.stipendio = Dipendente.stipendioBase * 1.2;
			return this.livello = Livello.IMPIEGATO;
		} else if(this.livello == Livello.IMPIEGATO) {
			this.stipendio = Dipendente.stipendioBase * 1.5;
			return this.livello = Livello.QUADRO;
		} else if(this.livello == Livello.QUADRO) {
			this.stipendio = Dipendente.stipendioBase * 2;
			return this.livello = Livello.DIRIGENTE;
		} else if(this.livello == Livello.DIRIGENTE) {
			System.out.println("Non è possibile promuovere il dipendente " + this.matricola + ", è già dirigente.");
			return this.livello = Livello.DIRIGENTE;
		} else {
			this.stipendio = Dipendente.stipendioBase;
			return this.livello = Livello.OPERAIO;
		}
	}
	
	public double calcolaPaga() {
		return this.getStipendio();
	}
	
	public double calcolaPaga(int ore) {
		return this.getStipendio() + (ore * this.getImportoOrarioStraordinario());
	}

}
