package app;

import java.net.URL;
import java.util.ArrayList;

public interface OldVisitAction {
	public void visit(URL url, ArrayList<URL> toVisit, ArrayList<URL> visited) throws Exception;
		
	

}
