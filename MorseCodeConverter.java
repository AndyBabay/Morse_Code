import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The class that is responsible for morse code changing
 * 
 * @author Andy Babay
 *
 */
public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * 
	 * no arg constructor
	 */
	public MorseCodeConverter() {

	}

	/**
	 * change and convert the morsecode into english language
	 * 
	 * @param code
	 *            the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String show = "";
		String[] word;
		String[] letter;

		word = code.split(" / ");

		int count = 0;

		while (count < word.length) {
			letter = word[count].split(" ");

			int counter = 0;

			while (counter < letter.length) {

				show += tree.fetch(letter[counter]);

				counter++;
			}

			show += " ";

			count++;

		}

		show = show.trim();

		return show;
	}

	/**
	 * 
	 * 
	 * @param codeFile
	 *            the code to look for the code to look for name of the File that
	 *            contains Morse Code
	 * @return the English translation of the file
	 * @throws java.io.FileNotFoundException
	 *             file will not be found
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		String output = "";
		ArrayList<String> line = new ArrayList<String>();
		String[] word; // will hold each singular word from
		String[] letter; // will hold each singular word from

		Scanner file = new Scanner(codeFile);

		while (file.hasNext()) {
			line.add(file.nextLine());
		}

		file.close();

		int count = 0;
		while (count < line.size()) {
			word = line.get(count).split(" / ");

			int i = 0;

			while (i < word.length) {
				letter = word[i].split(" ");

				int j = 0;
				while (j < letter.length) {
					output += tree.fetch(letter[j]);
				}

				output += " ";

			}

		}

		output = output.trim();

		return output;
	}

	/**
	 * prints a tree
	 * 
	 * 
	 * 
	 * @return LNR tree data
	 */
	public static String printTree() {
		ArrayList<String> trees = new ArrayList<String>();

		trees = tree.toArrayList();

		String output = "";

		int count = 0;

		while (count < trees.size()) {
			output += trees.get(count) + " ";

			count++;

		}

		return output;
	}
}