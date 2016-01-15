package veb.jokes.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PageCrawler {
	private final String jokesUrl;
	private final String userId;
	private final String authToken;

	@Autowired
	public PageCrawler(@Value("${jokes.pageurl}") String jokesUrl, @Value("${bb_userid}") String userId,
			@Value("${bb_password}") String authToken) {
		this.jokesUrl = jokesUrl;
		this.userId = userId;
		this.authToken = authToken;
	}

	public List<Post> getPostsForPage(int page) throws IOException {
		String pageUrl = getPageUrl(page);
		Document doc = Jsoup.connect(pageUrl).cookie(Constants.COOKIE_USER_ID, userId)
				.cookie(Constants.COOKIE_USER_HASHED_PASSWORD, authToken).get();

		return postsFromDocument(doc);
	}

	private List<Post> postsFromDocument(Document doc) {
		List<Post> result = new ArrayList<>();
		Elements rawPosts = doc.select(Constants.CSS_SELECTOR_POST_BODY);
		for (Element rawPost : rawPosts) {
			result.add(fromElement(rawPost));
		}

		return result;
	}

	private Post fromElement(Element rawPost) {
		String content = rawPost.select(Constants.CSS_SELECTOR_POST_CONTENT).get(0).text();
		int thumbsUp = getThumbsUp(rawPost);
		int thumbsDown = getThumbsDown(rawPost);
		return Post.getPost(content, thumbsUp, thumbsDown);
	}

	private int getThumbsUp(Element rawPost) {
		// if the post is rated by the user, the thumbs are with this class
		Elements voteSection = rawPost.select(Constants.CSS_SELECTOR_THUMBS_GREEN);
		// if post is not rated
		if (voteSection.size() == 0)
			voteSection = rawPost.select(Constants.CSS_SELECTOR_THUMBS_UP);
		try {
			String thumbsUp = voteSection.get(0).nextSibling().childNode(0).childNode(0).toString();
			return Integer.parseInt(thumbsUp);
		} catch (IndexOutOfBoundsException e) {
			//the html element is empty, therefore no thumbs
			return 0;
		}
	}

	private int getThumbsDown(Element rawPost) {
		// if the post is rated by the user, the thumbs are with this class
		Elements voteSection = rawPost.select(Constants.CSS_SELECTOR_THUMBS_RED);
		// if post is not rated
		if (voteSection.size() == 0)
			voteSection = rawPost.select(Constants.CSS_SELECTOR_THUMBS_DOWN);
		try {
			String thumbsDown = voteSection.get(0).nextSibling().childNode(0).childNode(0).toString();
			return Integer.parseInt(thumbsDown);
		} catch (IndexOutOfBoundsException e) {
			//the html element is empty, therefore no thumbs
			return 0;
		}
	}

	private String getPageUrl(int page) {
		return jokesUrl + page;
	}

}
