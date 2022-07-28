import java.util.*;
import java.io.*;
public class p8 {
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();
        
        
        
        int n = kat.nextInt();
        for(int i = 0; i < n; i ++) {
            String line = kat.next();
            
            String builder = "";
            ArrayList<String> kept = new ArrayList<>();
            for(int j = 0; j < line.length(); j ++) {
                if(line.charAt(j) == 'A' || line.charAt(j) == 'T') builder += '0';
                if(line.charAt(j) == 'G' || line.charAt(j) == 'C') builder += '1';
                if(builder.length() == 7) {
                    kept.add(builder);
                    builder = "";
                }
            }
            String ret = "";
            for(String word : kept) {
                int parseInt = Integer.parseInt(word, 2);
                char c = (char)parseInt;
                
                ret += c;
            }
            kat.println(ret);
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