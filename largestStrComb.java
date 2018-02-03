import java.util.*;
import java.util.stream.Collectors;

public class largestStrComb {
    public static String findLargestStrComb(List<Integer> numList){

        List<String> newNumList = numList.stream()
        .map(e -> "" + e)
        .sorted((a, b) -> (b + a).compareTo(a + b))
        .collect(Collectors.toList());

        return String.join("", newNumList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number for the list: ");
        int num = scanner.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			System.out.print("Number " + (i+1) + " : ");
		        list.add(scanner.nextInt());
		}
        String largestStrComb = findLargestStrComb(list);
        System.out.println(largestStrComb);

        scanner.close();
    }
}

