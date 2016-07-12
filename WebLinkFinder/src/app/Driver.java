package app;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;
//import 
public class Driver {
	private String pattern = "<\\s*[aA]\\s+[^>]*[hH][rR][eE][fF]\\s*=\\s*\"([^\"]+)\"\\s*([^>]*)>";
	
//	Scanner scan  = new Scanner(InputStream);
	

	public void processPage(InputStream in, ArrayList<String> linesHTML) throws IOException {
//		System.out.println("In the method");
//		int s = 1;
		String line = "";
		InputStreamReader readThis = new InputStreamReader(in);
		BufferedReader read = new BufferedReader(readThis);
		try {

			while ((line = read.readLine()) != null) {
				// System.out.println(line);
				linesHTML.add(line);
			}
		} catch (Exception e) {
			System.out.println("Nothing to print");
		}
		int x = 0;

	}
	public void htmlLinksPattern(String lin, ArrayList<String> linksHTML) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(lin);
		boolean matches = m.find();
		if (matches) {
			linksHTML.add(m.group(1));
		}
	}

	public Iterator<String> getLinks(ArrayList<String> list) {
		return list.iterator();
	}

	public static void main(String[] args) {
		
	}

}
