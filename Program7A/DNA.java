/*
 * Name: Joseph Godfrey
 * Date: 16/Mar/2015
 * Course: CSC 212
 * Program: Program Ch7A
 * 
 * Description:
 * 
 *   
 *   
 *   
 * Strategy discussions with ....
 * 
 */
import java.io.*; // for File
import java.text.DecimalFormat;
import java.util.*; // for Scanner, Arrays

public class DNA {
	public static double[] MASSES = { 135.128, 111.103, 151.128, 125.107 };
	public static double JUNKMASS = 100.000;
	public static int NUCLEOTIDES = 4;
	public static int CODONS = 5;
	public static int NUCSPERCODON = 3;
	public static int ISITAPROTEIN = 30;// percent
	
	public static void main(String[] args) throws FileNotFoundException {
		intro();
		Scanner console = new Scanner(System.in);

		// prompt for file name
		System.out.print("Input file name? ");
		Scanner input = new Scanner(new File(console.nextLine()));
		System.out.println();
		// process each possible protein from the file
		while (input.hasNextLine()) {
			String name = input.nextLine();
			String sequence = input.nextLine().toUpperCase();

			// count number of "junk sections" in the DNA
			String sequenceWithoutJunk = sequence.replace("-", "");
			int junkCount = sequence.length() - sequenceWithoutJunk.length();

			int[] nucCounts = getCounts(sequenceWithoutJunk);
			double totalMass = getTotalMass(nucCounts, junkCount);
			double[] percentages = getPercentages(nucCounts, totalMass);
			String[] codons = getCodons(sequenceWithoutJunk);
			formatArrays(percentages, codons);
			reportResults(name, sequence, nucCounts, totalMass, percentages,
					codons);

		}

		console.close();
		input.close();
	}

	/*
	 * Method intro displays a brief program description for the user
	 */
	public static void intro() {
		System.out.println("This program reports information about DNA");
		System.out.println("nucleotide sequences that may encode proteins.\n");
	}
	//counts the number of each type of nucleotide
	public static int[] getCounts(String sequenceWithoutJunk) {
		int[] nucCounts = new int[NUCLEOTIDES];
		for (int i = 0; i < sequenceWithoutJunk.length(); i++) {
			char comparer = sequenceWithoutJunk.toUpperCase().charAt(i);
			if (comparer == 'A') {
				nucCounts[0]++;
			}
			if (comparer == 'C') {
				nucCounts[1]++;
			}
			if (comparer == 'G') {
				nucCounts[2]++;
			}
			if (comparer == 'T') {
				nucCounts[3]++;
			}
		}
		return nucCounts;
	}
	//gets the mass of the entire string, including the junk
	public static double getTotalMass(int[] nucCounts, int junkCount) {
		double totalMass = 0.0;
		for (int i = 0; i < NUCLEOTIDES; i++) {
			totalMass = totalMass + (nucCounts[i] * MASSES[i]);
		}
		totalMass = totalMass + junkCount * JUNKMASS;
		return totalMass;
	}
	//gets the percent mass of every total of nucelotides
	public static double[] getPercentages(int[] nucCounts, double totalMass) {
		double[] percentage = new double[NUCLEOTIDES];
		for (int i = 0; i < NUCLEOTIDES; i++) {
			percentage[i] = (nucCounts[i] * MASSES[i]) / totalMass * 100;
		}
		return percentage;

	}
	//splits the sequencewithoutjunk string into 3-letter codons
	public static String[] getCodons(String sequenceWithoutJunk) {
		String[] codons = new String[(sequenceWithoutJunk.length() / NUCSPERCODON)];
		for (int i = 0; i < sequenceWithoutJunk.length(); i = i + NUCSPERCODON) {
			codons[i / NUCSPERCODON] = sequenceWithoutJunk.substring(i,
					(i + NUCSPERCODON));
		}
		return codons;
	}
	//formats the double numbers in the percentages array
	public static void formatArrays(double[] percentages, String[] codons) {

		for (int i = 0; i < percentages.length; i++) {
			percentages[i] = ((double) Math.round(percentages[i] * 10)) / 10;
		}
	}
	//Prints out the results computed prior
	public static void reportResults(String name, String sequence,
			int[] nucCounts, double totalMass, double[] percentages,
			String[] codons) {

		System.out.println("Region name: " + name);
		System.out.println("Nucleotides: " + sequence.toUpperCase());
		System.out.println("Nuc. Counts: " + Arrays.toString(nucCounts));
		System.out.print("Total Mass%: " + Arrays.toString(percentages));
		System.out.printf(" of %.2f \n", totalMass);
		System.out.println("Codons List: " + Arrays.toString(codons));
		System.out.print("Is Protein?: ");
		if (isProtein(percentages, codons)) {
			System.out.print("YES\n\n");
		} else {
			System.out.print("NO\n\n");
		}
	}

	//determines if the dna is a protein (true/false)
	public static boolean isProtein(double[] percentages, String[] codons) {
		if ((Arrays.asList(codons[0]).contains("ATG"))
				&& (Arrays.asList(codons[codons.length - 1]).contains("TAA")
						|| Arrays.asList(codons[codons.length - 1]).contains(
								"TAG") || Arrays.asList(
						codons[codons.length - 1]).contains("TGA"))
				&& codons.length >= CODONS
				&& (percentages[1] + percentages[2] >= ISITAPROTEIN)) {
			return true;
		} else {
			return false;
		}
	}
}