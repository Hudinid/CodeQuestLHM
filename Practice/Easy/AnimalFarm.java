import java.io.*;
import java.util.*;
public class AnimalFarm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int ret = Integer.parseInt(tokens[0])*2 + Integer.parseInt(tokens[1]) * 4 + Integer.parseInt(tokens[2]) * 4;
            pw.println(ret);
        }
        pw.close();
    }    
}
