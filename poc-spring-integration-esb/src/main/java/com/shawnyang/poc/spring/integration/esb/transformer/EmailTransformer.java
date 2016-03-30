package com.shawnyang.poc.spring.integration.esb.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.Transformer;

public class EmailTransformer {

	@Transformer
	public List<EmailFragment> transformit(javax.mail.Message mailMessage) {
		final List<EmailFragment> emailFragments = new ArrayList<EmailFragment>();
		EmailParserUtils.handleMessage(mailMessage, emailFragments);
		return emailFragments;
	}

}