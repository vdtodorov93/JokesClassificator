package veb.jokes.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JokeReader {
	private static final String JOKE_FILE = "imsofunny.txt";
	
	public String read() throws FileNotFoundException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(JOKE_FILE).getFile());
		try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    return everything;
		}
	}
}
