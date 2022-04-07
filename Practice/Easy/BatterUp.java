import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class BatterUp {
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();
        int n = kat.nextInt();

		for(int i = 0; i < n; i ++) {
			String line = kat.next();
			String[] tokens = line.split(":");
			
			double sum = 0;
			int subtract = 0;
			String[] bats = tokens[1].split(",");
			
			for(int j = 0; j < bats.length; j ++) {
				if(bats[j].equals("K")) sum += 0;
				if(bats[j].equals("2B")) sum += 2;
				if(bats[j].equals("1B")) sum ++;
				if(bats[j].equals("3B")) sum += 3;
				if(bats[j].equals("HR")) sum += 4;
				if(bats[j].equals("BB")) subtract ++;
			}
			if(sum == 0) {
				String reFormat = String.format("%.3f", sum);
				kat.println(tokens[0] + "=" + reFormat);
				continue;
			}
			sum /= (bats.length-subtract);
			
			String format = String.format("%.3f", sum);
			kat.println(tokens[0] + "=" + format);
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

