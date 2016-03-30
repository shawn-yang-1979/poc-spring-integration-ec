/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shawnyang.poc.spring.integration.esb.transformer;

import java.util.LinkedList;
import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * Splits a {@link List} of {@link EmailFragment}s into individual Spring
 * Integration {@link Message}s.
 *
 * @author Gunnar Hillert
 * @since 2.2
 *
 */
public class EmailSplitter {

	@Splitter
	public List<Message<?>> split(List<EmailFragment> in) {

		List<Message<?>> out = new LinkedList<Message<?>>();
		for (EmailFragment emailFragment : in) {
			Message<?> message = MessageBuilder.withPayload(emailFragment.getFileContent())
					.setHeader(FileHeaders.FILENAME, emailFragment.getFilename()).build();
			out.add(message);
		}
		return out;
	}

}
