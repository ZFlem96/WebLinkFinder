package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Crawler implements VisitAction {
	static ArrayList<URL> toVisit;
	static ArrayList<URL> hasVisited;
	private static final int MAX_VALUE = 100;

	public void crawl(ArrayList<URL> toVisit, ArrayList<URL> visited) {
		int counter =0;
		while (!toVisit.isEmpty() && counter < MAX_VALUE) {
				URL tmp = toVisit.get(0);
				if (counter > 0) {
					if (!tmp.toString().startsWith("http://shalladay-iis1.student.neumont.edu/")) {
						String con = tmp.toString();
						try {
							tmp = new URL("http://shalladay-iis1.student.neumont.edu/" + con);
						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				}
				visited.add(tmp);
				toVisit.remove(0);
				try {
					visit(tmp, toVisit, visited);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			counter++;
		}
	}

	// public void visit(URL url)
	public void visit(URL url, ArrayList<URL> toVisit, ArrayList<URL> visited) throws Exception {
		BufferedReader proccesUrl = new BufferedReader(new InputStreamReader(url.openStream()));
		Driver a = new Driver();
		ArrayList<String> testSiteLines = new ArrayList<>();
		ArrayList<URL> testSiteLinks = new ArrayList<>();
		a.processPage(proccesUrl, testSiteLines);
		for (int x = 0; x < testSiteLines.size(); x++) {
			a.htmlLinksPattern(testSiteLines.get(x), testSiteLinks);
		}
		boolean isFound = false;
		URL siteL;
		for (Iterator<URL> siteLinks = testSiteLinks.iterator(); siteLinks.hasNext();) {
			siteL = siteLinks.next();
			for (int b = 0; b < toVisit.size(); b++) {
				if (!isFound && siteL.equals(toVisit.get(b))) {
					isFound = true;
				}
			}
			if (!isFound) {
				for (int c = 0; c < visited.size(); c++) {
					if (!isFound && siteL.equals(visited.get(c))) {
						isFound = true;
					}
				}
				if (!isFound) {
					toVisit.add(siteL);
				}
			}
		}

	}
}
