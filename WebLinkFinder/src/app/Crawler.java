package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Crawler implements VisitAction{
	public void crawl(ArrayList<String> toVisit, ArrayList<String> visited){
		String line = "";
//		while( ){}
		for(int x=0; x<toVisit.size();x++ ){
			String tmp = toVisit.get(x);
			visited.add(tmp);
		}
	}
//	public void visit(URL url)
	public void visit(String url) throws Exception{
		URL testSite = new URL(url);
		BufferedReader proccesUrl = new BufferedReader(new InputStreamReader(testSite.openStream()));
		Driver a =  new Driver();
		ArrayList<String> testSiteLines = new ArrayList<>();
		ArrayList<String> testSiteLinks = new ArrayList<>();
		a.processPage(proccesUrl, testSiteLines);
		for (int x = 0; x < testSiteLines.size(); x++) {
			a.htmlLinksPattern(testSiteLines.get(x), testSiteLinks);
		}
//		Iterator<String> siteLinks = testSiteLinks.iterator();
		for(Iterator<String> siteLinks = testSiteLinks.iterator();siteLinks.hasNext(); ){
			String siteL = siteLinks.next();
//			for(){
//				
//			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
