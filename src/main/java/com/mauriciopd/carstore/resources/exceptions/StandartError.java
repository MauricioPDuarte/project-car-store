package com.mauriciopd.carstore.resources.exceptions;

import java.io.Serializable;
import javax.annotation.Generated;

public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	@Generated("SparkTools")
	private StandartError(Builder builder) {
		this.timestamp = builder.timestamp;
		this.status = builder.status;
		this.error = builder.error;
		this.message = builder.message;
		this.path = builder.path;
	}

	public StandartError() {
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	@Generated("SparkTools")
	public static final class Builder {
		private Long timestamp;
		private Integer status;
		private String error;
		private String message;
		private String path;

		private Builder() {
		}

		public Builder withTimestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withStatus(Integer status) {
			this.status = status;
			return this;
		}

		public Builder withError(String error) {
			this.error = error;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public Builder withPath(String path) {
			this.path = path;
			return this;
		}

		public StandartError build() {
			return new StandartError(this);
		}
	}

}
