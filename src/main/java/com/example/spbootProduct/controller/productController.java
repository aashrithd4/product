package com.example.spbootProduct.controller;

import com.example.spbootProduct.model.product;
import com.example.spbootProduct.service.productService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class productController {
    @Autowired
    productService productService;

    @GetMapping("/product/all")
    public ResponseEntity<List<product>>findAll(){
        List<product> productList=productService.findAll();
        return new ResponseEntity<>(productList,null, HttpStatus.OK);
    }
    @PostMapping("/product/all")
    public ResponseEntity create(@Valid @RequestBody product product){
        return ResponseEntity.ok(productService.save(product));
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<product> findById(@PathVariable int id){
        Optional<product> stock=productService.findById(id);
        if(!stock.isPresent()){
            log.error("Id"+id+"is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<product>update(@PathVariable int id,@Valid @RequestBody product product){
        Optional<product> stock=productService.findById(id);
        if (!stock.isPresent())
        {
            log.error("Id"+id+"is not present");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.save(product));
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(!productService.findById(id).isPresent()){
            log.error("Id"+id+"is not present");
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
