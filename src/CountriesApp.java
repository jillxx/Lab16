import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Countries Maintenance Application!");
		// CountriesTextFile.createFile();
		Scanner scnr = new Scanner(System.in);
		// show the menu:
		int menuNum = 0;
		while (menuNum != 4) {
			System.out.println("\n1 - See the list of countries\n2 - Add a country\n3 - Delete a country\n4 - Exit");

			menuNum = Validator.getInt(scnr, "\nEnter menu number: ", 1, 4);

			if (menuNum == 1) {
				// menu1.display country list
				System.out.println();
				CountriesBinaryFile.readFromFile();
				// menu2 add a country
			} else if (menuNum == 2) {
				String country = Validator.getString(scnr, "Enter country: ");
				CountriesBinaryFile.writeToFile(country);
				// menu3 delete country
			} else if (menuNum == 3) {
				String deleteCountry = Validator.getString(scnr, "What country do you want to delete from the list: ");
				CountriesBinaryFile.removeLineFromFile(deleteCountry);
			}

		}
		System.out.println("Buh-bye");
		scnr.close();
	}

}
