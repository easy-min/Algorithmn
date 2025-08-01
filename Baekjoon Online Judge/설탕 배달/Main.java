//  설탕 배달
/*
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만,
5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 */


import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
        int INF = 5001;
        int[] dp = new int[N+1];
        for (int i = 0; i<=N; i++){
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int i = 0; i<=N;i++){
            if (i>=3){
                dp[i] = Math.min(dp[i-3]+1, dp[i]);
            }
            if (i>=5){
                dp[i] = Math.min(dp[i-5]+1, dp[i]);
            }
        }
        int ans = dp[N];
        if (dp[N]==INF){
            ans = -1;
        }
        System.out.println(ans);
    }
}