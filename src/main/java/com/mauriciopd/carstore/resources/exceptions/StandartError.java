package com.mauriciopd.carstore.resources.exceptions;

import java.io.Serializable;

public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandartError() {
	}
	
	public static final class Builder {
		private Long timestamp;
		private Integer status;
		private String error;
		private String message;
		private String path;

		private Builder() {
		}
		
		public static Builder newBuilder() {
			return new Builder();
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
			StandartError standartError = new StandartError();
			standartError.setTimestamp(timestamp);
			standartError.setError(error);
			standartError.setMessage(message);
			standartError.setStatus(status);
			standartError.setPath(path);
			return standartError;
		}
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
}
