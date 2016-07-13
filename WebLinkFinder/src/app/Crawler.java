package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Crawler implements VisitAction {
	public void crawl(ArrayList<String> toVisit, ArrayList<String> visited) {
		String line = "";
		// while( ){}
		for (int x = 0; x < toVisit.size(); x++) {
			String tmp = toVisit.get(0);
			visited.add(tmp);
			toVisit.remove(0);
			try {
				visit(tmp, toVisit, visited);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// public void visit(URL url)
	public void visit(String url, ArrayList<String> toVisit, ArrayList<String> visited) throws Exception {
		URL testSite = new URL(url);
		BufferedReader proccesUrl = new BufferedReader(new InputStreamReader(testSite.openStream()));
		Driver a = new Driver();
		ArrayList<String> testSiteLines = new ArrayList<>();
		ArrayList<String> testSiteLinks = new ArrayList<>();
		a.processPage(proccesUrl, testSiteLines);
		for (int x = 0; x < testSiteLines.size(); x++) {
			a.htmlLinksPattern(testSiteLines.get(x), testSiteLinks);
		}
		// Iterator<String> siteLinks = testSiteLinks.iterator();
		int x = 0;
		int matchfound = 0;
		boolean isFound = false;
		String siteL =  "";
		for (Iterator<String> siteLinks = testSiteLinks.iterator(); siteLinks.hasNext();) {
			siteL = siteLinks.next();
			for(int b = 0; b< toVisit.size();b++){
				if(!isFound && siteL.equals(toVisit.get(b))){
					isFound=true;
				}
			}
			if(!isFound){
				for(int c = 0; c<visited.size();c++){
					if(!isFound && siteL.equals(toVisit.get(c))){
						isFound=true;
					}
				}
				if(!isFound){
					toVisit.add(siteL);
				}
			}
//			for(){
//				
//			}
//			if (siteL.equals(toVisit.get(x)) || siteL.equals(toVisit.get(x))) {
//				if (matchfound == 0) {
//					matchfound++;
//				}
//				isFound = true;
//			}
		}
//		if(!isFound){
//			toVisit.add
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void visit(URL url) {
		// TODO Auto-generated method stub
		
	}

}
