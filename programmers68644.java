import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static class Solution {
        public int[] solution(int[] numbers) {

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < numbers.length; i++) {
                for(int j = i+1; j<numbers.length; j++)
                    if (!list.contains(numbers[i] + numbers[j]))
                        list.add(numbers[i] + numbers[j]);
            }

            return list.stream().sorted().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = solution.solution(numbers);
        System.out.println("결과: " + Arrays.toString(result));
    }
    }
}