import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	public static void main(String[] args) {
		String alpha = "abcdefghijklmnopqrstuvwxyz0123456789.,:;\"-?[]' ";
		int frequency[] = new int[alpha.length()];
		String fileName = "/home/compsci/eclipse-workspace/textFiles/Kennedy_Cuba_Crisis.txt";
		String line;
		int unknown = 0;
		ArrayList aList = new ArrayList();

		// set all values in frequency array to 0

		for (int i = 0; i < alpha.length(); i++)
			frequency[i] = 0;

		// make new buffered reader for reading txt file
		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));

			if (!input.ready()) {
				input.close();
				throw new IOException();

			}
			int location;
			// while there's still something in the document
			while ((line = input.readLine()) != null) {
				line = line.toLowerCase();
				// add line to array list
				aList.add(line);
				// for each char in the line
				for (int i = 0; i < line.length(); i++) {
					// if the alphabet string contains the current char
					if (alpha.contains(String.valueOf(line.charAt(i)))) {
						// set location var to where the value of the char at i is in the alphabet
						location = alpha.indexOf(line.charAt(i));
						// change the corresponding value of the frequency array += 1
						frequency[location] += 1;
					} else {
						unknown += 1;
					}
				}
			}
			input.close();
		} catch (IOException e) {
			System.out.println("error: " + e);
		}
		int sz = aList.size();
		for (int i = 0; i < sz; i++) {
			// print every line of the kennedy cuba crisis speech
			System.out.println(aList.get(i).toString());
		}
		// for each character in the alphabet string
		for (int i = 0; i < alpha.length(); i++) {
			// print the character in the alphabet followed by the corresponding value in
			// the frequency array
			System.out.println(alpha.charAt(i) + ": " + frequency[i]);
		}
		System.out.println("unknown: " + unknown);

	} // end of main()
}
