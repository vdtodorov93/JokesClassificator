package veb.jokes.crawler.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jokes")
public class Joke {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String text;
	
	@Column(name="thumbs_up")
	private long thumbsUp;
	
	@Column(name="thumbs_down")
	private long thumbsDown;
	
	public Joke() {}

	public Joke(String text, long thumbsUp, long thumbsDown) {
		this.text = text;
		this.thumbsUp = thumbsUp;
		this.thumbsDown = thumbsDown;
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

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Joke [id=" + id + ", text=" + text + ", thumbsUp=" + thumbsUp + ", thumbsDown=" + thumbsDown + "]";
	}
}
