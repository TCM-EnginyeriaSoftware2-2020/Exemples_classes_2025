package domini;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestProductes {

	private ProducteAbstracte gammerPC, PCsensePantalla;
	private ProducteAbstracte ram, disc, cpu, caixa, pantalla, mouse;

	@BeforeEach
	void setUp() throws Exception {
		ram = new ProducteSimple("Memoria RAM 32GB", 150, "Samsung");
		disc = new ProducteSimple("Disco Duro 1TB SSD", 150, "Rocket");
		cpu = new ProducteSimple("Intel i7", 400, "Intel");
		caixa = new ProducteSimple("CaaixaPC gran", 50, "MSI");
		pantalla = new ProducteSimple("Monitor 30'", 160, "HP");
		mouse = new ProducteSimple("Raton Gammer", 120, "Alien");

		gammerPC = new ProducteCompost("Gammer PC", 0.0d, "PRICOINSA");
		gammerPC.addProduct(ram);
		gammerPC.addProduct(disc);
		gammerPC.addProduct(cpu);
		gammerPC.addProduct(caixa);
		gammerPC.addProduct(pantalla);
		gammerPC.addProduct(mouse);
		
		PCsensePantalla = new ProducteCompost("PC Gammer sense pantalla",0.0d, "PRICOINSA");
		PCsensePantalla.addProduct(ram);
		PCsensePantalla.addProduct(disc);
		PCsensePantalla.addProduct(cpu);
		PCsensePantalla.addProduct(caixa);
		PCsensePantalla.addProduct(mouse);
		
		
	}

	@Test
	void test1() {//El preu del tot és igual a la suma del preu de les parts
		double costObtingut = gammerPC.getPreu();
		double costEsperat =  ram.getPreu() + disc.getPreu() + cpu.getPreu() +
				caixa.getPreu() + pantalla.getPreu() + mouse.getPreu();
		assertEquals(costEsperat, costObtingut, 0.002d, "Preu total del compost incorrecte");
	}
	
	@Test
	void test2() {//Prova cost compost en preu diferent de 0
		gammerPC = new ProducteCompost("Gammer PC", 10.0d, "PRICOINSA");
		assertTrue(gammerPC.addProduct(ram));
		assertTrue(gammerPC.addProduct(disc));
		assertTrue(gammerPC.addProduct(cpu));
		assertTrue(gammerPC.addProduct(caixa));
		assertTrue(gammerPC.addProduct(pantalla));
		assertTrue(gammerPC.addProduct(mouse));
		double costObtingut = gammerPC.getPreu();
		double costEsperat =  1030 + 10;
		assertEquals(costEsperat, costObtingut, 0.002d, "Preu total del compost incorrecte");
	}
	
	@Test
	void test3() {//Provar un compost dins un compost
		ProducteAbstracte gammerPC2 = new ProducteCompost("Gammer PC", 0.0d, "PRICOINSA");
		assertTrue(gammerPC2.addProduct(PCsensePantalla) );
		assertTrue(gammerPC2.addProduct(pantalla) );		
		double costObtingut = gammerPC2.getPreu();
		double costEsperat =  gammerPC.getPreu();
		assertEquals(costEsperat, costObtingut, 0.002d);
	}
	
	@Test
	void test4() {//Provar un compost dins un compost dins un compost		
		ProducteAbstracte gammerPC2 = new ProducteCompost("Gammer PC", 0.0d, "PRICOINSA");
		PCsensePantalla.addProduct(gammerPC);
		assertTrue(gammerPC2.addProduct(PCsensePantalla));
		double costObtingut = gammerPC2.getPreu();
		double costEsperat =  1030 + 870;
		assertEquals(costEsperat, costObtingut, 0.002d);
	}
	
	
	
	@Test
	void test5() {//Que passa si afegim un null al compost -> cal donar ERROR
		assertFalse(gammerPC.addProduct(null));
	}
	
	@Test
	void test6() {//Si fiquem un objecte dins seu -> cal donar ERROR 
		assertFalse( gammerPC.addProduct(gammerPC) );
	}
	
	
	@Test
	void test7() {//Si dos objectes els posem un dins l'altre -> cal donar ERROR
		assertTrue( PCsensePantalla.addProduct(gammerPC) );
		assertFalse( gammerPC.addProduct(PCsensePantalla) );
	}
	
	@Test
	void test8() {//Si a un compost li afegim un compost al qual li afegim el compost inicial -> cal donar ERROR	
		ProducteAbstracte gammerPC2 = new ProducteCompost("Gammer PC", 0.0d, "PRICOINSA");
		assertTrue(PCsensePantalla.addProduct(gammerPC));
		assertTrue(gammerPC.addProduct(gammerPC2));
		assertFalse(gammerPC2.addProduct(PCsensePantalla));
	}
	
	@Test
	void test9() {//a un producte simple no se li pot afegir res -> cal donar ERROR
		assertFalse(ram.addProduct(disc));
	}
}