import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Programmers68644 {
    public static void main(String[] args) {
        Solution.solution(new int[]{5, 0, 2, 7});
    }
}

class Solution {
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}