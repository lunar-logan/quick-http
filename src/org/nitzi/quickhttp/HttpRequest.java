package org.nitzi.quickhttp;

import java.util.List;
import java.util.Map;

public class HttpRequest {
	public Map<String, List<String>> headers;
	public String data;
	
	public String toString() {
		return headers.toString() + "\n\n" + data;
	}
}
