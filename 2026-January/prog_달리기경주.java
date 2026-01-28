import java.util.*;

class Solution {
    static HashMap<String,Integer>seq=new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        // 시뮬레이션 - callings가 호출됐을 때 players에서 이전과 현재를 전환
        // 선수 이름 - 순위 매칭, 순위 - 선수이름 매칭이 필요

        int fin=players.length;
        for(int i=0;i<fin;i++){
            seq.put(players[i],i);
        }

        int len=callings.length;
        for(int i=0;i<len;i++){
            String cur=callings[i];
            int curPlayer=seq.get(cur);
            String front=players[curPlayer-1];

            players[curPlayer-1]=cur;
            players[curPlayer]=front;

            seq.put(cur,curPlayer-1);
            seq.put(front,curPlayer);
        }

        return players;
    }
}