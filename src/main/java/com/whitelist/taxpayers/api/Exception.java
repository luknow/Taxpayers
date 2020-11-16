package com.whitelist.taxpayers.api;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Exception
 */
@Validated
public class Exception {
	
	@JsonProperty("message")
	private String message = null;

	@JsonProperty("code")
	private String code = null;

	public Exception(String msg) {
		// TODO Auto-generated constructor stub
	}

	public Exception message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@ApiModelProperty(example = "error message", required = true, value = "")
	@NotNull

	@Size(max = 256)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@ApiModelProperty(example = "WL-101", required = true, value = "")
	@NotNull

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Exception exception = (Exception) o;
		return Objects.equals(this.message, exception.message) && Objects.equals(this.code, exception.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, code);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Exception {\n");

		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
