import java.io.*;
import java.util.*;

public class AerospaceIntruders {
    /*
    NOTE:
    Test case answer is wrong, it should be 85 instead of 8. 
    */
    public static void main(String[] args) throws IOException {
        Kattio kat = new Kattio();

        int n = kat.nextInt();
        for(int i = 0; i < n; i++) {
            int num = kat.nextInt();
            ArrayList<Ship> ships = new ArrayList<>();
            for(int j = 0; j < num; j ++) {
                String line = kat.next();
                String[] tokens = line.split(":");
                String[] tokensL = tokens[0].split("_"); // name and ship type
                String[] tokensR = tokens[1].split(","); // numbers (x and y)
                ships.add(new Ship(tokensL[0], tokensL[1], Integer.parseInt(tokensR[0]), Integer.parseInt(tokensR[1])));
            }
            
            Collections.sort(ships);
            while(ships.size() > 0) {
                Ship ship = ships.get(0);

                kat.println("Destroyed Ship: " + ship.name + " xLoc: " + ship.x);
                ships.remove(0);
                for(Ship ship2 : ships) {
                    ship2.progress();
                }
                Collections.sort(ships);
            }
        }
        kat.close();
    }
}

class Ship implements Comparable<Ship> {
    String name;
    String type;
    int x, y;
    public Ship(String name, String type, int x, int y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Ship other) {
        if(this.x == other.x) {
            return -Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }

    public void progress() {
        if(this.type.equals("A")) this.x -= 10;
        else if (this.type.equals("B")) this.x -= 20;
        else if (this.type.equals("C")) this.x -= 30;
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