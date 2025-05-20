import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringGenomeTest {

	@Test
	public void testAddNucleotide() {
		// Versuchsobjekt und Vergleichswert
		StringGenome genome = new  StringGenome();
		String temp = genome.toString();

		// Methode mit gültigem Wert aufrufen und erwartetes Ergebnis überprüfen
		genome.addNucleotide('A');
		assertEquals(temp + 'A', genome.toString());

		// Methode mit ungültigem Wert aufrufen und erwartete Exception auffangen
		try {
			genome.addNucleotide('B');
		} catch (RuntimeException e) {
			assertNotEquals(temp + 'B', genome.toString());
		}
	}

	@Test
	public void testNucleotideAt() {
		// Versuchsobjekt
		StringGenome genome = new  StringGenome("ACGT");

		assertEquals('A', genome.nucleotideAt(0));
		assertNotEquals('A', genome.nucleotideAt(1));

		try {
			genome.nucleotideAt(4);
		} catch (RuntimeException e) {
			assert true;
		}
	}

	@Test
	public void testLength() {
		// Versuchsobjekt
		StringGenome genome = new  StringGenome("ACGT");

		assertEquals(4, genome.length());
		assertNotEquals(0, genome.length());
	}

	@Test
	public void testToString() {
		// Versuchsobjekt
		StringGenome genome = new  StringGenome("ACGT");

		assertEquals("ACGT", genome.toString());
		assertNotEquals("ACUT", genome.toString());
	}

	@Test
	public void testEqualsObject() {
		// Versuchsobjekte
		StringGenome genome1 = new  StringGenome("ACGT");
		StringGenome genome2 = new  StringGenome(genome1);
		StringGenome genome3 = new  StringGenome("ACUT");

		assertTrue(genome1.equals(genome2));
		assertFalse(genome1.equals(genome3));
	}
}