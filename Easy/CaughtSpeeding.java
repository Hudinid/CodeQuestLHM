import java.util.*;
import java.io.*;
public class CaughtSpeeding {
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();
        int n = kat.nextInt();

        for(int i = 0; i < n; i ++) {
            int speed = kat.nextInt();
            String check = kat.next();
            
            if(check.equals("true")) {
                speed -= 5;
            }

            if(speed <= 60) {
                kat.println("no ticket");
            }
            else if(speed >= 61 && speed <= 80) {
                kat.println("small ticket");
            }
            else if(speed >= 81) {
                kat.println("big ticket");
            }
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

