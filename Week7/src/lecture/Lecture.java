package lecture;

public class Lecture {
	public static int findMax(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i]>max) {
				max = array[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] array = {5,9,7,1,3,6,4,8,2,30,15,20,15};
		int max = findMax(array);
		System.out.println(max);
	}

}
