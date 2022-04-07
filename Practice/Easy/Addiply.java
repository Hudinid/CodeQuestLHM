import java.io.*;
import java.util.*;
class Addiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            String line = br.readLine(); 
            String[] tokens = line.split(" ");
            pw.println(Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]) + " " + Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[1]));
        }
        pw.close();
        br.close();
    }
}