import java.io.*;
import java.util.*;

public class Main {

    static int num[];

    static long solve(int n) {
        long ans = 0;

        int l = 0;
        int r = 0;
        HashSet<Integer> set = new HashSet<>();

        while (r < n) {
            while (l < r && set.contains(num[r])) {
                set.remove(num[l]);
                l++;
            }
            set.add(num[r]);
            ans = ans + (r - l) + 1;
            r++;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        String s[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        bw.write(String.valueOf(solve(n)));
        bw.flush();
    }
}
