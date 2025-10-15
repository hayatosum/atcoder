import java.util.*;

public class Main {

	public static void main(String args[]) {

		// 入力
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = Integer.parseInt(sc.next());
		Integer[] a = new Integer[n];
		Arrays.setAll(a, i -> Integer.parseInt(sc.next()));
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		sc.close();

		// 主処理
		Integer.parseInt(s);
		int result = 0;

		// 出力
		System.out.println(result);
	}
}
