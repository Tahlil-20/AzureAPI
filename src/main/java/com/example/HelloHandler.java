package com.example;

import com.example.model.AccountInfo;
import com.example.model.Greeting;
import com.example.model.User;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class HelloHandler extends AzureSpringBootRequestHandler<User, Greeting> {

    @FunctionName("hello")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        context.getLogger().info("Greeting user name :" + request.getBody().get().getUserName());
        return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(request.getBody().get(), context)).header("Content-Type", "application/json").build();
    }

    //Function Name . Http Post method, take input object, do processing and return the output.
    //
}