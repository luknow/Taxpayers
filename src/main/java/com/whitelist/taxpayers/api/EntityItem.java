package com.whitelist.taxpayers.api;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntityItem
 */
@Validated
public class EntityItem {
	
	@JsonProperty("subject")
	private Entity subject = null;

	@JsonProperty("requestId")
	private String requestId = null;

	public EntityItem subject(Entity subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Get subject
	 * 
	 * @return subject
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Entity getSubject() {
		return subject;
	}

	public void setSubject(Entity subject) {
		this.subject = subject;
	}

	public EntityItem requestId(String requestId) {
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
		EntityItem entityItem = (EntityItem) o;
		return Objects.equals(this.subject, entityItem.subject) && Objects.equals(this.requestId, entityItem.requestId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subject, requestId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityItem {\n");

		sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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
