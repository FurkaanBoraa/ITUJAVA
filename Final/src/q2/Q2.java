package q2;

public class Q2 {

	public static int FindClosest(int[] A, int price) {
		int closest = -1;
		for (int i = 0; i < A.length; i++) {
			if (!(A[i] > price) && A[i] > closest) {
				closest = A[i];
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		int[] a1 = { 900, 885, 989, 1 };
		int[] a2 = { 200 };
		int[] a3 = { 500, 300, 241, 99, 501 };
		int[] a4 = { 200 };

		System.out.println(FindClosest(a1, 880));
		System.out.println(FindClosest(a2, 320));
		System.out.println(FindClosest(a3, 50));
		System.out.println(FindClosest(a4, 120));
	}

}
