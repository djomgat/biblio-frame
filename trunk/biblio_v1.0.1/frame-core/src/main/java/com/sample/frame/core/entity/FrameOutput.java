/**
 * 
 */
package com.sample.frame.core.entity;

/**
 * @author pdjomga
 * Fichier devant contenir la sortie des appels des methodes d'export du SOS
 */
public class FrameOutput {

	/**
	 * 
	 */
	public FrameOutput() {
		 
	}

	public FrameOutput(byte[] p$fileStream, String p$uri) {
		this.fileStream = p$fileStream;
		this.uri = p$uri;
	}
	
	byte[] fileStream;
	
	String uri;
	
	Object mergeObject;
	
	private String fileExtention;

	
	public Object getMergeObject() {
		return mergeObject;
	}

	public void setMergeObject(Object mergeObject) {
		this.mergeObject = mergeObject;
	}

	public byte[] getFileStream() {
		return fileStream;
	}

	public void setFileStream(byte[] fileStream) {
		this.fileStream = fileStream;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}

	public String getFileExtention() {
		return fileExtention;
	}
}