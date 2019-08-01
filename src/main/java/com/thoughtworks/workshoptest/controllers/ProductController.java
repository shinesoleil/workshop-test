package com.thoughtworks.workshoptest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/products")
public class ProductController {

  @GetMapping
  public ResponseEntity getAll() {
    return ResponseEntity.ok().body(new ArrayList<>());
  }
}
