/**
 * 
 */
package insurancePolicy;

import java.util.ArrayList;

/**
 * @author Daithi O hAnluain - 15621049
 */
public class PolicySearch {

	public static void main(String[] args) {
		ArrayList<AllPolicies> inputs = new ArrayList<AllPolicies>();
		
		AllPolicies p1 = new Motor("OHANLON", 20, MotorType.CAR);
		AllPolicies p2 = new Motor("OHANLON", 25, MotorType.CAR);
		AllPolicies p3 = new Motor("OHANLON", 30, MotorType.CAR);
		AllPolicies p4 = new Motor("OHANLON", 43, MotorType.CAR);
		
		inputs.add(p1);
		inputs.add(p2);
		inputs.add(p3);
		inputs.add(p4);
		
		
		ArrayList<Motor> inputs2 = new ArrayList<Motor>();
		
		Motor m1 = new Motor("John", 21, MotorType.CAR);
		Motor m2 = new Motor("John", 21, MotorType.CAR);
		Motor m3 = new Motor("John", 21, MotorType.CAR);
		Motor m4 = new Motor("John", 21, MotorType.TAXI);
		Motor m5 = new Motor("John", 21, MotorType.TAXI);
		Motor m6 = new Motor("John", 21, MotorType.BUS);
		
		inputs2.add(m1);
		inputs2.add(m2);
		inputs2.add(m3);
		inputs2.add(m4);
		inputs2.add(m5);
		inputs2.add(m6);
		
		ArrayList<AllPolicies> results = searchByAge(inputs, 20, 30);
		
		System.out.println(results.size());
		
		for (AllPolicies a : results) {
			System.out.println(a);
			}
		
		ArrayList<Motor> results2 = searchForAllByMotorPolicyType(inputs2, MotorType.CAR);
		
		System.out.println(results2.size());
		for (Motor a : results2) {
			a.displayAll();
			}
		
	}

	/**
	 * This method searches the input array of policies for policy holders
	 * between the minAge and maxAge inclusive and returns this in an ArrayList
	 * called results
	 * 
	 * @param inputs
	 * @param minAge
	 * @param maxAge
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<AllPolicies> searchByAge(ArrayList<AllPolicies> inputs, int minAge, int maxAge)
			throws IllegalArgumentException {
		ArrayList<AllPolicies> results = new ArrayList<AllPolicies>();

		if (minAge > maxAge) {
			throw new IllegalArgumentException("Min age > Max age");
		}

		if (inputs == null || inputs.size() == 0) {
			throw new IllegalArgumentException("Input is null/ AL is empty");
		}
		
		for (AllPolicies p : inputs) {
			if (p.getAge() >= minAge && p.getAge() <= maxAge) {
				results.add(p);
			}
		}

		return results;

	}

	/**
	 * This method searches the input array for policy of a particular motor type
	 * called results
	 * @param inputs
	 * @param motorType
	 * @return
	 */
	public static ArrayList<Motor> searchForAllByMotorPolicyType(ArrayList<Motor> inputs, MotorType motorType) {
		ArrayList<Motor> results = new ArrayList<Motor>();

		if (inputs == null || inputs.size() == 0) {
			throw new IllegalArgumentException("Input is null/ AL is empty");
		}
		
		if (motorType == null) {
			throw new IllegalArgumentException("Motortype is null");
		}

		for (Motor p : inputs) {
			if (p.getMotorType() == motorType) {
				results.add(p);
			}
		}

		return results;

	}

}
