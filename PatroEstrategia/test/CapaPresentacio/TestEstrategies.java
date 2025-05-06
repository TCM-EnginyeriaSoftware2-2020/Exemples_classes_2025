
package CapaPresentacio;


import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import CapaDomini.Venda;
import CapaDomini.EstrategiaDescompteVenda.*;

public class TestEstrategies {
	
	private static Venda vendaFicticia;
	private IEstrategiaDescompteVenda Estrategia;
	private final float diners = 80.50f;
	private final float errorAcceptat = 0.001f;
	
	@BeforeClass
	public static void TestVenda() {
		vendaFicticia = new Venda();
	}	
	
	@Test
	public void testGetTotalNula() {
		try {
			Estrategia = new EstrategiaDescompteVendaNula( "Nula" );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda Nula: " + totalVenda);
	        assertEquals (totalVenda, diners, errorAcceptat);
		} catch (Exception ex) {
			fail ("ERROR Nula: " + ex.getMessage());
		}		
	}
	
	@Test
	public void testAbsolutAmbLlindar() {
		float descompte = 2.00f;
		float llindar = 10.00f;
		float esperat = diners - descompte;
		try {
			Estrategia = new EstrategiaDescompteVendaAbsolut( descompte, llindar );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda amb llindar: " + totalVenda);
	        assertEquals (totalVenda, esperat, errorAcceptat);
		} catch (Exception ex) {
			fail ("ERROR Absolut: " + ex.getMessage());
		}		
	}
	
	@Test
	public void testAbsolut() {
		float descompte = 2.00f;
		float llindar = 100.00f;
		float esperat = diners;
		try {
			Estrategia = new EstrategiaDescompteVendaAbsolut( descompte, llindar );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda sense superar el llindar: " + totalVenda);
	        assertEquals (totalVenda, esperat, errorAcceptat);
		} catch (Exception ex) {
			fail ("ERROR Absolut: " + ex.getMessage());
		}		
	}

	@Test
	public void testPercentatge() {
		float percentatge = 0.1f;
		float esperat = diners * (1-percentatge);
		try {
			Estrategia = new EstrategiaDescompteVendaPercentatge( percentatge );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda amb percentatge: " + totalVenda);
	        assertEquals (totalVenda, esperat, errorAcceptat);
		} catch (Exception ex) {
			fail ("ERROR Absolut: " + ex.getMessage());
		}		
	}
}