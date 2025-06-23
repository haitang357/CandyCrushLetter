package com.codetest.candycrushletter;

import com.codetest.candycrushletter.util.RepeatCharHandler;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CandycrushletterApplicationTests {
	@Resource
	private RepeatCharHandler repeatCharHandler;

	@Test
	void removeRepeatCharTest() {
		repeatCharHandler.removeRepeatChar("aabcccbbad");
	}

	@Test
	void replaceRepeatCharWithPreviousCharTest() {
		repeatCharHandler.replaceRepeatCharWithPreviousChar("abcccbad");
	}

}
