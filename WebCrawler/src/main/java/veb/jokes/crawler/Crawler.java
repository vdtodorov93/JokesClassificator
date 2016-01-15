package veb.jokes.crawler;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import veb.jokes.crawler.db.Word;
import veb.jokes.crawler.db.WordRepository;

@Service
public class Crawler {
	
	@Autowired
	private WordRepository wordRepository;
	
	@Autowired
	private PageCrawler pageCrawler;
	
	//private String pageUrl;
	private int pageStart;
	private int pageEnd;
	
	@Autowired
	public Crawler(//@Value("${jokes.pageurl}") String pageUrl,
			@Value("${page_start}") int pageStart,
			@Value("${page_end}") int pageEnd) {
//		this.pageUrl = pageUrl;
		this.pageStart = pageStart;
		this.pageEnd = pageEnd;
	}
	
	
	public void crawlersGonnaCrawl() throws IOException {
		for(int i = pageStart; i <= pageEnd; i++) {
			List<Post> posts = pageCrawler.getPostsForPage(i);
			System.out.println("PAGE " + i + ":");
			for(Post p: posts) {
				processPost(p);
			}
		}		
	}
	
	private void processPost(Post post) {
		Set<String> wordsInPost = PostFilter.filterWords(post.getContent());
		for(String word: wordsInPost) {
			Word result = wordRepository.findByName(word);
			if(result == null) {
				result = new Word(word, 0, 0, 0);
			}
			result.setPostOccurances(result.getPostOccurances() + 1);
			result.setThumbsDown(result.getThumbsDown() + post.getDislikes());
			result.setThumbsUp(result.getThumbsUp() + post.getLikes());
			wordRepository.save(result);
		}
	}

}
