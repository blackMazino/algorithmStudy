package data_structure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heap {
	static PriorityQueue minHeap, maxHeap;
	public static void main(String[] args) {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			return b-a;//오름차순 Desc
			}
			
		});

		for(int i=0;i<=9;i++) {
			minHeap.add(i);
			maxHeap.add(i);
		}
	
		print(minHeap);
		print(maxHeap);
	}
	private static void print(PriorityQueue pq) {
		while(!pq.isEmpty()) {
		System.out.print(pq.poll()+" ");
		}
		System.out.println();
	}	

}
