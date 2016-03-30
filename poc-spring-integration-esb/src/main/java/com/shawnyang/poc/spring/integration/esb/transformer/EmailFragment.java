package com.shawnyang.poc.spring.integration.esb.transformer;

public class EmailFragment {

	private String filename;
	/**
	 * Could be String, InputStream, File, or byte[] Refer to:
	 * http://docs.spring.io/spring-integration/docs/4.2.5.RELEASE/reference/
	 * html/files.html#file-writing
	 */
	private Object fileContent;

	public EmailFragment(String filename, Object fileContent) {
		super();
		this.filename = filename;
		this.fileContent = fileContent;
	}

	public String getFilename() {
		return filename;
	}

	public Object getFileContent() {
		return fileContent;
	}

}
