
public class GestioneDipendenti {

	public static void main(String[] args) {
		
		Dipendente d1 = new Dipendente("d1", Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente("d2", Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente("d3", Dipartimento.AMMINISTRAZIONE, 1200, 30, Livello.IMPIEGATO);
		Dipendente d4 = new Dipendente("d4", Dipartimento.VENDITE, 2000, 30, Livello.DIRIGENTE);
		
		System.out.println("---------------- DATI DIPENDENTI -----------------");
		d1.stampaDatiDipendente();
		d2.stampaDatiDipendente();
		d3.stampaDatiDipendente();
		d4.stampaDatiDipendente();
		
		d2.promuovi();
		d3.promuovi();
		
		System.out.println("-------- DATI DIPENDENTI AGGIORNATI CON PROMOZIONI ---------");
		d1.stampaDatiDipendente();
		d2.stampaDatiDipendente();
		d3.stampaDatiDipendente();
		d4.stampaDatiDipendente();
		
		System.out.println("-------- STIPENDI DIPENDENTI ---------");
		stampaStipendi(d1, d2, d3, d4);
		
		System.out.println("-------- TOTALE STIPENDI ---------");
		System.out.printf("€%.2f", calcolaTotStipendi(d1, d2, d3, d4));
		
	}
	
	public static void stampaStipendi(Dipendente d1, Dipendente d2, Dipendente d3, Dipendente d4) {
		Dipendente[] dipendenti = { d1, d2, d3, d4 };	
		for(Dipendente d: dipendenti) {
			System.out.printf("Matricola n.: %s - Paga: €%.2f%n", d.getMatricola(), d.calcolaPaga());
		}
	}
	
	public static double calcolaTotStipendi(Dipendente d1, Dipendente d2, Dipendente d3, Dipendente d4) {
		Dipendente[] dipendenti = { d1, d2, d3, d4 };
		double somma = 0;
		
		for(Dipendente d: dipendenti) {
			somma += d.calcolaPaga(5);
		}
		return somma;
	}

}
