package com.whitelist.taxpayers.api;

import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntityListResponse
 */
@Validated
public class EntityListResponse {
	
	@JsonProperty("exception")
	private Exception exception = null;

	@JsonProperty("result")
	private EntityList result = null;

	public EntityListResponse exception(Exception exception) {
		this.exception = exception;
		return this;
	}

	/**
	 * Get exception
	 * 
	 * @return exception
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public EntityListResponse result(EntityList result) {
		this.result = result;
		return this;
	}

	/**
	 * Get result
	 * 
	 * @return result
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public EntityList getResult() {
		return result;
	}

	public void setResult(EntityList result) {
		this.result = result;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EntityListResponse entityListResponse = (EntityListResponse) o;
		return Objects.equals(this.exception, entityListResponse.exception)
				&& Objects.equals(this.result, entityListResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(exception, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityListResponse {\n");

		sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
		sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
