package com.whitelist.taxpayers.api;

import java.util.Objects;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntityCheck
 */
@Validated
public class EntityCheck {
	
	@JsonProperty("accountAssigned")
	private String accountAssigned = null;

	@JsonProperty("requestId")
	private String requestId = null;

	public EntityCheck accountAssigned(String accountAssigned) {
		this.accountAssigned = accountAssigned;
		return this;
	}

	/**
	 * Czy rachunek przypisany do podmiotu czynnego
	 * 
	 * @return accountAssigned
	 **/
	@ApiModelProperty(example = "TAK", value = "Czy rachunek przypisany do podmiotu czynnego ")

	public String getAccountAssigned() {
		return accountAssigned;
	}

	public void setAccountAssigned(String accountAssigned) {
		this.accountAssigned = accountAssigned;
	}

	public EntityCheck requestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	/**
	 * Get requestId
	 * 
	 * @return requestId
	 **/
	@ApiModelProperty(example = "d2n10-84df1a1", value = "")

	@Size(max = 18)
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EntityCheck entityCheck = (EntityCheck) o;
		return Objects.equals(this.accountAssigned, entityCheck.accountAssigned)
				&& Objects.equals(this.requestId, entityCheck.requestId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountAssigned, requestId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityCheck {\n");

		sb.append("    accountAssigned: ").append(toIndentedString(accountAssigned)).append("\n");
		sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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
