	import java.util.Scanner;
	
	public class Kalkulator {
		
		public double skladkaZus(int kwotaBrutto){
			double emerytalne = kwotaBrutto * 0.0976;
			double rentowe = kwotaBrutto * 0.015;
			double chorobowe = kwotaBrutto * 0.0245;
			return  emerytalne + rentowe + chorobowe;
		}
		
		public double podatekDochodowy (int kwotaBrutto, double stawkaPodatku, double kosztPrzychoduProcent){
			double podstawaDoZdrowotnego = kwotaBrutto - skladkaZus(kwotaBrutto);
			double kosztPrzychodu = podstawaDoZdrowotnego * kosztPrzychoduProcent;
			double podstawaPodatku = podstawaDoZdrowotnego - kosztPrzychodu;
			double pobranaZaliczka = podstawaPodatku * stawkaPodatku;
			double zdrowotneOdliczone = podstawaDoZdrowotnego * 0.09;
			double zdrowotneNieOdliczone = podstawaDoZdrowotnego * 0.0775;
			double ZdrowotnePobrane = podstawaDoZdrowotnego * 0.0125;
			double zaliczkaWplacona = pobranaZaliczka - zdrowotneNieOdliczone;
			return zaliczkaWplacona;
		}
		
		public double zdrowotneOdliczone(int kwotaBrutto){
			double podstawaDoZdrowotnego = kwotaBrutto - skladkaZus(kwotaBrutto);
			double zdrowotneOdliczone = podstawaDoZdrowotnego * 0.09;
			return zdrowotneOdliczone;
		}
			  public static void main(String[] args){
			  
		      String kwotaBrutto, stawkaPodatku, kosztPrzychoduProcent; 
		      double b,d,g,h;
		      Scanner odczyt = new Scanner(System.in); 
		     
		      System.out.println("Podaj kwotê brutto:");
		      kwotaBrutto = odczyt.nextLine();
		      System.out.println("Podaj stawkê podatku: ");
		      stawkaPodatku = odczyt.nextLine();
		      System.out.println("Podaj koszt uzyskania przychodu:");
		      kosztPrzychoduProcent = odczyt.nextLine();
		      
		      Kalkulator a = new Kalkulator();
		      b = a.skladkaZus(Integer.parseInt(kwotaBrutto));
		      Kalkulator e = new Kalkulator();
		      d = e.podatekDochodowy(Integer.parseInt(kwotaBrutto),Double.parseDouble(stawkaPodatku), Double.parseDouble(kosztPrzychoduProcent) );
		      Kalkulator f = new Kalkulator();
		      g = f.zdrowotneOdliczone(Integer.parseInt(kwotaBrutto));
		      h = Integer.parseInt(kwotaBrutto);
		      
		      System.out.println("Kwota bruto wynosi: "+kwotaBrutto+ " z³."); 
		      System.out.println("Stawka podatku dochodowego wynosi: "+stawkaPodatku); 
		      System.out.println("Koszt uzyskania przychodu wynosi: "+kosztPrzychoduProcent); 
		      System.out.println("Sk³adki ZUS wynosz¹:  "+b); 
		      System.out.println("Podatek dochodowy wynosi: "+d); 
		      System.out.println("Zdrowotne odliczone wynosi: " +g); 
		      System.out.println("Kwota netto wynosi: "+(h-(b+d+g)));    
		  }	
	}
