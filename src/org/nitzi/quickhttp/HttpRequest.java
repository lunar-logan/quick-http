package org.nitzi.quickhttp;

public class HttpRequest {
	public HttpHeaders headers;
	public String data;
	
	public String toString() {
		return headers.toString() + "\n\n" + data;
	}
}
