package com.example.lab.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller("/items")
public class ItemController {

    private final List<Item> items = new ArrayList<>();

    @Get("/")
    public HttpResponse<List<Item>> getAllItems() {
        return HttpResponse.ok(items);
    }

    @Post("/")
    public HttpResponse<Item> addItem(@Body Item item) {
        items.add(item);
        return HttpResponse.created(item);
    }

    @Put("/{id}")
    public HttpResponse<Item> updateItem(@PathVariable String id, @Body Item updatedItem) {
        Optional<Item> itemOpt = items.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst();

        if (itemOpt.isPresent()) {
            Item item = itemOpt.get();
            item.setName(updatedItem.getName());
            item.setQuantity(updatedItem.getQuantity());
            return HttpResponse.ok(item);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteItem(@PathVariable String id) {
        items.removeIf(item -> item.getId().equals(id));
        return HttpResponse.noContent();
    }
}

class Item {
    private String id;
    private String name;
    private int quantity;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
