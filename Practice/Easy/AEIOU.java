import java.io.*;
import java.util.*;
public class AEIOU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i ++) {
            String line = br.readLine();
            int ret = 0;
            for(int j = 0; j < line.length(); j ++) {
                if(line.charAt(j) == 'a' || line.charAt(j) == 'e' || line.charAt(j) == 'i' || line.charAt(j) == 'o' || line.charAt(j) == 'u') {
                    ret++;
                }
            }
            pw.println(ret);
        }   
        pw.close();
        br.close();
    }
}
