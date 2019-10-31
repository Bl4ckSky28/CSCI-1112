import java.util.*;

public class SetExample2 {

    public static void main (String[] argv) {
		LinkedList<String> favoriteShows1 = new LinkedList<String>();
		favoriteShows1.add ("Yes minister");
		favoriteShows1.add ("Seinfeld");
		favoriteShows1.add ("Cheers");
		favoriteShows1.add ("Frasier");
		favoriteShows1.add ("Simpsons");

		LinkedList<String> favoriteShows2 = new LinkedList<String>();
		favoriteShows2.add ("Mad about you");
		favoriteShows2.add ("Seinfeld");
		favoriteShows2.add ("Frasier");
		favoriteShows2.add ("Cosby show");

		System.out.println(computeUnion(favoriteShows1, favoriteShows2));
	}
	public static LinkedList<String> computeUnion (LinkedList<String> favoriteShows1, LinkedList<String> favoriteShows2) {
		LinkedList<String> union = new LinkedList<String>();
		
		for(int i=0; i < favoriteShows1.size(); i++) {
			union.add(favoriteShows1.get(i));
		}
		for(int i=0; i < favoriteShows2.size(); i++) {
			if(!union.contains(favoriteShows2.get(i)))
				union.add(favoriteShows2.get(i));
		}
		return union;
	}
 

    

}