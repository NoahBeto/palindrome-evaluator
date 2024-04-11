import java.util.*;
/**
* The purpose of this program is to check whether input strings are palindromes. The user input will be removed of any spaces and punctuation prior to being stored in a queue and stack.
* The queue will take the user input in the order it was typed.
* The stack will take the user input and reverse it.
* The queue and the stack will be set to equal each other in order to see if the user entered a palindrome.
*/
public class palindromeChecker {
	String inputString;	
	Scanner in = new Scanner(System.in);
	private static Stack stack;
	private static Queue queue;
	public palindromeChecker() { //constructor
	    stack = new Stack(); //initializing stack
	    queue = new LinkedList(); //initializing queue
	  } //end of constructor
	public void promptingUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter anything in the program.\nPress q if you would like to end the program.");
		while(true) {
			inputString = scan.nextLine();
        	if(inputString.equals("q")) {
        		break; //This is in place if the user wants to end the program
        	}
        	dataThatIsIgnored(); //method call of dataThatIsIgnored()
        	queueStoring(); ////method call of queueStoring()
        	reverseStackAndPalindromeChecker(); //method call of reverseStackAndPalindromeChecker()
		String reverseString = recursion(inputString);
		System.out.print(inputString + "-" + reverseString);
		System.out.println("\nEnter another String in the program or press q to end the program.");
        }
	}
    // Recursive method to reverse a string
    public static String recursion(String inputString) {
    	if (inputString.isEmpty()) { //Once there is nothing in the variable, inputString, the recursion method will be able to take the characters and have them be returned in reverse order.
			return inputString;
		}
    	return recursion(inputString.substring(1)) + inputString.charAt(0); //The substring ignores the character at substring 0.  It will keep putting in the String in the recursion method without the character at 0 each time the method is called until there are no characters.
	}
	public void dataThatIsIgnored() {
		inputString = inputString.toLowerCase(); //turns all upper case letters in the user input into lower case letters
    	inputString = inputString.replaceAll("\\s+", ""); //removes all spaces from the user input
    	inputString = inputString.replaceAll("\\p{Punct}", ""); //removes all punctuation from the user input
	}
	public void queueStoring() {
		queue.add(inputString); //adds the user input into the queue
	}
	public void reverseStackAndPalindromeChecker() {
		String reverseString = "";
		for (int i = 0; i < inputString.length(); i++) {
        	stack.push(inputString.charAt(i)); //pushes the user input into the stack
        }
		while (!stack.isEmpty()) {
		      reverseString = reverseString + stack.pop(); //puts the contents of the stack in this variable in reverse
		}
		stack.push(reverseString); //puts the user input in reverse back in the stack
		System.out.println(queue);
		System.out.println(stack);
		if (queue.equals(stack)) { //compares the user input in the stack with the reverse input in the stack
			System.out.println("You entered a palindrome.");
		}
		else {
			System.out.println("You did not enter a palindrome.");
		}
		stack.clear(); //resets the stack
		queue.clear(); //resets the queue
	}
}
