package data_structure;

import java.util.ArrayList;

//https://kim6394.tistory.com/222
public class Heap {

	static minHeap minHEAP;
	static maxHeap maxHEAP;
	public static void main(String[] args) {
		minHEAP = new minHeap ();
		maxHEAP = new maxHeap ();
		// TODO Auto-generated method stub
		for(int i=0;i<=9;i++) {
			if(i==0) {
				maxHEAP.delete();
				minHEAP.delete();
				continue;
			}
			int val = (int) Math.round(Math.random()*100);
//			System.out.print(val + " ");
			maxHEAP.insert(val);
			minHEAP.insert(val);
		}
		
		//delete and print all

		while(true){
			if(minHEAP.size() <=1 || maxHEAP.size() <= 1){
				break;
			}
			System.out.print(minHEAP.delete()+" "+maxHEAP.delete());
			System.out.println();
		}
	}

}
class minHeap{
	private ArrayList<Integer> heap;
	public minHeap(){
		heap = new ArrayList<>();
		heap.add(Integer.MIN_VALUE);
	}
	
	public int size(){
		return heap.size();
	}
	
	public void insert(int val){
		heap.add(val);
		int p = heap.size()-1;
		//to root
		while(p>1 && heap.get(p/2) > heap.get(p)){
			swap(p/2, p);
			p = p/2;
		}
	}

	public int delete(){
		int delVal = 0;
		if(heap.size()-1<1){
			return delVal;
		}
		
		//root value delete
		delVal = heap.get(1);
		int last = heap.size()-1;
		heap.set(1,  heap.get(last));
		heap.remove(last);
		
		int no = 1;
		while((no*2) < heap.size()){
			// default is left
			int min = heap.get(no * 2);
			int minNo = no * 2;
			
			// compare with right
			if((no * 2 +1) < heap.size() && min > heap.get(no*2+1)){
				min = heap.get(no*2+1);
				minNo = no*2+1;
			}
			
			// if origin value is less than min value of this level then, stop. 
			if(heap.get(no)< min){
				break;
			}
			
			//swap and go on
			swap(no, minNo);
			no = minNo;
		}
		
		return delVal;
	}
		
	private void swap(int a, int b) {
		int tmp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, tmp);		
	}
}
class maxHeap{
	private ArrayList<Integer> heap;
	public maxHeap(){
		heap = new ArrayList<>();
		heap.add(Integer.MAX_VALUE);
	}
	
	public int size(){
		return heap.size();
	}
	
	public void insert(int val){
		heap.add(val);
		int p = heap.size()-1;
		//to root
		while(p>1 && heap.get(p/2) < heap.get(p)){
			swap(p/2, p);
			p = p/2;
		}
	}

	public int delete(){
		int delVal = 0;
		if(heap.size()-1<1){
			return delVal;
		}
		
		//root value delete
		delVal = heap.get(1);
		int last = heap.size()-1;
		heap.set(1,  heap.get(last));
		heap.remove(last);
		
		int no = 1;
		while((no*2) < heap.size()){
			int max = heap.get(no * 2);
			int maxNo = no * 2;
			
			if((no * 2 +1) < heap.size() && max < heap.get(no*2+1)){
				max = heap.get(no*2+1);
				maxNo = no*2+1;
			}
			
			if(heap.get(no)> max){
				break;
			}
			
			swap(no, maxNo);
			no = maxNo;
		}
		
		return delVal;
	}
	
	private void swap(int a, int b) {
		int tmp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, tmp);		
	}
}