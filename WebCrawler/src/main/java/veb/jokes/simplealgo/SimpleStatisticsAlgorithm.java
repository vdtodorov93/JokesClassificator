package veb.jokes.simplealgo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.jokes.crawler.IAlgorithmGrader;
import veb.jokes.crawler.JokeGrade;
import veb.jokes.crawler.PostFilter;
import veb.jokes.crawler.db.Word;
import veb.jokes.crawler.db.WordRepository;

@Service
public class SimpleStatisticsAlgorithm implements IAlgorithmGrader {
	
	private static final double[] WORD_WEIGHT = { 2.5, 2, 2, 1.5, 1, 1, 0.5, 0.5 };
	
	@Autowired
	private WordRepository wordRepository;
	
	@Override
	public JokeGrade grade(String joke) {
		Set<String> words = PostFilter.filterWords(joke);
		List<Word> wordsInJoke = wordRepository.findWordsFrom(words);
		double totalThumbsUp = 0;
		double totalThumbsDown = 0;
		double relaxValue = 0;
		
		for(int i = 0; i < WORD_WEIGHT.length && i < wordsInJoke.size(); i++) {
			Word word = wordsInJoke.get(i);
			totalThumbsUp += WORD_WEIGHT[i] * word.getThumbsUp() / word.getPostOccurances();
			totalThumbsDown += WORD_WEIGHT[i] * word.getThumbsDown() / word.getPostOccurances();
			relaxValue += WORD_WEIGHT[i];
		}
		
		int relaxedThumbsUp = (int)(totalThumbsUp / relaxValue);
		int relaxedThumbsDown = (int)(totalThumbsDown / relaxValue);
		
		return new JokeGrade(relaxedThumbsUp, relaxedThumbsDown);
	}
	
}
