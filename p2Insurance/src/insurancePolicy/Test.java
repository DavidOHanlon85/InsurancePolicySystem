package insurancePolicy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AllPolicies p1 = new Motor("O'HA", 20, MotorType.CAR);
		
		Motor temp = (Motor) p1;
		
		temp.displayAll();

	}

}
