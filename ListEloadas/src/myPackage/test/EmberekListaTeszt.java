package myPackage.test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myPackage.EmberekLista;

public class EmberekListaTeszt {

	EmberekLista adatok;

	@Before
	public void test() {
		this.adatok = new EmberekLista();
		adatok.add("Erika");
		adatok.add("Szilveszter");
		adatok.add("Judit");
		adatok.add("Miklós");
		adatok.add("Miklós");
	}

	@Test
	public void meretEllenorzes() {
		int tenylegesMeret = this.adatok.size();
		int elvartMeret = 4;

		assertEquals(elvartMeret, tenylegesMeret);
	}

	@Test
	public void uressegEllenorzes() {
		boolean uresE = this.adatok.isEmpty();

		assertFalse(uresE);
	}

	@Test
	public void ujElemHozzaad() {
		int jelenlegiMeret = this.adatok.size();

		String ujEmber = "Valaki";

		this.adatok.add(ujEmber);

		int ujMeret = this.adatok.size();

		assertEquals(jelenlegiMeret + 1, ujMeret);
		assertTrue(this.adatok.getEmberek().contains(ujEmber));

	}

	@Test
	public void teljesTartalomTorles() {
		this.adatok.removeAll();
		boolean uresE = adatok.isEmpty();

		assertTrue(uresE);

	}

	@Test(expected = NoSuchElementException.class)
	public void nemLetezoEmberTorlese() {
		String nemLetezoEmber = "Laci";
		this.adatok.remove(nemLetezoEmber);
	}

	@Test
	public void letezoEmberTorlese() {
		String letezoEmber = "Miklós";
		this.adatok.remove(letezoEmber);
	}

	@After
	public void listaUrit() {
		this.adatok.removeAll();
	}

}
