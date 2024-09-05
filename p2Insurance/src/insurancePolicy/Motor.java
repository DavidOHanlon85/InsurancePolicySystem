/**
 * 
 */
package insurancePolicy;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author Daithi O hAnluain - 15621049
 */
public class Motor extends AllPolicies {

	// Instance variable

	private MotorType motorType;
	private String motorPolicyID;

	// Constructors

	/**
	 * This is the default constructor
	 */
	public Motor() {

	}

	/**
	 * This is the constructor with args for Motor
	 * 
	 * @param surname
	 * @param age
	 * @param motorType
	 * @param motorPolicyID
	 */
	public Motor(String surname, int age, MotorType motorType) {
		super(surname, age);
		this.setMotorType(motorType);
		this.setMotorPolicyID();
	}

	// Getters and Setters

	/**
	 * @return the motorType
	 */
	public MotorType getMotorType() {
		return motorType;

	}

	/**
	 * Sets the motorType
	 * @param motorType
	 * @throws IllegalArgumentException if null
	 */
	public void setMotorType(MotorType motorType) throws IllegalArgumentException {
		if (motorType == null) {
			throw new IllegalArgumentException("MotorType is null");
		} else {
			this.motorType = motorType;
		}
	}

	/**
	 * @return the motorPolicyID
	 */
	public String getMotorPolicyID() {
		return motorPolicyID;
	}

	/**
	 * @param motorPolicyID the motorPolicyID to set
	 */
	public void setMotorPolicyID() {
		if (this.getSurname() == null) {
			throw new IllegalArgumentException("No surname set");
		} else {
		this.motorPolicyID = createMotorPolicyID();
		}
	}

	// Methods

	private String createMotorPolicyID() {
		
		if (this.getSurname() == null) {
			throw new IllegalArgumentException("No surname set");
		}
		
		String generatedPolicyRef;

		String sur = getSurname().substring(0, 3);

		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;

		int timeStamp = year + month;

		int parity;

		if (timeStamp % 2 == 0) {
			parity = 0;
		} else {
			parity = 1;
		}

		generatedPolicyRef = sur + timeStamp + parity;
		
		return generatedPolicyRef;
	}

	// displayAll method

	public void displayAll() {
		System.out.println("Surname\t\t:" + getSurname());
		System.out.println("Age\t\t:" + getAge());
		System.out.println("Policy Ref\t:" + getMotorPolicyID());
		System.out.println("Motor Type\t:" + getMotorType());
	}

	// hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(motorPolicyID, motorType);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motor other = (Motor) obj;
		return Objects.equals(motorPolicyID, other.motorPolicyID) && motorType == other.motorType;
	}

}
