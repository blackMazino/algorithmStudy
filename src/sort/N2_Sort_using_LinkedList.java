package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N2_Sort_using_LinkedList {

	static List<Integer> list;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		list = new LinkedList<>();
		for(int n=0;n<N;n++){
			list.set(n, Integer.parseInt(st.nextToken()));
		}
	}

}
