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
	ArrayList<String> siteLines = new ArrayList<>();
	ArrayList<String> siteLinks = new ArrayList<>();
	int maxVisited = 0;

	// Scanner scan = new Scanner(InputStream);

	public void processPage(BufferedReader in, ArrayList<String> linesHTML) throws IOException {
		String line = "";
		try {

			while ((line = in.readLine()) != null) {
				linesHTML.add(line);
			}
		} catch (Exception e) {
			System.out.println("Nothing to print");
		}

	}

	public void htmlLinksPattern(String lin, ArrayList<URL> linksHTML) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(lin);
		boolean matches = m.find();
		if (matches) {
			String t = m.group(1);
			URL tmp = null;
			try {
				tmp = new URL("http://shalladay-iis1.student.neumont.edu");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			if(!t.startsWith("http://shalladay-iis1.student.neumont.edu/")){
				URL hold = tmp;
			try {
				tmp = new URL(hold + t);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			}
			linksHTML.add(tmp);
		}
	}

	public Iterator<URL> getLinks(ArrayList<URL> list) {
		return list.iterator();
	}

	public static void main(String[] args) throws IOException {
		Driver d = new Driver();
		Crawler c = new Crawler();
		c.toVisit = new ArrayList<URL>();
		c.hasVisited = new ArrayList<URL>();
		ArrayList<URL> toVisit= c.toVisit;
		ArrayList<URL> hasVisited= c.hasVisited;
		try {
			site =
			// new URL("https://www.google.com/?gws_rd=ssl");
			new URL("http://shalladay-iis1.student.neumont.edu/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		toVisit.add(site);
		c.crawl(toVisit, hasVisited);

		System.out.println("/////////////");
		for(int x =0; x<hasVisited.size(); x++){
			System.out.println((x+1)+". "+hasVisited.get(x));
		}
		

	}

}
