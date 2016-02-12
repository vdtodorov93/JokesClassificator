package veb.jokes.crawler;

public final class JokeGrade {
	
	private final int thumbsUp;
	private final int thumbsDown;
	
	public JokeGrade(int thumbsUp, int thumbsDown) {
		this.thumbsUp = thumbsUp;
		this.thumbsDown = thumbsDown;
	}

	public int getThumbsUp() {
		return thumbsUp;
	}

	public int getThumbsDown() {
		return thumbsDown;
	}

	@Override
	public String toString() {
		return "JokeGrade [thumbsUp=" + thumbsUp + ", thumbsDown=" + thumbsDown + "]";
	}
}
