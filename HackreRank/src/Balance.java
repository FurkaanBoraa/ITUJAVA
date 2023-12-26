
public class Balance {
	public static String isBalanced(String s) {
		String balanced1 = "{}";
		String balanced2 = "()";
		s = s.replace(balanced1,"");
		s = s.replace(balanced2,"");
		System.out.println(s);
		if(s.isEmpty()) {
			return "true";
		}else if(s.contains(balanced1) || s.contains(balanced2)) {
			Balance.isBalanced(s);
		}else {
			return "false";
		}
		return "hata";
	}
	
	public static void main(String[] args) {
		String a = "(){}";
		String b = "{()}";
		String c = "{()";
		System.out.println("testing a");
		System.out.println(Balance.isBalanced(a));
		System.out.println("testing b");
		System.out.println(Balance.isBalanced(b));
		System.out.println("testing c");
		System.out.println(Balance.isBalanced(c));
	}

}
