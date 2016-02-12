package veb.jokes.crawler.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "words")
public class Word {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(name="thumbs_up")
	private long thumbsUp;
	
	@Column(name="thumbs_down")
	private long thumbsDown;
	
	@Column(name="post_occurances")
	private long postOccurances;
	
	public Word() {}

	public Word(String name, long thumbsUp, long thumbsDown, long postOccurances) {
		super();
		this.name = name;
		this.thumbsUp = thumbsUp;
		this.thumbsDown = thumbsDown;
		this.postOccurances = postOccurances;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getThumbsUp() {
		return thumbsUp;
	}

	public void setThumbsUp(long thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	public long getThumbsDown() {
		return thumbsDown;
	}

	public void setThumbsDown(long thumbsDown) {
		this.thumbsDown = thumbsDown;
	}

	public long getPostOccurances() {
		return postOccurances;
	}

	public void setPostOccurances(long postOccurances) {
		this.postOccurances = postOccurances;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", name=" + name + ", thumbsUp=" + thumbsUp + ", thumbsDown=" + thumbsDown
				+ ", postOccurances=" + postOccurances + "]";
	}
}
