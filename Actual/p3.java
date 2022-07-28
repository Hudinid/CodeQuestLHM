import java.util.*;
import java.io.*;
public class p3 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);

            String[] dataList = new String[x];
            ArrayList<String> shipList = new ArrayList<>(); 

            for(int j = 0; j < x; j ++) {
                dataList[j] = br.readLine();
            }

            for(int j = 0; j < y; j ++) {
                shipList.add(br.readLine());
            }

            ArrayList<String> ret = new ArrayList<String>();

            for(int j = 0; j < dataList.length; j ++) {
                if(!shipList.contains(dataList[j])) {
                    ret.add(dataList[j]);
                }
            }

            Collections.sort(ret);
            
            for(String print : ret) {
                pw.println(print);
            }

        }

        pw.close();
    }
}

