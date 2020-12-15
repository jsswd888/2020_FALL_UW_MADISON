import java.util.ArrayList;
import java.util.Scanner;

public class Counter {

    public static void main(String[] args) {
        ArrayList<Integer> dailyCounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a hashtag: ");
        String hashtag = input.nextLine().trim();
        hashtag = hashtag.startsWith("#") ? hashtag : "#" + hashtag;
        
        System.out.println("Enter count of " + hashtag + " tweets per day (negative to end).");
        

        ArrayList<Integer> days = new ArrayList<>(7);

        for (int i = 0; i < 7; i++) {
            days.add(input.nextInt());
        }
        
        //determine total number of days of data
        //determine minimum
        int minimum = days.get(0);
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += days.get(i);
            if (days.get(i) < minimum) {
                minimum = days.get(i);
            }
        }

        //determine maximum
        int maximum = days.get(0);
       for (int i = 0; i < 6; i++) {
           if (days.get(i) > maximum) {
               maximum = days.get(i);
           }
        }

        //determine average
        double average = (double) sum / 6;

        //draw a bar chart where maximum / 50 is represented by one *.
        int onestar = maximum / 50;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < days.get(i) / onestar; j++) {
                System.out.print("*");
            }
            System.out.println("(" + days.get(i) + ")");
        }
        System.out.println("A * represents " + onestar + " tweets.");
    }
}