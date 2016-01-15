package org.gradle;

import java.util.Set;

import org.junit.Test;

import veb.jokes.crawler.PostFilter;

public class PostFilterTest {
	
	String post1 = "Tурист в Гърция пита местен жител: - Как живеете тук? - Не много добре. Знаете ли, тук нищо не расте. - Как, дори ако се засее ръж? - Е, ако се засее, е друга работа.";
	String post2 = "Първоначално публикувано от RS? Еврейския Равин Худ изрязвал от богатите и давал на бедните Скрит/Hidden: леко расистки Само замени \"д\" с \"й\"";

	@Test
	public void test() {
		Set<String> w = PostFilter.filterWords(post2);
		for(String wo: w) {
			System.out.println(wo);
		}
	}

}
