import java.util.ArrayList;
import java.util.Scanner;

/*boolean done = false;
    do {
        int count = input.nextInt();
        if ( count < 0) {
            done = true;
        } else {
            dailyCounts.add( count);
        }
    } while ( !done);*/
public class CountEachHashtag {

    public static void main(String[] args) {
        //parallel/multiple arrays
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<String> hashtags = new ArrayList<>();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a list of hashtags ('end' to end):");
        
        boolean done = false;
        do {
            String hashtag = input.next();
            if ( hashtag.equals("end") ) {
                done = true;
            } else {
                hashtag = hashtag.startsWith("#") ? hashtag : "#" + hashtag;
                
                //if the hashtag is in the hashtags list then add 1 to corresponding count
                //if not in the list then add
                
                
                
            }
        } while ( !done);
        
        //determine total number of unique hashtags
        //determine minimum count
        //determine maximum count
        //determine average count
        
        
        int numPerStar = 1;
        //draw bar chart
        
        System.out.println("A * represents " + numPerStar + " use of tag.");
    }
}