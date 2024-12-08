package com.example.lab.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HomeController {

    @Get
    public HttpResponse<String> index() {
        return HttpResponse.ok("<html><body><h1>Welcome to the App</h1></body></html>")
                           .contentType("text/html");
    }
}
