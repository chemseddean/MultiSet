package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class MultiSetParser {
	public static MultiSet<String> parse(String fileName) throws InvalidMultiSetFormat {
		MultiSet<String> HashMultiSet = new HashMultiSet<>();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new InvalidMultiSetFormat(fileName + "n'existe pas");
		}

		String line;

		try {
			while ((line = br.readLine()) != null) {
				if (line.indexOf(":") == -1)
					throw new InvalidMultiSetFormat("la ligne ne contient pas de :");
				int count;
				String[] parties = line.split(":");
				try {
					count = Integer.decode(parties[1]);
				} catch (NumberFormatException e) {
					throw new InvalidMultiSetFormat("ce qui suit le séparateur : n'est un integer");
				}
				HashMultiSet.add(parties[0], count);
			}
			br.close();
		} catch (IOException e) {
			throw new InvalidMultiSetFormat(e.getMessage());
		}

		return HashMultiSet;
	}
}