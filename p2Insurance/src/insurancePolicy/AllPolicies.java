/**
 * 
 */
package insurancePolicy;

import java.util.Objects;

/**
 * @author Daithi O hAnluain - 15621049
 */
public abstract class AllPolicies {

	// Constants

	private static final int MIN_SURNAME_LENGTH = 3;
	private static final int MAX_SURNAME_LENGTH = 20;
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 50;

	// Instance Variables

	private String surname;
	private int age;

	// Constructors

	/**
	 * This is the default constructor
	 */
	public AllPolicies() {

	}

	/**
	 * This is the constructor with args
	 * 
	 * @param surname
	 * @param age
	 */
	public AllPolicies(String surname, int age) {
		super();
		this.setSurname(surname.toUpperCase());
		this.setAge(age);
	}

	// Getter and Setters

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets surname based on the business rules that it must be between {@value AllPolicies#MIN_SURNAME_LENGTH} and {@value AllPolicies#MAX_SURNAME_LENGTH}
	 * characters
	 * 
	 * @param surname
	 * @throws IllegalArgumentException - if surname is null or surname is outside
	 *                                  business rules - appropriate error messages
	 *                                  returned
	 */
	public void setSurname(String surname) throws IllegalArgumentException {
		if (surname == null) {
			throw new IllegalArgumentException("Surname is null");
		}

		if (surname.length() >= MIN_SURNAME_LENGTH && surname.length() <= MAX_SURNAME_LENGTH) {
			this.surname = surname;
		} else {
			throw new IllegalArgumentException("Surname is invalid");
		}

	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets age based on the business rule that it must be between 18 and 50
	 * @param age
	 * @throws IllegalArgumentException - if age is outside of business rule appropriate message returned
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age >= MIN_AGE && age <= MAX_AGE) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("Age is invalid");
		}
	}

	// toString Method

	@Override
	public String toString() {
		return "AllPolicies [surname=" + surname + ", age=" + age + "]";
	}

	// hashCode and Equals

	@Override
	public int hashCode() {
		return Objects.hash(age, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllPolicies other = (AllPolicies) obj;
		return age == other.age && Objects.equals(surname, other.surname);
	}

}
