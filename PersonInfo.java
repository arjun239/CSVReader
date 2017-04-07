/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fix.me.im.broken;

/**
 *
 * @author Arjun
 */


/**
 * Bean to store details of a person. First name, last name, zipcode of residence and age.
 * 
 * @author ckotha
 *
 */
public class PersonInfo {

    private String firstName;
    private String lastName;
    private String residenceZipcode;
    private int age;

    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getZipcode() {
		return residenceZipcode;
	}
	public void setZipcode(String zipcode) {
		this.residenceZipcode = zipcode;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}