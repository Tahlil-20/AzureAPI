package com.example;

import com.example.model.AccountInfo;
import com.example.model.Greeting;
import com.example.model.User;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class BalanceDisplaHandler extends AzureSpringBootRequestHandler<AccountInfo, Greeting> {
    @FunctionName("balanceDisplay")
    public HttpResponseMessage execute(@HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST},
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<AccountInfo>> request,
                                       ExecutionContext context) {
        context.getLogger().info("Instide the new Method");
        return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(request.getBody().get(), context)).header("Content-Type", "application/json").build();
    }
}
