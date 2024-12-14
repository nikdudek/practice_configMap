package practice_configMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SearchFilesByExtension {
	public long getNumberOfFilesWithExtension(Path pathToStartSearch, String extension) {
		long filesCounter = 0;
		if (pathToStartSearch == null || extension == null || extension.isEmpty() ) {
			return filesCounter;
		}
		try (Stream<Path> stream = Files
				.find(pathToStartSearch, Integer.MAX_VALUE, (specifiedPath, attr) -> String.valueOf(specifiedPath)
						.endsWith(extension))) {
			filesCounter = stream
					.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filesCounter;
	}
}
