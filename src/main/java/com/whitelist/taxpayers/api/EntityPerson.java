package com.whitelist.taxpayers.api;

import java.util.Objects;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntityPerson
 */
@Validated
public class EntityPerson {

	@JsonProperty("companyName")
	private String companyName = null;

	public EntityPerson companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	/**
	 * Get companyName
	 * 
	 * @return companyName
	 **/
	@ApiModelProperty(example = "Nazwa firmy", value = "")

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EntityPerson entityPerson = (EntityPerson) o;
		return Objects.equals(this.companyName, entityPerson.companyName) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityPerson {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
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
