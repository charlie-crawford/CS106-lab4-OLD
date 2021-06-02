package stacksqueues;

import java.io.StringReader;
import java.util.Scanner;

/**
 *  Starter code for computing arithmetic expressions in post-fix notation.
 *
 *  @author Nick Howe, Sara Mathieson, + <your name>
 *  @version TODO
 */
public class Postfix {

    /** Pattern that matches on words */
    public static final String WORD = "[a-zA-Z]*\\b";

    /** Pattern that matches on arithmetic operators */
    public static final String OPERATOR = "[^\\w]";

    /** Main method to evaluate expression */
    public static void main(String[] args) {

    	// tell the user how to run the program
    	if (args.length==0) {
    		System.err.println("Usage: java Postfix <expr>");

    	} else {
    		System.out.println("input: " + args[0]);
    		Scanner input = new Scanner(new StringReader(args[0]));

			// Below is a complicated regular expression that will split the
			// input string at various boundaries.
			input.useDelimiter("(\\s+"                  // whitespace
					+"|(?<=[a-zA-Z])(?=[^a-zA-Z])"      // word->non-word
					+"|(?<=[^a-zA-Z])(?=[a-zA-Z])"      // non-word->word
					+"|(?<=[^0-9\\056])(?=[0-9\\056])"  // non-number->number
					+"|(?<=[0-9\\056])(?=[^0-9\\056])"  // number->non-number
					+"|(?<=[^\\w])(?=[^\\w]))");        // symbol->symbol

			double finalResult = postfix(input);
			System.out.println("result: " + finalResult);
    	}
    }

    public static double postfix(Scanner input) {
		// loop to run through all the tokens of the input
		// Note: this is just to show how to read the input, you should
		// modify this code to compute the value of the expression (TODO)
		while (input.hasNext()) {
			if (input.hasNextDouble()) {
				System.out.println("Number: " + input.nextDouble());
			} else if (input.hasNext(WORD)) {
				System.out.println("Word: " + input.next(WORD));
			} else if (input.hasNext(OPERATOR)) {
				System.out.println("Operator: " + input.next(OPERATOR));
			} else {
				System.out.println("Unknown: " + input.next());
			}
		}
		return 0.0; // TODO change
	}
}
