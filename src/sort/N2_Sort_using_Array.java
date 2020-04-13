package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
n^2 정렬
https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
https://gmlwjd9405.github.io/2018/05/08/algorithm-shell-sort.html


https://www.crocus.co.kr/1384
10
8 5 2 6 9 3 1 4 0 7 
*/

//1부터 시작!
public class N2_Sort_using_Array {
	static int arr [];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		
		for(int n = 1; n<=N;n++){
			int i = Integer.parseInt(st.nextToken());
			arr[n] = i;
		}
		
//		selectionSort();
//		
//		insertSort();
		
//		bubbleSort();
		
		shellSort();
		
		printArray(arr);

	}

	private static void printArray(int[] tArr) {
		for(int i=1;i<tArr.length;i++){
			System.out.print(tArr[i]+" ");
		}
		System.out.println();	
	}

	private static void selectionSort() {
	   for(int i = 1 ; i < arr.length ; i ++){
            for(int j = i ; j < arr.length ; j ++){
                if(arr[i] > arr[j]){
                	int tmp = arr[i];
                	arr[i] = arr[j];
                	arr[j] = tmp;
                }                
            }            
	    }		
	}

	private static void insertSort() {
		//두번쨰 항목을 비교
	    for (int i = 2; i < arr.length; i++) {
	        int key = arr[i];
	        for (int j = i - 1; j >= 1; j--){
	            if (arr[j] > key) {
	                arr[j + 1] = arr[j];
	                arr[j] = key;
	            }else{
	            	break;
	            }	                
	        }
	    }	
	}

	private static void bubbleSort() {
	    // 0 ~ (i-1)까지 반복
	    for (int i = N; i >1; i--) {	        
	        for (int j = 1; j < i ; j++){
	            if (arr[j] > arr[j + 1]){
	            	int tmp = arr[j];
	            	arr[j] = arr[j+1];
	            	arr[j+1] = tmp;
	            }
	        }
	    }	    	   
	}

	private static void shellSort() {
		int i, gap;
		for(gap=N/2; gap>0; gap=gap/2){		    
			if( gap%2 == 0) gap++; // gap을 홀수로 만든다.
		    
		     //부분 리스트의 개수는 gap과 같다.
			for(i=1; i<=gap; i++){//gap의 최소값은 1
		    	// 부분 리스트에 대한 삽입 정렬 수행
				inc_insertion_sort( i, N, gap);
		    }
//		    System.out.println(gap);
//			printArray(arr);
		}	
		
	}




	private static void inc_insertion_sort(int s, int e, int gap) {
		int i, j, key;
		for(i=s+gap; i<=e; i=i+gap){
			key = arr[i]; // 현재 삽입될 숫자인 i번째 정수를 key 변수로 복사	
			// 현재 정렬된 배열은 i-gap까지이므로 i-gap번째부터 역순으로 조사한다.
			// j 값은 s 이상이어야 하고
			// key 값보다 정렬된 배열에 있는 값이 크면 j번째를 j+gap번째로 이동
			for(j=i-gap; j>=s && arr[j]>key; j=j-gap){
				arr[j+gap] = arr[j]; // 레코드를 gap만큼 오른쪽으로 이동
			}	
			arr[j+gap] = key;			
		}		
	}

	
}
