package practice_configMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String filePath = "testDirectory" + File.separator + "demo.txt";
		String directoryName = "testDirectory";
		String textToWrite = "discount=0.1" + System.lineSeparator()
				+ "database.user=admin" + System.lineSeparator()
				+ "database.password=qwerty";
		
		File file = new File(directoryName);
		if (file.mkdir()) {
			System.out.println("Directory successfully created");
		} else {
			System.out.println("- File already exist -");
		}
		
		file = new File(filePath);
		file.createNewFile();

		try {
			writeFileToPathFileOutputStream(filePath, textToWrite);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static void writeFileToPathFileOutputStream(String path, String textToWrite) throws FileNotFoundException, IOException{
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			byte[] bytes = textToWrite.getBytes();
			fos.write(bytes);
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

}
