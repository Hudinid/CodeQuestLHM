import java.io.*;
import java.util.*;

public class BrickHouse {
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();
        int n = kat.nextInt();

        for(int i = 0; i < n; i ++) {
            int numSmall = kat.nextInt();
            int numBig = kat.nextInt();
            int wallLength = kat.nextInt();
            
            while(wallLength - 5 >= 0 && numBig > 0) {
                wallLength -= 5;
                numBig --;
            }

            kat.println(numSmall >= wallLength);
        }
        kat.close();
    }

}

class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;
	// standard input
	public Kattio() { this(System.in,System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
		super(problemName+".out");
		r = new BufferedReader(new FileReader(problemName+".in"));
	}
	// returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) {}
		return null;
	}
	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
}

