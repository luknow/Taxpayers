package com.whitelist.taxpayers.api;

import java.util.Objects;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Person
 */
@Validated
public class Person {

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("pesel")
	private String pesel = null;

	@JsonProperty("nip")
	private String nip = null;

	public Person firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(example = "Jan", value = "")

	@Size(max = 60)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(example = "Nowak", value = "")

	@Size(max = 160)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person pesel(String pesel) {
		this.pesel = pesel;
		return this;
	}

	/**
	 * Get pesel
	 * 
	 * @return pesel
	 **/
	@ApiModelProperty(value = "")

	@Size(min = 11, max = 11)
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Person nip(String nip) {
		this.nip = nip;
		return this;
	}

	/**
	 * Get nip
	 * 
	 * @return nip
	 **/
	@ApiModelProperty(example = "1111111111", value = "")

	@Size(min = 10, max = 10)
	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return Objects.equals(this.firstName, person.firstName) && Objects.equals(this.lastName, person.lastName)
				&& Objects.equals(this.pesel, person.pesel) && Objects.equals(this.nip, person.nip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, pesel, nip);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");

		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    pesel: ").append(toIndentedString(pesel)).append("\n");
		sb.append("    nip: ").append(toIndentedString(nip)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
