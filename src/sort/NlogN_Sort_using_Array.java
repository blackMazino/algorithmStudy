package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* nlog2N 정렬 (log2는 모다? binary!)
https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html (worst N2)
https://www.crocus.co.kr/440
https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html
https://hongku.tistory.com/166
  

10
8 5 2 6 9 3 1 4 0 7 

*/

//0부터 시작!
public class NlogN_Sort_using_Array {
	static int []arr;
	static int N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];			

		for(int n = 0; n<N;n++){
			int i = Integer.parseInt(st.nextToken());
			arr[n] = i;
		}
		
//		quickSort(0,N-1);
		
		heapSort();//오른차순 이므로 minHeap
		printArray(arr);
	}
	
	private static void swap2(int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp; 
	}
	
	private static void printArray(int[] tArr) {
		for(int i=0;i<tArr.length;i++){
			System.out.print(tArr[i]+" ");
		}
		System.out.println();	
	}

	
	private static void quickSort(int left, int right) {
	    /* 정렬할 범위가 2개 이상의 데이터이면(리스트의 크기가 0이나 1이 아니면) */
		if(left<right){
			// partition 함수를 호출하여 피벗을 기준으로 리스트를 비균등 분할 -분할(Divide)
			int q = partition(left, right); // q: 피벗의 위치
		
			// 피벗은 제외한 2개의 부분 리스트를 대상으로 순환 호출
			quickSort(left, q-1); // (left ~ 피벗 바로 앞) 앞쪽 부분 리스트 정렬 -정복(Conquer)
			quickSort(q+1, right); // (피벗 바로 뒤 ~ right) 뒤쪽 부분 리스트 정렬 -정복(Conquer)
	    }	
	}
	
	private static int partition( int left, int right) {
	    int pivot = arr[left]; // 피벗의 위치는 가장 왼쪽에서 시작
	    int low = left + 1;
	    int high = right;	 
	 
	    while (low <= high){ // 교차되기 전까지 반복한다 	    
	        while (pivot >= arr[low] && low <= right){ // 피벗보다 큰 값을 찾는 과정 	        
	            low++; // low를 오른쪽으로 이동 
	        }
	 
	        while (pivot <= arr[high] && high >= (left+1) ){ // 피벗보다 작은 값을 찾는 과정 	        
	            high--; // high를 왼쪽으로 이동
	        }
	 
	        if (low <= high){// 교차되지 않은 상태이면 스왑 과정 실행 	        
	            swap2(low, high); //low와 high를 스왑 
	        }	
	    }
	    swap2(left, high); // 피벗과 high가 가리키는 대상을 교환 
	    return high;  // 옮겨진 피벗의 위치정보를 반환 
		
	}
	
	
	
	
	private static void heapSort() {
		minheap(N);//오름차순
//		maxheap(N);//내림차순
		for(int i=N-1;i>0;i--){
			swap2(0, i);
			minheap(i);
//			maxheap(i);
		}		
	}


	private static void minheap(int n) {
		for(int i=1;i<n;i++){//두번째 부터 마지막까지 
			int child = i;
			while(child>0){
				int parent = (child-1) / 2;
				if(arr[child] > arr[parent]){
					swap2( child, parent);
				}
				child = parent;
			}
		}
	}
	
	private static void maxheap(int n) {
		for(int i=1;i<n;i++){//두번째 부터 마지막까지 
			int child = i;
			while(child>0){
				int parent = (child-1) / 2;
				if(arr[child] < arr[parent]){
					swap2( child, parent);
				}
				child = parent;
			}
		}
	}
}
