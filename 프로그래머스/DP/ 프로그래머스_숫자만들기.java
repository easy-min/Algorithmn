class Solution {
    public int solution(int x, int y, int n) {
        // x -> y가 아닌 y -> x로 역방향으로 최소값 찾기 (/2, /3일 때 배수일 때만 계산해서 경우의 수 줄음)
        int[] dp = new int[y+1]; // dp[y] = 숫자 y로 만들 수 있는 가장 작은 경우의 수
        for (int i = 0; i<y+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[y] = 0;
        for (int i = y; i>=x; i--){
            if (dp[i]==Integer.MAX_VALUE){ continue; }
            // 역방향으로 계산하기
            if (i -n >= x){
                dp[i-n] = Math.min(dp[i-n], dp[i]+1);
            }
            if (i%2==0 && i/2>=x){
                dp[i/2] = Math.min(dp[i/2], dp[i]+1);
            }
            if (i%3==0 && i/3>=x){
                dp[i/3] = Math.min(dp[i/3], dp[i]+1);
            }
        }
        return dp[x]==Integer.MAX_VALUE?-1:dp[x];
    }
}