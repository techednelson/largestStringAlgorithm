# Largest String Algorithm Challenge

## Objective

Write a function in Java accepting a list of non negative integers, and returning their largest possible combined number as a string. If possible also provide Unit Tests.

For example: 

+ Given [50, 2, 1, 9] it returns "95021" (9 + 50 + 2 + 1) 
+ Given [5, 50, 56] it returns "56550" (56 + 5 + 50)
+ Given 420, 42, 423] it returns "42423420" (42 + 423 + 420)


## Useful Links and Documentation

+ [Java Documentation API Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
+ [Getting Started Junit](https://github.com/junit-team/junit4/wiki/Getting-started)
+ [Read-Search-Ask](https://medium.freecodecamp.org/read-search-dont-be-afraid-to-ask-743a23c411b4)


## Problem:

Write a function in Java accepting a list of non negative integers, and returning their largest possible combined number as a string. If possible also provide Unit Tests.

## Explanation

The logic to solve this problem is straightforward:

1. To convert each number from the list into a string.
2. To compare the converted numbers in pairs and inverting the numbers order in the list if needed, depending the comparison result. E.g [a,b] if b>a -> [b,a] else [a,b]. This comparison will go from left to right until the list is ordered as desired.
3. Convert and return that list into one single string representing the largest possible combined number.

## My Code:
```
public class LargestNumber {
    
    public static String findLargestNumber(List<Integer> numList){
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
        
        String largestNumber = findLargestNumber(list);
        System.out.println(largestNumber);

        scanner.close();
    }
}
```
## My Code Explanation:

I decided to apply the Stream API available since Java 8, Streams allow the application of higher-order-functions like filter, map, reduce and sorted. The methods are the core of Functional Programming a very popoular pattern in lanaguages like JavaScript that use abstraction to program in a declarative way, avoiding to concern about the how to code and simple declaring what whe want the language to do for us.  

Basically with help of a scanner, user can input numbers, they are converted into a integer list. Once the findLargestNumber method received that list, a stream is initialized, so map converts each element into a string, then,  they are ordered in the desired way with the help of Sorted method and a custom comparator following the logic in the explanaiton section.

Finally the ordered or sorted strings are collected into a list to be converted in a final String representing the largest possible combined number.

## License

[Licensed under a Creative Commons Attribution-ShareAlike 4.0 International License.](https://creativecommons.org/licenses/by-sa/4.0/)
