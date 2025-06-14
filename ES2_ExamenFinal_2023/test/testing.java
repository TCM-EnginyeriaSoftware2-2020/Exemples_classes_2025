import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CapaDomini.*;

class testing {

	@Test
	void testOrganigrama() {
		Compost SrBurns = new Compost(10000000, 3);

		Compost AbrahamSimpson = new Compost("Abraham Simpson");
		assertTrue(SrBurns.add(AbrahamSimpson));
		assertTrue(AbrahamSimpson.add(new Fulla("Herbert", EnumTipusFulla.UnMilio)));
		Compost Simpson = new Compost("Simpson");
		assertTrue(AbrahamSimpson.add(Simpson));
		assertTrue(Simpson.add(new Fulla("Bart", EnumTipusFulla.UnMilio)));
		assertTrue(Simpson.add(new Fulla("Lisa", EnumTipusFulla.UnMilio)));
		assertTrue(Simpson.add(new Fulla("Maggie", EnumTipusFulla.UnaMansio)));

		assertTrue(SrBurns.add(new Fulla("Smithers", EnumTipusFulla.UnaMansio)));

		Compost Flanders = new Compost("Ned Flanders");
		assertTrue(SrBurns.add(Flanders));
		assertTrue(Flanders.add(new Fulla("Rod", EnumTipusFulla.UnMilio)));
		assertTrue(Flanders.add(new Fulla("Todd", EnumTipusFulla.UnaMansio)));

		SrBurns.establirHerencia();

		System.out.print(SrBurns.toString());
	}

	@Test
	void testDuplicats() {
		Compost SrBurns = new Compost(10000000, 3);

		Compost AbrahamSimpson = new Compost("Abraham Simpson");
		assertTrue(SrBurns.add(AbrahamSimpson));
		assertFalse(SrBurns.add(AbrahamSimpson)); // segon Abraham al mateix nivell

		assertTrue(AbrahamSimpson.add(new Fulla("Herbert", EnumTipusFulla.UnMilio)));
		Compost Simpson = new Compost("Simpson");
		assertTrue(AbrahamSimpson.add(Simpson));
		assertTrue(Simpson.add(new Fulla("Bart", EnumTipusFulla.UnMilio)));
		assertTrue(Simpson.add(new Fulla("Lisa", EnumTipusFulla.UnMilio)));

		assertTrue(Simpson.add(new Fulla("Maggie", EnumTipusFulla.UnaMansio)));
		assertFalse(SrBurns.add(new Fulla("Maggie", EnumTipusFulla.UnaMansio))); // segona Maggie a un altre nivell

		assertTrue(Simpson.add(new Fulla("Herbert", EnumTipusFulla.UnMilio))); // segon Herbert a una altre nivell
	}

	@Test
	void testMilions() {
		Compost SrBurns = new Compost(3000000, 1);

		Compost AbrahamSimpson = new Compost("Abraham Simpson");
		assertTrue(SrBurns.add(AbrahamSimpson));
		assertTrue(AbrahamSimpson.add(new Fulla("Herbert", EnumTipusFulla.UnMilio)));
		Compost Simpson = new Compost("Simpson");
		assertTrue(AbrahamSimpson.add(Simpson));
		assertTrue(Simpson.add(new Fulla("Bart", EnumTipusFulla.UnMilio)));
		assertTrue(Simpson.add(new Fulla("Lisa", EnumTipusFulla.UnMilio)));
		assertFalse(Simpson.add(new Fulla("Maggie", EnumTipusFulla.UnMilio)));
	}

	@Test
	void testMansions() {
		Compost SrBurns = new Compost(3000000, 1);

		Compost AbrahamSimpson = new Compost("Abraham Simpson");
		assertTrue(SrBurns.add(AbrahamSimpson));
		assertTrue(AbrahamSimpson.add(new Fulla("Herbert", EnumTipusFulla.UnaMansio)));
		Compost Simpson = new Compost("Simpson");
		assertTrue(AbrahamSimpson.add(Simpson));
		assertFalse(Simpson.add(new Fulla("Bart", EnumTipusFulla.UnaMansio)));

	}
}
