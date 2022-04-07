import java.io.*;
import java.util.*;
class AntiAsteroidWeapon {
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();
		
		int n = kat.nextInt();

		for(int i = 0; i < n; i ++) {
			int check = kat.nextInt();
			ArrayList<Calculate> allStuff = new ArrayList<>();
			for(int j = 0; j < check; j ++) {
				allStuff.add(new Calculate(kat.nextInt(), kat.nextInt()));
			}
			Collections.sort(allStuff);
			for(int j = 0; j < allStuff.size(); j ++) {
				kat.println(allStuff.get(j).numberA + " " + allStuff.get(j).numberB);
			}
		}
		// System.out.println("---");
		kat.close();
    }
}

class Calculate implements Comparable<Calculate> {
    int numberA, numberB;
    public Calculate(int a, int b) {
        this.numberA = a;
        this.numberB = b;
    }

    public int compareTo(Calculate other) {
		double first = Math.sqrt(numberA*numberA + numberB*numberB);
		double second = Math.sqrt(other.numberA*other.numberA + other.numberB*other.numberB);

		return Double.compare(first, second);
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
