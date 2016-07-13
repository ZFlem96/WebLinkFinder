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
		ArrayList<String> html = d.siteLinks;
		d.processPage(in, sl);
//		for(int x =0;x<sl.size();x++){
//			System.out.println(sl.get(x));
//		}
//		System.out.println(sl);
		for (int x = 0; x < sl.size(); x++) {
			d.htmlLinksPattern(sl.get(x), html);
		}
		int y = 0;
		String[] mainPageLinks = new String[html.size()];
		while(y != 4){
		mainPageLinks[y] = "http://shalladay-iis1.student.neumont.edu"+html.get(y);
//		System.out.println(mainPageLinks[y]);
		y++;
		}
		ArrayList<String> ml1 = d.siteLines;
		ArrayList<String> html1 = d.siteLinks;
		ArrayList<String> ml2 = d.siteLines;
		ArrayList<String> html2 = d.siteLinks;
		ArrayList<String> ml3 = d.siteLines;
		ArrayList<String> html3 = d.siteLinks;
		ArrayList<String> ml4 = d.siteLines;
		ArrayList<String> html4 = d.siteLinks;
		for(int u = 0; u<mainPageLinks.length;u++){
			site=new URL(mainPageLinks[u]);
			in = new BufferedReader(new InputStreamReader(site.openStream()));
			if(u==0){
				d.processPage(in, ml1);
				for (int x = 0; x < ml1.size(); x++) {
					d.htmlLinksPattern(ml1.get(x), html1);
				}
			}
			else if(u==1){
				d.processPage(in, ml2);
				for (int x = 0; x < ml2.size(); x++) {
					d.htmlLinksPattern(ml2.get(x), html2);
				}
			}
			else if(u==2){
				d.processPage(in, ml3);
				for (int x = 0; x < ml3.size(); x++) {
					d.htmlLinksPattern(ml3.get(x), html3);
				}
			}
			else if(u==3){
				d.processPage(in, ml4);
				for (int x = 0; x < ml4.size(); x++) {
					d.htmlLinksPattern(ml4.get(x), html4);
				}
			}
		}
		System.out.println(html1);
		System.out.println("////////");
		System.out.println(html2);
		System.out.println("////////");
		System.out.println(html3);
		System.out.println("////////");
		System.out.println(html4);
//		System.out.println(html);
		// System.out.println(html);
		
	}

}
