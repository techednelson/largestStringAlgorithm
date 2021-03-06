import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {
    
    /* Method findLargestStrCom converts into string and sorts the List following a declarative style, comparing if b>a or a>b, depending 
    the comparison b proceeds to a or viceversa, this sequence goes on until all the elements are ordered from left to rigth */
    public static String findLargestNumber(List<Integer> numList){
        List<String> newNumList = numList.stream() // Stream is initialized and result witll be store in newNumList    
        .map(e -> "" + e) //Each element is converted from Integer to String with built-in coercion 
        .sorted((a, b) -> (b + a).compareTo(a + b)) //Sorted method with a custom compator order the numbers in the desired way
        .collect(Collectors.toList());//Ordered numbers are collect into a final list, ending the Stream

        //The List is converted into a single String representing the largest possible combined number
        return String.join("", newNumList);
    }

    public static void main(String[] args) {
        //Define and Initialize a scanner for user data input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for the list: ");
        int num = scanner.nextInt();

        //Store the data input into an ArrayList of Integers
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
            System.out.print("Number " + (i+1) + " : ");
            //Error handling
            try {
                int testNum = scanner.nextInt();
                if(testNum >= 0){
                    list.add(testNum);
                } else {
                    System.out.println("Input is a negative integer, type again!");
                    i--;
                }
            } catch (Exception e) {
                System.out.println("Input isn't a non negative integer, try again!");
            }
        }
        
        //Call the method which returns the largest possible combined number
        String largestNumber = findLargestNumber(list);
        System.out.println(largestNumber);

        //Once the program is done, scanner is closed to avoid resources leak
        scanner.close();
    }
}

