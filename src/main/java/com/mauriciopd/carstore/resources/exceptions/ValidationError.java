package com.mauriciopd.carstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError{
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public static final class Builder {
		private Long timestamp;
		private Integer status;
		private String error;
		private String message;
		private String path;
		
		public static Builder newBuilder() {
			return new Builder();
		}
		
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

		public ValidationError build() {
			ValidationError validationError = new ValidationError();
			validationError.setTimestamp(timestamp);
			validationError.setError(error);
			validationError.setMessage(message);
			validationError.setStatus(status);
			validationError.setPath(path);
			return validationError;
		}
	}
	
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
}
