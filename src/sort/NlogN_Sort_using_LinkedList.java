package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/*
10
8 5 2 6 9 3 1 4 0 7 
 */
public class NlogN_Sort_using_LinkedList {

	static List<Integer> list;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		list = new LinkedList<>();
		for(int n=0;n<N;n++){
			list.add(Integer.parseInt(st.nextToken()));
		}
		quickSort(0,N-1);
		print();
	}

	private static void print() {
		for(int i : list){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	private static void swap(int i, int j) {
		int tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j,tmp);		
	}
	
	private static void quickSort(int left, int right) {
		if(left < right){
			int q = partition(left, right);
			
			quickSort(left, q-1);
			quickSort(q+1, right);
		}
		
	}

	private static int partition(int left, int right) {
		int pivot = list.get(left);
		int low = left + 1;
		int high = right;
		
		while(low<=high){
			while(pivot >= list.get(low) && low <= right){
				low++;
			}
			while(pivot <= list.get(high) && high >= (left+1)){
				high--;
			}
			if(low <= high){
				swap(low, high);
			}
		}
		swap(left, high);
		return high;
	}
}
