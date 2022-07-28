import java.util.*;
import java.io.*;
public class p4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n ; i++) {
            String line = br.readLine();
            
            String ret = "";
            for(int j = 0; j < line.length(); j ++) {
                if((int) line.charAt(j) >= 65 && (int) line.charAt(j) <= 90 || (int) line.charAt(j) >= 97 && (int) line.charAt(j) <= 122 || 
                (int) line.charAt(j) >= 48 && (int) line.charAt(j) <= 57 || (int) line.charAt(j) == 32) {
                    ret += line.charAt(j);
            }
        }
        pw.println(ret);
        }
        pw.close();
    }
}