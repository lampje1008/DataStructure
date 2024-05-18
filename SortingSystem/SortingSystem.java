package SortingSystem;

import java.util.Random;

public class SortingSystem {
	public static void main(String[] args) {
		Random random = new Random();

		int sizes[] = {100, 1000, 10000, 100000};
		long timeTaken[][] = new long[sizes.length][2];
		
		for (int x = 0; x < sizes.length; x++) {
			Employee employees[] = new Employee[sizes[x]];
			for (int index = 0; index < sizes[x]; index++)
				employees[index] = new Employee(index + "", index + "", random.nextInt(sizes[x]) + 1);
			
			selectionSort(employees);
			
			for (int index = 0; index < sizes[x] / 2; index++) {
				int randomIndex = random.nextInt(sizes[x]);
				Employee temp = employees[randomIndex];
				employees[randomIndex] = employees[index];
				employees[index] = temp;
			}
			
			long startTime, endTime;
			
			startTime = System.currentTimeMillis();
			selectionSort(employees);
			endTime = System.currentTimeMillis();
			timeTaken[x][0] = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			mergeSort(employees, 0, sizes[x] - 1);
			endTime = System.currentTimeMillis();
			timeTaken[x][1] = endTime - startTime;
		}
		
		for (int i = 0; i < sizes.length; i++) {
			System.out.println("size: " + sizes[i]);
			System.out.println("    selection sort: " + timeTaken[i][0]);
			System.out.println("    merge sort:     " + timeTaken[i][1]);
		}
	}
	
	static void selectionSort(Employee employees[]) {
		for (int i = employees.length - 1; i >= 0; i--) {
			int maximum = 0;
			int index = -1;
			
			for (int j = i; j >= 0; j--)
				if (maximum <= employees[j].getSocialSecurityNumber()) {
					maximum = employees[j].getSocialSecurityNumber();
					index = j;
				}
			
			Employee temp = employees[i];
			employees[i] = employees[index];
			employees[index] = temp;
		}
	}
	
	static void merge(Employee arr[], int first, int mid, int last) {
		Employee sorted[] = new Employee[last - first + 1];
		int i, j, k;
		i = first;
		j = mid + 1;
		k = 0;

		while (i <= mid && j <= last)
		{
			if (arr[i].compareTo(arr[j]) <= 0) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}

		if (i > mid) 
			while (j <= last) sorted[k++] = arr[j++];
		else
			while (i <= mid) sorted[k++] = arr[i++];

		for (i = first, k = 0; i <= last; i++, k++) arr[i] = sorted[k];
	}

	static void mergeSort(Employee arr[], int first, int last)
	{
		if (first < last)
		{
			int mid = (first + last) / 2;
			mergeSort(arr, first, mid);
			mergeSort(arr, mid + 1, last);
			merge(arr, first, mid, last);
		}
	}
}
