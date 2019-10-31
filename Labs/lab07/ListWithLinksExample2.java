public class ListWithLinksExample2 {

    public static void main (String[] argv) {
		ListWithLinks2 favoriteShows = new ListWithLinks2();
		favoriteShows.add ("Yes minister");
		favoriteShows.add ("Seinfeld");
		favoriteShows.add ("Cheers");
		favoriteShows.add ("Frasier");
		favoriteShows.add ("Simpsons");

        favoriteShows.printList ();
    }

}