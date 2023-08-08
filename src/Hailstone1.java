import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * A program that takes in a user's input and generates Hailstone series,
 * starting with that given number. If the number is even, we divide by 2, and
 * if the number is odd, we multiply by 3 and add 1. Repeat, until reaching 1.
 *
 * @author Omar Takruri
 *
 */
public final class Hailstone1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {

        int max = 0;

        while (n != 1) {
            out.print(n + ", ");
            if (n % 2 == 0) {
                n = n / 2;

            } else {
                n = 3 * n + 1;
            }

            if (n > max) {
                max = n;
            }

        }
        out.println(n);
        out.println("Max value in the series is: " + max);

    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        int number = -1;
        while (number <= 0) {
            out.print("Enter a number to start with: ");
            String input = in.nextLine();
            if (FormatChecker.canParseInt(input)) {
                number = Integer.parseInt(input);
                if (number <= 0) {
                    out.print("Please enter a positive number: ");
                }
            } else {
                out.print("Invalid input. Please enter a positive number: ");
            }
        }
        return number;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        char answer = 'y';
        while (answer == 'y') {

            int number = getPositiveInteger(in, out);

            generateSeries(number, out);

            out.print("Do you wish to calculate another series?(y/n) ");
            answer = in.nextLine().charAt(0);
        }
        in.close();
        out.close();
    }

}
