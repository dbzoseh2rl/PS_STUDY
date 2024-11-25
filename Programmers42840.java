import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers42840 {
    public static void main(String[] args) {
        Solution.solution(new int[]{1, 2, 3, 4, 5});
    }
}

class Solution {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] correct = {0, 0, 0};
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (i >= one.length) {
                if (one[i % one.length] == answers[i]) {
                    correct[0]++;
                }
            } else {
                if (one[i] == answers[i]) {
                    correct[0]++;
                }
            }

            if (i >= two.length) {
                if (two[i % two.length] == answers[i]) {
                    correct[1]++;
                }
            } else {
                if (two[i] == answers[i]) {
                    correct[1]++;
                }
            }

            if (i >= three.length) {
                if (three[i % three.length] == answers[i]) {
                    correct[2]++;
                }
            } else {
                if (three[i] == answers[i]) {
                    correct[2]++;
                }
            }
        }

        int max = Arrays.stream(correct).max().getAsInt();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < correct.length; i++) {
            if (correct[i] == max) {
                ans.add(i + 1);
            }
        }
        answer = ans.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}