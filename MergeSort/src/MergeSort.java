import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i = 0;
		System.out.print("Type in as many numbers as you want, then type -1 :");
		while(i != -1) {
			i = sc.nextInt();
			if(i == -1) break;
			arr.add(i);
		}
		
		sc.close();
		
		int[] c = new int[arr.size()];
		for(int j = 0; j < c.length; j++) {
			c[j] = arr.get(j);
		}
		
		long l = System.nanoTime();
		
		c = sort(c);
		
		long l1 = System.nanoTime();
		
		System.out.println(Arrays.toString(c) + " Merge Sorted in " + (l1 - l) + " nanoseconds");
		
		
	}
	
	public static int[] merge(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		int[] arr = new int[a.length + b .length];
		
		while(k < arr.length) {
			if(i >= a.length) {
				arr[k] = b[j];
				j++;
			} else {
				if(j >= b.length) {
					arr[k] = a[i];
					i++;
				} else {
					if(a[i] < b[j]) {
						arr[k] = a[i];
						i++;
					} else {
						arr[k] = b[j];
						j++;
					}
				}
			}
			k++;
		}
		return arr;
	}
	
	public static int[] sort(int[] unsorted) {
		if(unsorted.length > 1) {
			int[] arr = new int[unsorted.length];
			if(unsorted.length % 2 == 0) {
				int[] left = new int[unsorted.length / 2];
				int[] right = new int[unsorted.length / 2];
				for(int i = 0; i < unsorted.length / 2; i++) {
					left[i] = unsorted[i];
					right[i] = unsorted[unsorted.length - i - 1];
				}
				
				left = sort(left);
				right = sort(right);
				
				arr = merge(left, right);
				
				return arr;
				
			} else {
				
				int[] left = new int[unsorted.length / 2];
				int[] right = new int[unsorted.length / 2 + 1];
				for(int i = 0; i < unsorted.length / 2; i++) {
					left[i] = unsorted[i];
					right[i] = unsorted[unsorted.length - i - 1];
				}
				
				right[right.length - 1] = unsorted[unsorted.length / 2];
				
				left = sort(left);
				right = sort(right);
				
				arr = merge(left, right);
				
				return arr;
			}
		} else {
			return unsorted;
		}
	}

}
