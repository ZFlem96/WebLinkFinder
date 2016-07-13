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
	private static URL site;
	ArrayList<String> toVisit;
	ArrayList<String> hasVisit;
	ArrayList<String> siteLines = new ArrayList<>();
	ArrayList<String> siteLinks = new ArrayList<>();
	int maxVisited = 0;

	// Scanner scan = new Scanner(InputStream);

	public void processPage(BufferedReader in, ArrayList<String> linesHTML) throws IOException {
		String line = "";
		// InputStreamReader readThis = new InputStreamReader(in);
		// BufferedReader read = new BufferedReader(readThis);
		try {

			while ((line = in.readLine()) != null) {
				// System.out.println(line);
				linesHTML.add(line);
			}
		} catch (Exception e) {
			System.out.println("Nothing to print");
		}

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

	public static void main(String[] args) throws IOException {
		Driver d = new Driver();
		try {
			site =
			// new URL("https://www.google.com/?gws_rd=ssl");
			new URL("http://shalladay-iis1.student.neumont.edu/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(site.openStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> sl = d.siteLines;
		ArrayList<String> html = d.siteLines;
		d.processPage(in, sl);
		for (int x = 0; x < sl.size(); x++) {
			d.htmlLinksPattern(sl.get(x), html);
		}
		// System.out.println(html);
		
	}

}
