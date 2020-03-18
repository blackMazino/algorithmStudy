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

https://www.crocus.co.kr/1384
10
8 5 2 6 9 3 1 4 0 7 
*/
public class N2_Sort_using_Array {
	static int arr [];
	static int N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
		
		bubbleSort();
		
		for(int i=1;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}


	private static void selectionSort() {
		   for(int i = 1 ; i < arr.length ; i ++)
		    {
	            for(int j = i ; j < arr.length ; j ++)
	            {
	                if(arr[i] > arr[j]){
	                	int tmp = arr[i];
	                	arr[i] = arr[j];
	                	arr[j] = tmp;
	                }                
	            }            
		    }		
		}
	
	private static void insertSort() {
	    for (int i = 2; i < arr.length; i++) {
	        int key = arr[i];
	        for (int j = i - 1; j >= 1; j--)
	        {
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
	    for (int i = N-1; i >1; i--) {	        
	        for (int j = 1; j < i ; j++){
	            if (arr[j] > arr[j + 1]){
	            	int tmp = arr[j];
	            	arr[j] = arr[j+1];
	            	arr[j+1] = tmp;
	            }
	        }
	    }	    	   
	}

	
	
}
