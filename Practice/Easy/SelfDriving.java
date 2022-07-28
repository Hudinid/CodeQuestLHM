import java.io.*;
import java.util.*;
public class SelfDriving {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i ++) {
            String line = br.readLine();
            String[] tokens = line.split(":");
            double numb1 = Double.parseDouble(tokens[0]);
            double numb2 = Double.parseDouble(tokens[1]);

            if(numb1 >= numb2) pw.println("SWERVE");
            else if (numb1 * 5 >= numb2) pw.println("BRAKE");
            else pw.println("SAFE");
        }
        pw.close();
    }
}
