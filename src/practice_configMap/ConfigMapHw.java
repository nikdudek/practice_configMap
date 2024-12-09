package practice_configMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigMapHw {
	
	public static String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
		if (configMapFilePath == null || keyName == null) {
			return null;
		}
		Map<String, String> collect = Files.lines(configMapFilePath)
				.collect(Collectors.toMap(line -> ((String)line.split("=")[0]), line -> ((String)line.split("=")[1])));
		
		return collect.get(keyName);
	}
}
