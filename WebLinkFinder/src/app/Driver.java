package app;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

public class Driver {

	public static void main(String[] args) throws IOException {
		Driver d = new Driver();
		ArrayList<URL> toVisit = new ArrayList<URL>();
		ArrayList<URL> hasVisited = new ArrayList<URL>();
		URL mainSite;
		VisitAction action = new VisitAction() {

			@Override
			public void Visit(URL url) {
				System.out.println(url);
			}
		};
		String url = 
				"http://shalladay-iis1.student.neumont.edu/";
//		 "http://www.cartoonnetwork.com/";
//		 "https://www.google.com/?gws_rd=ssl";
//		 "https://www.yahoo.com/";
//		 "http://www.neumont.edu/";
//				"http://www.pizzahut.com/";
//		 "http://www.nick.com/";

		Crawler c = new Crawler(toVisit, hasVisited, 100, action, url);
		c.crawl();

	}

}
