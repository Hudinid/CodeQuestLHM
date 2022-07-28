import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class p15 {
	static ArrayList<Pair> twoPair = new ArrayList<>();
	static ArrayList<Pair> threePair = new ArrayList<>();
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i ++) {
			int numLines = Integer.parseInt(br.readLine());

			twoPair.clear();
			threePair.clear();

			for(int j = 0; j < numLines; j ++) {
				String line = br.readLine();
				addToTwo(line);
				addToThree(line);
			}

			Collections.sort(twoPair);
			Collections.sort(threePair);

			int twoSize =0;
			int threeSize = 0;

			for(Pair pair : twoPair) {
				twoSize += pair.number;
			}

			for(Pair pair : threePair) {
				threeSize += pair.number;
			}

			for(Pair pair : twoPair) {
				double decimalNumber = (pair.number / twoSize) * 100;
				String reFormat = String.format("%.3f", decimalNumber);
				pw.println(pair.id+ ": " + reFormat + "%");
			}
			
			for(Pair pair : threePair) {
				double decimalNumber = (pair.number / threeSize) * 100;
				String reFormat = String.format("%.3f", decimalNumber);
				pw.println(pair.id+ ": " + reFormat + "%");
			}
		}
		
		pw.close();
		
    }


public static void addThing(String id) {
	if(id.length() == 2) {
		for(Pair pair : twoPair) {
			if(id.equals(pair.id)) { 
				twoPair.add(new Pair(id, pair.number+1)); 
				twoPair.remove(pair);
				return;
			}
		}
		twoPair.add(new Pair(id, 1.0));
	}

	if(id.length() == 3) {
		for(Pair pair : threePair) {
			if(id.equals(pair.id)) { 
				threePair.add(new Pair(id, pair.number+1)); 
				threePair.remove(pair);
				return;
			}
		}
		threePair.add(new Pair(id, 1.0));
	}
}


public static void addToTwo(String line) {
	line = line.toUpperCase();
	String[] tokens = line.split(" ");
	
	for(String token : tokens) {
		String add = "";
		
		for(int i = 0; i < token.length(); i ++) {
			if((int) token.charAt(i) >= 65 && (int) token.charAt(i) <= 90) {
				add += token.charAt(i);
				if(add.length() == 2) {
					addThing(add);
					add = "";
					i--;
				}
			}
			
		}
	}
}

public static void addToThree(String line) {
	line = line.toUpperCase();
	String[] tokens = line.split(" ");

	for(String token : tokens) {
		String add = "";
		// System.out.println(token);
		int reset = 0;
		for(int i = 0; i < token.length(); i ++) {
			
			if((int) token.charAt(i) >= 65 && (int) token.charAt(i) <= 90) {
				add += token.charAt(i);
				// System.out.println(add);
				if(add.length() == 3) {
					
					addThing(add);
					add = "";
					i-= (2 + reset);
					reset = 0;
				}
			}
			else reset ++;
		}
	}
}
}

class Pair implements Comparable<Pair> {
	String id;
	double number;
	public Pair(String id, double number) {
		this.id = id;
		this.number = number;
	}

	public int compareTo(Pair other) {
		return this.id.compareTo(other.id);
	}
}

