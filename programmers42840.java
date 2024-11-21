import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];


        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supoza1[i % supoza1.length])
                score[0]++;
            if (answers[i] == supoza2[i % supoza2.length])
                score[1]++;
            if (answers[i] == supoza3[i % supoza3.length])
                score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 입력
        int[] answers = {1, 3, 2, 4, 2};

        // 메서드 실행
        int[] result = solution.solution(answers);

        // 결과 출력
        System.out.println("결과: " + Arrays.toString(result));
    }
}
