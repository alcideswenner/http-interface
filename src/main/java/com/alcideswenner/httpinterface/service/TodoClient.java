package com.alcideswenner.httpinterface.service;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import com.alcideswenner.httpinterface.dto.Todo;

public interface TodoClient {

    @GetExchange(value = "/todos")
    public List<Todo> findAll();

    @GetExchange(value = "todos/{id}")
    public Todo findById(@PathVariable Integer id);
}
