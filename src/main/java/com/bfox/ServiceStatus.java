package com.bfox;

import io.activej.promise.Promise;
import io.activej.inject.annotation.Provides;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;

import static io.activej.http.HttpMethod.GET;
import static io.activej.http.HttpMethod.POST;

public class ServiceStatus extends HttpServerLauncher {

    @Provides
    AsyncServlet servlet() {
    	return RoutingServlet.create()
    			.map(GET, "/get/all", request -> {
					
					return HttpResponse.ok200()
							.withJson(toJsonString("Hello World !"));
				})
    			.map(GET, "/get/es", request -> {
    				return HttpResponse.ok200()
							.withJson(toJsonString("Hello World !"));
    			});
    }
    
    public String toJsonString(Object params)
    {
    	String returnedVal = "";
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			returnedVal = mapper.writeValueAsString(params);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return returnedVal;
    }
    public static void main(String[] args) throws Exception {
        Launcher launcher = new ServiceStatus();
        launcher.launch(args);
    }
}
