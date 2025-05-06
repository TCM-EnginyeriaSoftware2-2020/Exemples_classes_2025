
package CapaPresentacio;

import CapaAplicacio.Registre;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFactoriaAbstracte {
	
	static HashSet <Float>  resultatEsperat;
	private final float diners = 80.50f;

	@Before
	public void TestVenda() {
		resultatEsperat = new HashSet <Float> ();
	}	
	
	@Test
	public void testTotalVendaNula() {
        resultatEsperat.add(diners);//resultat esperat pel descompte null
		try {
			Registre ctl = new Registre ();
	        float totalVenda = ctl.getTotalVenda ();
	        System.out.println ("Import Total de la venda: " + totalVenda);
	        System.out.println(ctl.getDescompte());
	        assertTrue ("El resultat obtingut és: " + totalVenda, resultatEsperat.contains(totalVenda));
		} catch (Exception ex) {
			System.out.println ("ERROR Registre.getTotalVenda(): " + ex.getMessage());
		}		
	}
	
	@Test
	public void testTotalVendaAbsolut() {
        resultatEsperat.add(diners-2.50f);//resultat esperat pel descompte si supera el llindar
        resultatEsperat.add(diners);//resultat esperat pel descompte si no supera el llindar
		try {
			Registre ctl = new Registre ();
	        float totalVenda = ctl.getTotalVenda ();
	        System.out.println ("Import Total de la venda: " + totalVenda);
	        System.out.println(ctl.getDescompte());
	        assertTrue ("El resultat obtingut és: " + totalVenda, resultatEsperat.contains(totalVenda));
		} catch (Exception ex) {
			System.out.println ("ERROR Registre.getTotalVenda(): " + ex.getMessage());
		}		
	}
	
	@Test
	public void testTotalVendaPercentatge() {
        resultatEsperat.add(diners);//resultat esperat pel descompte descompte 0%
        resultatEsperat.add(diners*0.99f);//resultat esperat pel descompte descompte 1%
        resultatEsperat.add(diners*0.95f);//resultat esperat pel descompte descompte 5%
        resultatEsperat.add(diners*0.90f);//resultat esperat pel descompte descompte 10%
		try {
			Registre ctl = new Registre ();
	        float totalVenda = ctl.getTotalVenda ();
	        System.out.println ("Import Total de la venda: " + totalVenda);
	        System.out.println(ctl.getDescompte());
	        assertTrue ("El resultat obtingut és: " + totalVenda, resultatEsperat.contains(totalVenda));
		} catch (Exception ex) {
			System.out.println ("ERROR Registre.getTotalVenda(): " + ex.getMessage());
		}		
	}


}