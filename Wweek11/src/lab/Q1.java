package lab;


public class Q1 {

	public static String[] longArray(String[] a1, String[] a2) {
		int size= Math.max(a1.length, a2.length);
		String[] result = new String[size];
		for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
			result[i] = a1[i].length() >= a2[i].length() ? a1[i] : a2[i];
		}
		for (int i = Math.min(a1.length, a2.length); i < size; i++) {
			result[i] = "oops";
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a1 = {"star","pie","jelly bean","car"};
		String[] a2 = {"cookie","fig","banana","soda"};
		String[] result = longArray(a1,a2);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] + "\n");
		}
		
		String[] b1 = {"Splinter","Leo","April","Don","Raph"};
		String[] b2 = {"Krang","Shredder","Bebop"};
		
		String[] result1 = longArray(b1,b2);
		for (int i = 0; i < result1.length; i++) {
			System.out.println(result1[i] + "\n");
		}
	}

}
