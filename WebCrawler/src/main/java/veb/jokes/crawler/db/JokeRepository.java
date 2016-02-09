package veb.jokes.crawler.db;

import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {

}
