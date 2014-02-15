package org.nitzi.quickhttp;

import java.io.File;
import java.io.PrintWriter;

public class Test {
public static void main(String[] args)throws Exception {
	PrintWriter pw = new PrintWriter(new File("header12.txt"));
	pw.println(QuickHttp.get("http://codechef.com"));
	pw.close();
}
}
