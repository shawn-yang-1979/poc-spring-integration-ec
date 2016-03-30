package com.shawnyang.poc.spring.integration.esb.transformer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public final class EmailParserUtils {

	// valid names and characters taken from
	// http://msdn.microsoft.com/library/default.asp?url=/library/en-us/fileio/fs/naming_a_file.asp
	// taken from http://www.faqs.org/faqs/unix-faq/faq/part2/section-2.html
	private static final String INVALID_RESOURCE_CHARACTERS = "\\/:*?\"<>|\0";

	public static void handleMessage(final javax.mail.Message mailMessage, final List<EmailFragment> emailFragments) {
		Assert.notNull(mailMessage, "The mail message to be parsed must not be null.");
		Assert.notNull(emailFragments, "The collection of emailfragments must not be null.");
		try {
			Object content = mailMessage.getContent();
			if (content instanceof Multipart) {
				Multipart multipart = (Multipart) content;
				handleMultipartAttachment(multipart, emailFragments);
			}
		} catch (IOException | MessagingException e) {
			throw new IllegalStateException("Error while retrieving the email contents.", e);
		}
	}

	private static void handleMultipartAttachment(Multipart multipart, List<EmailFragment> emailFragments)
			throws MessagingException, IOException {
		Assert.notNull(multipart, "The multipart object to be parsed must not be null.");
		Assert.notNull(emailFragments, "The collection of emailfragments must not be null.");
		for (int i = 0; i < multipart.getCount(); i++) {
			BodyPart bp = multipart.getBodyPart(i);
			if (!Part.ATTACHMENT.equalsIgnoreCase(bp.getDisposition())) {
				continue;
			}
			Object content = bp.getContent();
			if (content instanceof String || content instanceof InputStream) {
				String fileName = MimeUtility.decodeText(bp.getFileName());
				fileName = StringUtils.replaceChars(fileName, INVALID_RESOURCE_CHARACTERS, null);
				fileName = StringUtils.trimToEmpty(fileName);
				emailFragments.add(new EmailFragment(fileName, content));
			} else if (content instanceof Multipart) {
				final Multipart multipartContent = (Multipart) content;
				handleMultipartAttachment(multipartContent, emailFragments);
			}
		}
	}
}
