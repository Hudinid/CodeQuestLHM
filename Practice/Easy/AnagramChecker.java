import java.io.*;
import java.util.*;
public class AnagramChecker {
   public static void main(String[] args) throws IOException {
      Kattio kat = new Kattio();
      int n = kat.nextInt();

	  for(int i = 0; i < n; i ++) {
		  String line = kat.next();
		  String[] tokens = line.split("|");
		  if(tokens[1].equals(tokens[0])) kat.println(line + " = NOT AN ANAGRAM");
		  Arrays.sort(tokens[0].toCharArray());
		  Arrays.sort(tokens[1].toCharArray());
		  if(tokens[1].equals(tokens[0])) kat.println(line + " = ANAGRAM");
		  else kat.println(line + " = NOT AN ANAGRAM");
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

