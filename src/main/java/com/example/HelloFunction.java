package com.example;

import com.example.model.AccountInfo;
import com.example.model.Greeting;
import com.example.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication

public class HelloFunction {
    public static void main(String [] args) throws Exception{
        SpringApplication.run(HelloFunction.class, args);
    }

    @Bean
    public Function<User, Greeting> hello(){
        return user -> new Greeting("Welcome, "+ user.getUserName());
    }

    @Bean
    public Function<AccountInfo,Greeting> balanceDisplay(){
       return accountInfo -> new Greeting("Balance" + calculateBalance(accountInfo));
    }

    private String calculateBalance(AccountInfo accountInfo) {
        if(accountInfo.getCredit() != 0){
            accountInfo.setBalance(accountInfo.getBalance()  + accountInfo.getCredit());
        }
        if(accountInfo.getDebit()!= 0){
            accountInfo.setBalance(accountInfo.getBalance() - accountInfo.getDebit());
        }
        return String.valueOf(accountInfo.getBalance());
    }
}
