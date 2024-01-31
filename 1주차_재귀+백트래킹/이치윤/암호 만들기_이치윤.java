import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int L = 0;
	static int C = 0;
	static boolean visited[];
	static String[] results;
	static String[] strings;
	static List<String> answers = new ArrayList<>();
	static List<String> mList = Arrays.asList("a", "e", "i", "o", "u");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[C];
		strings = new String[C];
		results = new String[L];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			strings[i] = st.nextToken();
		}

		Arrays.sort(strings);

		permutation(0);

		Collections.sort(answers);
		for (String answer : answers) {
			System.out.println(answer);
		}
	}

	// 순열
	static void permutation(int cnt) {
		if (cnt == L) {
			String result = "";
			int mCount = 0;
			boolean flag = true;
			for (int i = 0; i < results.length; i++) {
				if (i < results.length - 1 && results[i].compareTo(results[i + 1]) > 0) {
					return;
				}

				result += results[i];
				if (mList.contains(results[i])) {
					mCount++;
				}
			}

			if (mCount >= 1 && L - mCount >= 2 && flag) {
				answers.add(result);
			}

			return;
		}

		for (int i = cnt; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				results[cnt] = strings[i];
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}

}
