package com.xgroup.unknown.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("furkan")
    public ResponseEntity<String> getUsersByGroupName() {
        return ResponseEntity.ok("furkan");
    }
}
