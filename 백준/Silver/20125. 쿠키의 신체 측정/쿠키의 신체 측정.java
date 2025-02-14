import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] cookie = new char[n+1][n+1];
		
		int heartX = 0,heartY = 0;
		boolean head = false;
		for(int i=1;i<=n;i++) {
			String input = br.readLine();
			for(int j = 1; j <= n; j++) {
				char now = input.charAt(j-1);
				
				if(now == '*' && !head) {
					heartX = i+1;
					heartY = j;
					head=true;
				}
				cookie[i][j] = now;
			}
		}
		
		int leftHand = 0;
		for(int j = heartY - 1; j > 0; j--)
			if(cookie[heartX][j] == '*')
            leftHand++;
		
		int rightHand=0;
		for(int j = heartY + 1; j <= n; j++)
			if(cookie[heartX][j] == '*')
				rightHand++;
		
		int middle = 0;
		int middleX = 0;
		for(int i = heartX + 1; i <= n; i++) {
			if(cookie[i][heartY]=='*') {
				middle++;
				middleX = i; 
			}
		}
		
		int leftLeg=0;
		for(int i = middleX + 1; i<=n; i++)
			if(cookie[i][heartY-1] == '*')
            leftLeg++;
		
		int rightLeg=0;
		for(int i = middleX+1; i <= n; i++)
			if(cookie[i][heartY+1] == '*')
				rightLeg++;
				
		StringBuilder sb = new StringBuilder();
        sb.append(heartX).append(" ").append(heartY).append("\n")
        .append(leftHand).append(" ").append(rightHand).append(" ")
        .append(middle).append(" ").append(leftLeg).append(" ").append(rightLeg);
		System.out.println(sb);
	}
}