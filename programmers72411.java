import java.util.*;
class Solution {

    List<String> answerList = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        // 1. 각 Order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 각 order를 기준으로 courseLength 만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders)
                combination("", order, courseLength);
                //처음에는 아직까지 조합된 게 없
            // 3. 가장 많은 조합 answer에 저장
            if (!hashMap.isEmpty()) {
                //굳이 list 쓴 이유 : max...
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                if (max > 1)
                    for (String key : hashMap.keySet())
                        if (hashMap.get(key) == max)
                            answerList.add(key);
                hashMap.clear();
            }
        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        return answer;
    }
    //order: 현재까지 조합된 코스 , others 아직까지 사용되지 않은 알파벳 count: 몇 개를 더 조합해야하는지
    public void combination(String order, String others, int count) {
        // 탈출 조건 : count == 0
        if (count == 0) {
            //order이 존재하지 않는다면 0 반환
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }


        for (int i = 0; i < others.length(); i++)
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        //조합하지 않은 뒤 숫자만 하면 되니깐 other로 불러옴 others.substring으로 뒤쪽꺼만 코스는 반대로 -1
    }
}

public class programmers72411 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(sol.solution(orders, course)));
    }
}

