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
			list.add(Integer.parseInt(st.nextToken()));
		}
		
//		selectionSort();
//		insertSort();
//		bubbleSort();
		shellSort();
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
	
	private static void selectionSort() {
		for(int i=0;i<list.size();i++){			
			for(int j=i;j<list.size();j++){
				if(list.get(i)> list.get(j)){
					swap(i,j);
				}
			}
		}		
	}

	private static void insertSort() {
		for(int i=1;i<list.size();i++){
			int key = list.get(i);
			for(int j=i-1;j>=0;j--){
				if(list.get(j)>key){
					list.set(j+1, list.get(j));
					list.set(j, key);
				}else{
					break;
				}
			}
		}
	}
	private static void bubbleSort() {
		for(int i=N-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(list.get(j)> list.get(j+1)){
					swap(j,j+1);
				}
			}			
		}		
	}
	
	private static void shellSort() {
		int i,gap;
		for(gap = N/2;gap>0;gap/=2){
			if(gap%2==0){
				gap++;
			}
			for(i=0;i<=gap;i++){
				inc_insertion_sort(i,N-1,gap);
			}
		}
	}

	private static void inc_insertion_sort(int s, int e, int gap) {
		int i,j,key;
		for(i=s+gap;i<=e;i+=gap){
			key = list.get(i);
			for(j=i-gap; j>=s && list.get(j)>key; j-=gap){
				list.set(j+gap, list.get(j));
			}
			list.set(j+gap, key);
		}
		
	}
}
