import java.util.*;

public class Programmers72411 {
    public static void main(String[] args) {
        Solution.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
    }

}

class Solution {
    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                if (orders[i].length() < course[j]) {
                    break;
                }
                String[] target = orders[i].split("");
                Arrays.sort(target);
                int length = course[j];

                dfs(target, length, 0, new ArrayList<>(), map);
            }
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            List<Map.Entry<String, Integer>> temp = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() == course[i] && entry.getValue() >= 2) {
                    temp.add(entry);
                }
            }

            int max = temp.stream()
                    .mapToInt(entry -> entry.getValue())
                    .max()
                    .orElse(0);

            for (Map.Entry<String, Integer> entry : temp) {
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    public static void dfs(String[] target, int r, int start, List<String> current, Map<String, Integer> result) {
        if (current.size() == r) {
            result.put(String.join("", current), result.getOrDefault(String.join("", current), 0) + 1);
            return;
        }

        for (int i = start; i < target.length; i++) {
            current.add(target[i]);
            dfs(target, r, i + 1, current, result);
            current.remove(current.size() - 1);
        }

    }
}