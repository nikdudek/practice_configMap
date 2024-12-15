package practice_configMap;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ConsoleTextEditor {
	
	private static final String EXIT_TEXT = "exit";
	private File fileToWrite;
	
	public ConsoleTextEditor(File fileToWrite) {
		this.fileToWrite = fileToWrite;
	}
	
	private void saveTextToFile(StringBuilder sb) {
		try {
			Files.write(fileToWrite.toPath(), sb.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String userInput = sc.next();
			if (userInput.equalsIgnoreCase(EXIT_TEXT)) {
				saveTextToFile(sb);
				return;
			}
			sb.append(userInput).append(System.lineSeparator());
		}
		
	}
}
