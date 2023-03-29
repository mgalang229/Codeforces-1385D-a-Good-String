import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class AuthorSol {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			char[] s = fs.next().toCharArray();
			System.out.println(calc(s, 'a'));
		}
		out.close();
	}
	
	static int calc(char[] s, char letter) {
		if (s.length == 1) {
			return (s[0] != letter ? 1 : 0);
		}
		int mid = s.length / 2;
		int countLeft = calc(String.valueOf(s).substring(0, mid).toCharArray(), (char) ((char) letter + 1));
		int countCur = 0;
		for (int i = mid; i < s.length; i++) {
			if (s[i] == letter) {
				countCur++;
			}
		}
		countLeft += s.length / 2 - countCur;
		int countRight = calc(String.valueOf(s).substring(mid, s.length).toCharArray(), (char) ((char) letter + 1));
		countCur = 0;
		for (int i = 0; i < mid; i++) {
			if (s[i] == letter) {
				countCur++;
			}
		}
		countRight += s.length / 2 - countCur;
		return Math.min(countLeft, countRight);
	}
	
	static final Random rnd = new Random();
	static void shuffleSortArr(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
