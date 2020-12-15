public class hw09
{
    public static void main(String[] args) {
        
        //program start BELOW:
        //constant Value
        int A = 10;
        int B = 20;
        int C = 0;
        int D = 10;
        int E = 5;
        
        //programming logic
        if(A > B){
            if(A > 32){
                C = B;
            }else{
                C = E;
            }
            D = A;
        }else{
            C = D;
        }

        //test result value through output
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);
        System.out.println("D = " + D);
        System.out.println("E = " + E);

        //result shows only value C change.    
    }
}