import java.io.*;
import java.util.*;
public class Autocorrect {
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();
        int n = kat.nextInt();

        for(int i = 0; i < n; i ++) {
            int d = kat.nextInt();
            int w = kat.nextInt();

            ArrayList<String> words = new ArrayList<>();

            for(int j = 0; j < d; j ++) {
                words.add(kat.next());
            }
            for(int j = 0; j < w; j ++) {
				String ret = "";
				int min = Integer.MAX_VALUE;
                String word = kat.next();
                for(int k = 0; k < words.size(); k ++) {
					int newCount = 0;
					if(word.length() == words.get(k).length()) {
						for(int l = 0; l < word.length(); l++) {
							if(word.charAt(l) == words.get(k).charAt(l)) newCount++;
						}
						if(Math.min(newCount, min) == newCount) ret = words.get(k);
					}
				}
				kat.println(ret);
            }
        }
		// System.out.println("----");

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

