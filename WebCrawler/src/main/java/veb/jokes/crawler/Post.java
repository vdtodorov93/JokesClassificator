package veb.jokes.crawler;

public class Post {
	private final String content;
	private final String author;
	private final int likes;
	private final int dislikes;
	
	private Post(String content, String author, int likes, int dislikes) {
		this.content = content;
		this.author = author;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	
	public static Post getPost(String content, int likes, int dislikes, String author) {
		return new Post(content, author, likes, dislikes);
	}
	
	public static Post getPost(String content, int likes, int dislikes) {
		return new Post(content, null, likes, dislikes);
	}
	
	public String getContent() {
		return content;
	}
	public String getAuthor() {
		return author;
	}
	public int getLikes() {
		return likes;
	}
	public int getDislikes() {
		return dislikes;
	}

	@Override
	public String toString() {
		return "Post [content=" + content + ", likes=" + likes + ", dislikes=" + dislikes + "]";
	}
}
