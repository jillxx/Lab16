import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Countries Maintenance Application!");
		CountriesTextFile.createFile();
		Scanner scnr = new Scanner(System.in);
		// show the menu:
		int menuNum = 0;
		while (menuNum != 3) {
			System.out.println("\n1 - See the list of countries\n2 - Add a country\n3 - Exit");

			menuNum = Validator.getInt(scnr, "\nEnter menu number: ", 1, 3);

			if (menuNum == 1) {
				// menu1.
				System.out.println();
				CountriesTextFile.readFromFile();

			} else if (menuNum == 2) {
				String country = Validator.getString(scnr, "Enter country: ");
				CountriesTextFile.writeToFile(country);
			} else {

			}

		}
		System.out.println("Buh-bye");
		scnr.close();
	}

}
