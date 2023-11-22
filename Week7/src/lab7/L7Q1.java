package lab7;
import java.util.Arrays;


public class L7Q1 {
	public static void unique(int[] array) {
		System.out.println("Unique Elements");
		//Arrays.sort(array);

		for (int i = 0; i < array.length; i++) {
			boolean flag = true;
			int checked = array[i];
			for (int j = 0; j < array.length; j++) {
				if (i == j) {
					continue;
				}
				if(array[j] == checked) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(checked);
			}
		}
	}
	
	 public static void printDuplicateElements(int[] array) {
        System.out.println("Duplicate elements:");
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println(array[i]);
            }
        }
    }
	
	public static void main(String[] args) {
		int[] array = {2,7,8,7,4,4,8,5,8};
		unique(array);
		printDuplicateElements(array);

	}

}
