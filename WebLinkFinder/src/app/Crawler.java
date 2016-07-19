package app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import LinkFinderApp.LinkFinder;

public class Crawler implements VisitAction {
	private static int MAX_COUNT;
	VisitAction action;
	ArrayList<URL> toVisit, hasVisited;

	public Crawler(ArrayList<URL> toVisit, ArrayList<URL> hasVisited, int MAX_COUNT, VisitAction action,
			String hostURL) {
		this.action = action;
		this.MAX_COUNT = MAX_COUNT;
		this.toVisit = toVisit;
		this.hasVisited = hasVisited;
		URL url = null;
		try {
			url = new URL(hostURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toVisit.add(url);
	}

	public void crawl() {
		try {
			int counter = 0;
			URL host = new URL(toVisit.get(0).toString());
			String hostString = "";
			for (int x = 0; x < host.toString().length() - 1; x++) {
				hostString += host.toString().charAt(x);
			}
			while (!toVisit.isEmpty() && counter < MAX_COUNT) {
				// if(counter<MAX_COUNT){
				URL tmp = toVisit.get(0);
				action.Visit(tmp);
				hasVisited.add(tmp);
				toVisit.remove(0);
				counter++;
				LinkFinder linkFinder = new LinkFinder();
				linkFinder.processPage(tmp.openStream());
				boolean isFound = false;
				for (Iterator<String> i = linkFinder.getLinks(); i.hasNext();) {
					String link = i.next();
					for (int b = 0; b < toVisit.size(); b++) {
						if (!isFound && toVisit.get(b).toString().contains(link)) {
							isFound = true;
						}
					}
					if (!isFound) {
						for (int c = 0; c < hasVisited.size(); c++) {
							if (!isFound && hasVisited.get(c).toString().contains(link)) {
								isFound = true;
							}
						}
						if (!link.startsWith("http") && !isFound) {
							String linkTmp = link;
							link = hostString + linkTmp;
							URL getLink = new URL(link);
							toVisit.add(getLink);
						}
					}

				}
				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println("/////////////");
		 for (int i = 0; i < toVisit.size(); i++) {
		 System.out.println((i + 1) + ". " + toVisit.get(i));
		 }
		System.out.println("/////////////");
		for (int i = 0; i < hasVisited.size(); i++) {
			System.out.println((i + 1) + ". " + hasVisited.get(i));
		}
	}

	@Override
	public void Visit(URL url) {
		System.out.println(url);

	}

}
