import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dice = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int[] rewardCount = new int[4];
        int score = 0;
        int time = 0;
        int value = 1;
        int cnt = 4;

        for (int i = 0; i < N; i++) {
            if (time > 240) {
                checkReward(score, rewardCount);
                score = 0;
                time = 0;
                value = 1;
                cnt = 4;
            }

            if(dice[i] == 1) {
                checkReward(score, rewardCount);
                score = 0;
                time = 0;
                value = 1;
                cnt = 4;
            } 
            else if(dice[i] == 2) {
                if(value > 1) {
                    value /= 2;
                }
                else if(value == 1) {
                    cnt += 2;
                }
            }
            else if(dice[i] == 4) {
                time += 56;
            }
            else if(dice[i] == 5) {
                if(cnt > 1) {
                    cnt -= 1;
                }
            }
            else if(dice[i] == 6) {
                if(value < 32) {
                    value *= 2;
                }
            }

            if(dice[i] != 1) {
                score += value;
                time += cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int count : rewardCount) {
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void checkReward(int score, int[] rewardCount) {
        if (score >= 35 && score < 65) {
            rewardCount[0]++;
        } else if (score >= 65 && score < 95) {
            rewardCount[1]++;
        } else if (score >= 95 && score < 125) {
            rewardCount[2]++;
        } else if (score >= 125) {
            rewardCount[3]++;
        }
    }
}