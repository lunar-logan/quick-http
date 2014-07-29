package org.nitzi.quickhttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.CharBuffer;

public class QuickHttp {

    /**
     * Make a GET request to a HTTP/1.* server
     *
     * @param url
     * @return HTTPRequest object containing the headers and data
     * @throws URISyntaxException
     * @throws IOException
     * @see HttpRequest
     */
    public static HttpRequest get(String url) throws URISyntaxException,
            IOException {
        URI uri = new URI(url);
        URL resource = uri.toURL();
        URLConnection resourceConnection = resource.openConnection();

        HttpRequest request = new HttpRequest();
        request.headers = resourceConnection.getHeaderFields();

        // Reading from the network
        BufferedReader br = new BufferedReader(new InputStreamReader(
                resourceConnection.getInputStream()));
        CharBuffer charBuffer = CharBuffer
                .allocate(QuickHttpContext.BUFFER_LENGTH);
        char[] tempBuf = new char[(int) (QuickHttpContext.ALLOCATION_POLICY * QuickHttpContext.BUFFER_LENGTH)]; // 10%
        // size
        // of
        // buffer
        int len = 0;
        while ((len = br.read(tempBuf)) != -1 && charBuffer.remaining() >= len) {
            charBuffer.put(tempBuf, 0, len);
        }
        br.close();
        charBuffer.flip();
        char[] data = charBuffer.array();
        request.data = new String(data, 0, charBuffer.limit());

        return request;

    }

    public static void get(URI uri) throws IOException {
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
    }

}
