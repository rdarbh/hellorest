package com.ravi.potter.services;

import javax.ws.rs.core.Response;

public interface HelloRest {
	Response isEven(Long number);
	Response sayHi(String name);
	Response hookMeUpWithFabio(String name);
	Response postToSeeIfIamLuke(String name);
}
