package p2Insurance;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import insurancePolicy.AllPolicies;
import insurancePolicy.Motor;
import insurancePolicy.MotorType;
import insurancePolicy.PolicySearch;

class TestPolicySearch {

	// test data

	AllPolicies a1, a2, a3, a4, a5;

	ArrayList<AllPolicies> inputs;

	PolicySearch policySearch;
	int minAge, maxAge;

	@BeforeEach
	void setUp() throws Exception {

		inputs = new ArrayList<AllPolicies>();

		policySearch = new PolicySearch();

		a1 = new Motor("lName1", 20, MotorType.CAR);
		a2 = new Motor("lName2", 25, MotorType.CAR);
		a3 = new Motor("lName3", 30, MotorType.BUS);
		a4 = new Motor("lName4", 35, MotorType.TAXI);
		a5 = new Motor("lName5", 50, MotorType.CAR);

		inputs.add(a1);
		inputs.add(a2);
		inputs.add(a3);
		inputs.add(a4);
		inputs.add(a5);

		minAge = 25;
		maxAge = 40;
	}

	@Test
	void testSearchByAgeValid() {

		ArrayList<AllPolicies> results = policySearch.searchByAge(inputs, minAge, maxAge);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(a2));
		assertTrue(results.contains(a3));
		assertTrue(results.contains(a4));

		results = policySearch.searchByAge(inputs, 35, 50);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(a4));
		assertTrue(results.contains(a5));

	}

	@Test
	void testSearchByAgeALNull() {

		ArrayList<AllPolicies> inputs = null;

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			PolicySearch.searchByAge(inputs, minAge, maxAge);
		});

		assertEquals("Input is null/ AL is empty", exp.getMessage());

	}

	@Test
	void testSearchByAgeALEmpty() {

		inputs.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			policySearch.searchByAge(inputs, minAge, maxAge);
		});

		assertEquals("Input is null/ AL is empty", exp.getMessage());

	}

	@Test
	void testSearchByAgeInvalidAgeRange() {

		inputs.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			policySearch.searchByAge(inputs, maxAge, minAge);
		});

		assertEquals("Min age > Max age", exp.getMessage());

	}

	@Test
	void testSearchForAllByMotorPolicyTypeValid() {

		ArrayList<Motor> motors = new ArrayList<Motor>();

		motors.add((Motor) a1);
		motors.add((Motor) a2);
		motors.add((Motor) a3);
		motors.add((Motor) a4);
		motors.add((Motor) a5);

		ArrayList<Motor> results2 = new ArrayList<Motor>();

		results2 = policySearch.searchForAllByMotorPolicyType(motors, MotorType.CAR);

		assertTrue(results2.size() == 3);
		assertTrue(results2.contains(a1));
		assertTrue(results2.contains(a2));
		assertTrue(results2.contains(a5));

		results2 = policySearch.searchForAllByMotorPolicyType(motors, MotorType.BUS);

		assertTrue(results2.size() == 1);
		assertTrue(results2.contains(a3));

	}

	@Test
	void testSearchForAllByMotorPolicyTypeNull() {

		ArrayList<Motor> motors = null;
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			PolicySearch.searchForAllByMotorPolicyType(motors, MotorType.CAR);
		});
		
		assertEquals("Input is null/ AL is empty", exp.getMessage());

	}
	
	@Test
	void testSearchForAllByMotorPolicyTypeALEmpty() {

		ArrayList<Motor> motors = new ArrayList<Motor>();

		motors.add((Motor) a1);
		motors.add((Motor) a2);
		motors.add((Motor) a3);
		motors.add((Motor) a4);
		motors.add((Motor) a5);
		
		motors.clear();
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			PolicySearch.searchForAllByMotorPolicyType(motors, MotorType.CAR);
		});
		
		assertEquals("Input is null/ AL is empty", exp.getMessage());

	}
	
	@Test
	void testSearchForAllByMotorPolicyTypeMotorTypeNull() {

		ArrayList<Motor> motors = new ArrayList<Motor>();

		motors.add((Motor) a1);
		motors.add((Motor) a2);
		motors.add((Motor) a3);
		motors.add((Motor) a4);
		motors.add((Motor) a5);
		
		motors.clear();
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			PolicySearch.searchForAllByMotorPolicyType(motors, null);
		});
		
		assertEquals("Input is null/ AL is empty", exp.getMessage());

	}
	
	

}
