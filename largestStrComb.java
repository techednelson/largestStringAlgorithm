import java.util.*;
import java.util.stream.Collectors;

public class largestStrComb {
    public static String findLargestStrComb(List<String> numList){

        List newNumList = numList.stream()
        .sorted((a, b) -> (a + b).compareTo(b + a))
        .collect(Collectors.toList());

        return String.join("", newNumList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number for the list: ");
        int num = Integer.parseInt(scanner.nextLine());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			System.out.print("Number " + (i+1) + " : ");
		        list.add(scanner.nextLine());
		}
        String largestStrComb = findLargestStrComb(list);
        System.out.println(largestStrComb);
    }
}

