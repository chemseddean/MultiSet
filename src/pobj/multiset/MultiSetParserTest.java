package pobj.multiset;

public class MultiSetParserTest {

	public static void main(String[] args) {
		try {
			System.out.println(MultiSetParser.parse("data/test.txt"));
		} catch (InvalidMultiSetFormat e) {
			e.printStackTrace();
		}

	}

}