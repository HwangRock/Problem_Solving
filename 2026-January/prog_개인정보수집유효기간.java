import java.util.*;

class Solution {

    static int makeDay(String date){
        String ymd[]=date.split("\\.");

        int y=Integer.parseInt(ymd[0]);
        int m=Integer.parseInt(ymd[1]);
        int d=Integer.parseInt(ymd[2]);

        return 12*28*y+28*m+d;
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer>lis=new ArrayList<>();
        // 년->12, 월->28로 해서 전부 일로 바꾼다.
        // 현재날짜(숫자)와 비교해서 더 작다면 answer에 넣는다.

        int cur=makeDay(today);

        HashMap<Character,Integer>map=new HashMap<>();
        for(String s:terms){
            String ss[]=s.split(" ");
            char c=ss[0].charAt(0);
            int val=Integer.parseInt(ss[1]);
            map.put(c,val);
        }

        int seq=1;
        for(String s: privacies){
            String parse[]=s.split(" ");
            int day=makeDay(parse[0]);
            char c=parse[1].charAt(0);
            int plus=map.get(c)*28;

            day=day+plus-1;

            if(cur>day){
                lis.add(seq);
            }
            seq++;
        }

        int size=lis.size();
        int answer[]=lis.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}