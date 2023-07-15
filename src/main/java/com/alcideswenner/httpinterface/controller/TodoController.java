package com.alcideswenner.httpinterface.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alcideswenner.httpinterface.annotations.RegisterLog;
import com.alcideswenner.httpinterface.dto.Todo;
import com.alcideswenner.httpinterface.service.TodoClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/todos")
@RequiredArgsConstructor
@RegisterLog
public class TodoController {

    private final TodoClient todoClient;

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoClient.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        System.out.println("testando tag git");
        return ResponseEntity.ok(todoClient.findById(id));
    }

}
