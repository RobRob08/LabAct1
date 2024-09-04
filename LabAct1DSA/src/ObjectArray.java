import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectArray {
	String val;
	int size;
	String sorted;
	Object[] obj;

	public void populateArray(){
System.out.print("Enter Size of Array: ");
Scanner input = new Scanner(System.in);
size = Integer.parseInt(input.nextLine());
obj = new Object[size];
System.out.println("Enter "+ size + " Elements\n");

for(int i = 0; i< size; i++) {
	System.out.print("Enter Element "+ i +": ");
	String letter = input.nextLine();
	obj[i] = letter;
}
	}	

    public void displayReverseOrder() {
        System.out.print("\nReverse Order: ");
        for (int i = obj.length - 1; i >= 0; i--) {
            System.out.print(obj[i] + ", ");
        }
        System.out.println();
    }

    /**
     * Method to filter out numeric elements, sort them, and display them in ascending order.
     */
    public void displayAscendingOrder() {
    	for (int i = 0; i < obj.length - 1; i++) {
    	    for (int j = i + 1; j < obj.length; j++) {
    	        // Extract numeric parts using regex
    	        String num1Str = (String) obj[i];
    	        String num2Str = (String) obj[j];
    	        Matcher matcher1 = Pattern.compile("\\d+").matcher(num1Str);
    	        Matcher matcher2 = Pattern.compile("\\d+").matcher(num2Str);

    	        int num1 = 0, num2 = 0;
    	        if (matcher1.find()) {
    	            num1 = Integer.parseInt(matcher1.group());
    	        }
    	        if (matcher2.find()) {
    	            num2 = Integer.parseInt(matcher2.group());
    	        }

    	        // Compare numbers and swap elements if needed
    	        if (num1 > num2) {
    	            Object temp = obj[i];
    	            obj[i] = obj[j];
    	            obj[j] = temp;
    	        }
    	    }
    	}
    	System.out.print("\nAscending Order: ");
		 for (int i = 0; i < obj.length; i++) {		    
			 System.out.print(obj[i] + (i < obj.length - 1 ? ", " : ""));
		    }
		    System.out.println();
    }


    public static void main(String[] args) {

        ObjectArray objectArray = new ObjectArray();
        objectArray.populateArray();
        objectArray.displayReverseOrder();
        objectArray.displayAscendingOrder();
    }
}
