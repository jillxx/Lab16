import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesBinaryFile {
	public static void main(String[] args) {
		createFile();
		writeToFile("USA\nIndia\nCanada\nFrance");

	}

	public static void readFromFile() {
		Path readFile = Paths.get("countries.dat");
		File file = readFile.toFile();// convert to a file object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}

			reader.close();// close the file reader too

		} catch (IOException e) {
			System.out.println("Something went wrong");
		}

	}

	public static void writeToFile(String country) {

		Path writeFile = Paths.get("countries.dat");
		File file = writeFile.toFile();

		try { // true add info to the file, false rewrite the file
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true)); // FileOutput Stream can take 2
																					// parameters
			outW.println(country);
			outW.close();// flushes data closes the stream
			System.out.println("This country has been saved!");

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}

	}

	public static void createFile() {

		Path filePath = Paths.get("countries.dat");

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation");
			}
		}

		System.out.println("File Name: " + filePath.getFileName());
		System.out.println("Absolute Path: " + filePath.toAbsolutePath());
	}

	public static void removeLineFromFile(String lineToRemove) {

		Path readFile = Paths.get("countries.dat");// get the path of the file
		File file = readFile.toFile();// convert to a file object.
		Path writeFile = Paths.get("temp.dat"); // create a temp file path
		File file1 = writeFile.toFile();// create a temp object.

		try {
			FileReader fr = new FileReader(file);// read char to char

			BufferedReader reader = new BufferedReader(fr);// read blocks of info
			PrintWriter outW = new PrintWriter(new FileOutputStream(file1));

			String line = null;

			while ((line = reader.readLine()) != null) {

				if (!line.equalsIgnoreCase(lineToRemove)) {

					outW.println(line);
				}
			}

			outW.close();
			reader.close();// close the file reader too
			// Delete the original file
			if (!file.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!file1.renameTo(file))
				System.out.println("Could not rename file");
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}

	}
}
