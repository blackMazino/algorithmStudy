package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/*
10
8 5 2 6 9 3 1 4 0 7 
 */
public class NlogN_Sort_using_LinkedList {

	static List<Integer> list, mergeList;
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
//		quickSort(0,N-1);
//		heapSort();
		mergeSort();
		
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
	
	private static void heapSort() {
		minHeapfi(N);
//		maxHeapfi(N);
		for(int i=N-1;i>0;i--) {
			swap(0,i);
			minHeapfi(i);
//			maxHeapfi(i);
		}
	}

	private static void minHeapfi(int n) {
		System.out.println(n);
		for(int i=1;i<n;i++) {
			int child = i;
			while(child>0) {
				int parent = (child-1)/2;
				if(list.get(child) > list.get(parent)) {
					swap(child, parent);
//					print();
				}
				child = parent;
			}			
		}		
	}
	
	
	private static void maxHeapfi(int n) {
		for(int i=1;i<n;i++) {
			int child = i;
			while(child>0) {
				int parent = (child-1)/2;
				if(list.get(child) < list.get(parent)) {
					swap(child, parent);
				}
				child = parent;
			}			
		}		
	}
	

	private static void mergeSort() {
		mergeList = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			mergeList.add(-1);
		}
		doMergeSort(0,N-1);		
	}

	private static void doMergeSort(int s, int e) {
		int mid;
		if(s<e) {
			mid = (s+e)/2;
			doMergeSort(s,mid);
			doMergeSort(mid+1,e);
			merge(s,mid,e);
//			print();
		}
		
	}

	private static void merge(int s, int mid, int e) {
		int i,j,k;
		i=s;j=mid+1;k=s;
		while(i<=mid && j<=e) {
			if(list.get(i)<=list.get(j)) {
				mergeList.set(k++, list.get(i++));
			}else {
				mergeList.set(k++, list.get(j++));
			}		
		}
		if(i>mid) {
			for(int l=j;l<=e;l++) {
				mergeList.set(k++, list.get(l));
			}			
		}else {
			for(int l=i;l<=mid;l++) {
				mergeList.set(k++, list.get(l));
			}			
		}
		for(int l=s;l<=e;l++) {
			list.set(l,mergeList.get(l));
		}
		
	}
}
