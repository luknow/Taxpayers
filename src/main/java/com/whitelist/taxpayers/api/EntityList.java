package com.whitelist.taxpayers.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntityList
 */
@Validated
public class EntityList {
	
	@JsonProperty("subjects")
	@Valid
	private List<Entity> subjects = null;

	@JsonProperty("requestId")
	private String requestId = null;

	private String date = null;

	public EntityList subjects(List<Entity> subjects) {
		this.subjects = subjects;
		return this;
	}

	public EntityList addSubjectsItem(Entity subjectsItem) {
		if (this.subjects == null) {
			this.subjects = new ArrayList<Entity>();
		}
		this.subjects.add(subjectsItem);
		return this;
	}

	/**
	 * Lista podmiotów
	 * 
	 * @return subjects
	 **/
	@ApiModelProperty(value = "Lista podmiotów ")
	@Valid
	public List<Entity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Entity> subjects) {
		this.subjects = subjects;
	}

	public EntityList requestId(String requestId) {
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

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EntityList entityList = (EntityList) o;
		return Objects.equals(this.subjects, entityList.subjects)
				&& Objects.equals(this.requestId, entityList.requestId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subjects, requestId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityList {\n");

		sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
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
