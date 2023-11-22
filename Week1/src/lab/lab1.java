package lab;

public class lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double co[][] = {{3.4, 50.2}, {2.1, 0.55}}; //(x1,y1), (x2,y2)
		double eq[] = {44.5, 5.9}; //c1,c2
		double det = co[0][0]*co[1][1]-co[0][1]*co[1][0];
		double x = (eq[0]*co[1][1]-co[0][1]*eq[1])/det;
		double y = (eq[1]*co[0][0]-co[1][0]*eq[0])/det;
		System.out.println("x = "+ x +" y = "+y);
		
	}

}
