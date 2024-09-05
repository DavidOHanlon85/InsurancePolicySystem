package p2Insurance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import insurancePolicy.Motor;
import insurancePolicy.MotorType;

class TestMotor {

	// test data

	String validSurnameLow, validSurnameMid, validSurnameHigh;
	String invalidSurnameLow, invalidSurnameHigh;

	int validAgeLow, validAgeMid, validAgeHigh;
	int invalidAgeLow, invalidAgeHigh;

	MotorType car, bus, taxi;

	Motor m;

	@BeforeEach
	void setUp() throws Exception {

		validSurnameLow = "ABC";
		validSurnameMid = "ABCDEFGHI";
		validSurnameHigh = "A".repeat(20);

		invalidSurnameLow = "AB";
		invalidSurnameHigh = "A".repeat(21);

		validAgeLow = 18;
		validAgeMid = 30;
		validAgeHigh = 50;

		invalidAgeLow = 17;
		invalidAgeHigh = 51;

		car = MotorType.CAR;
		bus = MotorType.BUS;
		taxi = MotorType.TAXI;

		m = new Motor(validSurnameMid, validAgeHigh, bus);

	}

	@Test
	void testConstructorValid() {

		assertNotNull(m);
		assertEquals(validSurnameMid, m.getSurname());
		assertEquals(validAgeHigh, m.getAge());
		assertEquals(bus, m.getMotorType());

		assertNotNull(m.getMotorPolicyID());

	}

	@Test
	void testConstructorInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			Motor m1 = new Motor(invalidSurnameLow, validAgeMid, bus);
		});

		assertEquals("Surname is invalid", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			Motor m1 = new Motor(validSurnameHigh, invalidAgeLow, bus);
		});

		assertEquals("Age is invalid", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			Motor m1 = new Motor(validSurnameHigh, validAgeMid, null);
		});

		assertEquals("MotorType is null", exp.getMessage());

	}

	@Test
	void testSetGetMotorTypeValid() {
		m.setMotorType(bus);
		assertEquals(MotorType.BUS, m.getMotorType());

		m.setMotorType(car);
		assertEquals(MotorType.CAR, m.getMotorType());

		m.setMotorType(taxi);
		assertEquals(MotorType.TAXI, m.getMotorType());
	}

	@Test
	void testSetGetMotorTypeInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setMotorType(null);
		});

		assertEquals("MotorType is null", exp.getMessage());

	}

	@Test
	void testGetSetSurnameValid() {
		m.setSurname(validSurnameLow);
		assertEquals(validSurnameLow, m.getSurname());

		m.setSurname(validSurnameMid);
		assertEquals(validSurnameMid, m.getSurname());

		m.setSurname(validSurnameHigh);
		assertEquals(validSurnameHigh, m.getSurname());

	}

	@Test
	void testGetSetSurnameInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setSurname(invalidSurnameLow);
		});

		assertEquals("Surname is invalid", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setSurname(invalidSurnameHigh);
		});

		assertEquals("Surname is invalid", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setSurname(null);
		});

		assertEquals("Surname is null", exp.getMessage());

	}

	@Test
	void testGetSetAgeValid() {
		m.setAge(validAgeLow);
		assertEquals(validAgeLow, m.getAge());

		m.setAge(validAgeMid);
		assertEquals(validAgeMid, m.getAge());

		m.setAge(validAgeHigh);
		assertEquals(validAgeHigh, m.getAge());
	}

	@Test
	void testGetSetAgeInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAge(invalidAgeLow);
		});

		assertEquals("Age is invalid", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAge(invalidAgeHigh);
		});

		assertEquals("Age is invalid", exp.getMessage());

	}

	@Test
	void testGetSetMotorPolicyIDValid() {
		Motor m1 = new Motor("OHANLON", 20, bus);

		String MotorPolicyID = m1.getMotorPolicyID();

		System.out.println(MotorPolicyID);

		String expectedPrefix = "OHA";

		assertEquals(expectedPrefix, m1.getMotorPolicyID().substring(0, 3));

		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;

		int timeStamp = year + month;

		int policyNumber = Integer.parseInt(m1.getMotorPolicyID().substring(3, 7));

		assertEquals(timeStamp, policyNumber);

		int parity = Integer.parseInt(m1.getMotorPolicyID().substring(7, 8));

		if ((policyNumber % 2 == 0 && parity == 0) || (policyNumber % 2 == 1 && parity == 1)) {
			assertTrue(true);
		} else {
			assertTrue(false, "Issue with parity");
		}

	}

	@Test
	void testGetSetMotorPolicyIDInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			Motor m2 = new Motor("ad", 20, bus);
			m2.setMotorPolicyID();
		});

		assertEquals("Surname is invalid", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			Motor m2 = new Motor("ad", 20, bus);
			m2.setSurname(null);
			m2.getMotorPolicyID();
		});

		assertEquals("Surname is invalid", exp.getMessage());
	}

}
