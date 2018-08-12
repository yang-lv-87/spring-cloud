package com.example.endpoint;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "endpoints.person")
public class PersonEndpoint extends AbstractEndpoint<Map<String, Object>> {

	public PersonEndpoint() {
		super("person", false);
	}

	@Override
	public Map<String, Object> invoke() {
		Map<String, Object> result = new HashMap<String, Object>();
	    Timestamp dateTime = new Timestamp(System.currentTimeMillis());
	    result.put("当前时间", dateTime.toString());
	    result.put("当前时间戳", dateTime.getTime());
	    return result;
	}

}
