class Solution {
    public int solution(String s) {
        int answer = 0;
        // 시뮬레이션 - 같은 문자 횟수, 다른 문자 횟수를 각각 저장
        // 2개의 숫자가 같으면 answer 증가, 횟수 초기화

        int sa=0;
        int dif=0;
        char c=' ';
        int fin=s.length();
        for(int i=0;i<fin;i++){
            if(sa==0 && dif==0){
                c=s.charAt(i);
            }

            if(s.charAt(i)==c){
                sa++;
            }
            else{
                dif++;
            }

            if(sa==dif){
                answer++;
                sa=0;
                dif=0;
            }
        }
        if(sa != dif){
            answer++;
        }

        return answer;
    }
}