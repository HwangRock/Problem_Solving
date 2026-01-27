import java.util.*;

class Solution {

    static HashMap<Character,Integer>map=new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        StringBuilder sb=new StringBuilder();

        // n개를 순회하면서 선택이 4미만인지, 초과인지 구분
        // 순회를 마치면 4개의 유형 중에서 문자 하나씩 추가

        int n=survey.length;
        for(int i=0;i<n;i++){
            int pnt=choices[i];
            if(pnt<4){
                map.merge(survey[i].charAt(0),4-pnt,Integer::sum);
            }
            else if(pnt>4){
                map.merge(survey[i].charAt(1),pnt-4,Integer::sum);
            }
        }

        if(map.getOrDefault('R',0)>=map.getOrDefault('T',0)){
            sb.append('R');
        }
        else{
            sb.append('T');
        }

        if(map.getOrDefault('C',0)>=map.getOrDefault('F',0)){
            sb.append('C');
        }
        else{
            sb.append('F');
        }

        if(map.getOrDefault('J',0)>=map.getOrDefault('M',0)){
            sb.append('J');
        }
        else{
            sb.append('M');
        }

        if(map.getOrDefault('A',0)>=map.getOrDefault('N',0)){
            sb.append('A');
        }
        else{
            sb.append('N');
        }

        return sb.toString();
    }
}