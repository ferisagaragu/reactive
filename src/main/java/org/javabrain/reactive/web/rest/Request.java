package org.javabrain.reactive.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.javabrain.reactive.web.exception.BadRequestException;

import java.util.LinkedHashMap;
import java.util.List;


public class Request extends LinkedHashMap<String, Object> {

	private String badMessage;


	public Request() {
		this.badMessage = "' field not found";
	}


	public Long toLong(String key) {
		Object reqOut = this.get(key);

		if (reqOut != null) {
			return Long.valueOf(reqOut.toString());
		}

		throw new BadRequestException("'" + key + badMessage);
	}

	public String toString(String key) {
		Object reqOut = this.get(key);

		if (reqOut != null) {
			return reqOut.toString();
		}

		throw new BadRequestException("'" + key + badMessage);
	}

	public boolean toBoolean(String key) {
		Object reqOut = this.get(key);

		if (reqOut != null) {
				return reqOut.toString().equals("true");
		}

		throw new BadRequestException("'" + key + badMessage);
	}

	public List<Object> totList(String key) {
		Object reqOut = this.get(key);

		if (reqOut != null) {
			return (List<Object>) reqOut;
		}

		throw new BadRequestException("'" + key  + badMessage);
	}

	public <T> T to(Class clazz) {
		final ObjectMapper mapper = new ObjectMapper();
		return (T) mapper.convertValue(this, clazz);
	}

	@Override
	public Object get(Object key) {
		if (!this.containsKey(key)) {
			throw new BadRequestException("'" + key  + badMessage);
		}
		return super.get(key);
	}
}
