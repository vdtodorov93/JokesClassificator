package veb.jokes.crawler.db;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WordRepository extends CrudRepository<Word, Long>{
	Word findByName(String name);
	
	@Query("SELECT w FROM Word w WHERE w.name in :words ORDER BY w.postOccurances ASC")
	List<Word> findWordsFrom(@Param("words") Set<String> words);
}

