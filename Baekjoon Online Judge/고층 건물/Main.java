import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            int score = 0;
            double leftSlope = Double.MAX_VALUE;
            double rightSlope = -Double.MAX_VALUE;

            // 왼쪽 방향 탐색
            for(int j = i - 1; j >= 0; j--){
                double slope = (double)(arr[i] - arr[j]) / (i - j);
                if(slope < leftSlope){
                    leftSlope = slope;
                    score++;
                }
            }

            // 오른쪽 방향 탐색
            for(int j = i + 1; j < N; j++){
                double slope = (double)(arr[j] - arr[i]) / (j - i);
                if(slope > rightSlope){
                    rightSlope = slope;
                    score++;
                }
            }

            ans = Math.max(ans, score);
        }

        System.out.println(ans);
    }
}
