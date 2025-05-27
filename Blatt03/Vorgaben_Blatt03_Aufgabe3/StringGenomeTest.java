import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringGenomeTest {

	@Test
	public void testAddNucleotide() {
		// Versuchsobjekt und Vergleichswert
		StringGenome genome = new  StringGenome();
		String temp = genome.toString();

		// Methode mit gültigem Wert aufrufen und erwartetes Ergebnis überprüfen
		System.out.println("Testing logically correct input\n");
		genome.addNucleotide('A');
		assertEquals(temp + 'A', genome.toString());

		// Methode mit ungültigem Wert aufrufen und erwartete Exception auffangen
		try {
			System.out.println("Try illegal input\n");
			genome.addNucleotide('B');
		} catch (RuntimeException e) {
			assertEquals(temp + 'A', genome.toString());
			assertNotEquals(temp + "AB", genome.toString());
			System.out.println("Illegal input not accepted\n");
		}
	}

	@Test
	public void testNucleotideAt() {
		// Versuchsobjekt
		StringGenome genome = new  StringGenome("ACGT");

		System.out.println("Testing logically correct index\n");
		assertEquals('A', genome.nucleotideAt(0));
		assertNotEquals('A', genome.nucleotideAt(1));

		try {
			System.out.println("Testing illegal index\n");
			genome.nucleotideAt(4);
		} catch (RuntimeException e) {
			System.out.println("Illegal index not accepted\n");
		}
	}

	@Test
	public void testLength() {
		// Versuchsobjekt
		StringGenome genome = new  StringGenome("ACGT");

		System.out.println("Testing logically correct length\n");
		assertEquals(4, genome.length());
		System.out.println("Testing incorrect length\n");
		assertNotEquals(0, genome.length());
	}

	@Test
	public void testToString() {
		// Versuchsobjekt
		StringGenome genome = new  StringGenome("ACGT");

		System.out.println("Testing logically correct toString\n");
		assertEquals("ACGT", genome.toString());
		System.out.println("Testing incorrect toString\n");
		assertNotEquals("ACUT", genome.toString());
	}

	@Test
	public void testEqualsObject() {
		// Versuchsobjekte
		StringGenome genome1 = new  StringGenome("ACGT");
		StringGenome genome2 = new  StringGenome(genome1);
		StringGenome genome3 = new  StringGenome("ACUT");

		System.out.println("Testing equal objects\n");
		assertTrue(genome1.equals(genome2));
		System.out.println("Testing unequal objects\n");
		assertFalse(genome1.equals(genome3));
	}
}