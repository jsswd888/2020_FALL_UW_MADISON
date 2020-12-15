public class CountWords {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java CountWords [-letters] word(s)");
            return;
        }

        int wordCount = args.length;
        int letterCount = 0;
        int doubleLetterCount = 0;
        boolean letters = false;
        
        if (args[0].equals("-letters")) {
            letters = true;
        }
        
        char previousChar = '\0';
        for (String arg : args) {
            System.out.print(arg + " ");
            if (letters = true) {
                for (int i = 0; i < arg.length(); ++i) {
                    char ch = arg.charAt(i);
                    if (Character.isLetter(ch)) {
                        letterCount++;
                        if (previousChar == ch) {
                            doubleLetterCount++;
                        }
                    }
                    previousChar = ch;
                }
            }
        }
        
        System.out.println();
        System.out.println("wordCount=" + wordCount);
        if (letters) {
            System.out.println("letterCount=" + letterCount
                    + " doubleLetterCount=" + doubleLetterCount);
        }
    }
}