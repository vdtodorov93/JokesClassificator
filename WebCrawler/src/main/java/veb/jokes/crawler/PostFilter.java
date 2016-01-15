package veb.jokes.crawler;

import java.util.HashSet;
import java.util.Set;

public class PostFilter {
	public static Set<String> filterWords(String postContent) {
		Set<String> filteredWords = new HashSet<>();
		postContent = postContent.replaceAll("[.!?,\":;\\/]", "");
		String[] words = postContent.split("\\s+");
		for (String word : words) {
			if (approveWord(word)) {
				filteredWords.add(word.toLowerCase());
			}
		}
		
		return filteredWords;
	}
	
	private static boolean approveWord(String word) {
		if(word.length() < 3) return false;
		return true;
	}

}
