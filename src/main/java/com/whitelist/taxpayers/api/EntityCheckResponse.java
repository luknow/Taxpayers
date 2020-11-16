package com.whitelist.taxpayers.api;

import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntityCheckResponse
 */
@Validated
public class EntityCheckResponse {
	
	@JsonProperty("exception")
	private Exception exception = null;

	@JsonProperty("result")
	private EntityCheck result = null;

	public EntityCheckResponse exception(Exception exception) {
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

	public EntityCheckResponse result(EntityCheck result) {
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

	public EntityCheck getResult() {
		return result;
	}

	public void setResult(EntityCheck result) {
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
		EntityCheckResponse entityCheckResponse = (EntityCheckResponse) o;
		return Objects.equals(this.exception, entityCheckResponse.exception)
				&& Objects.equals(this.result, entityCheckResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(exception, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityCheckResponse {\n");

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
