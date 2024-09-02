package ar.com.jics.springsec.controller;

import ar.com.jics.springsec.model.Product;
import ar.com.jics.springsec.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping("/")
    public ResponseEntity<String> saveProduct(Product product){
        if(service.saveProduct(product)){
            return ResponseEntity.status(HttpStatus.CREATED).body("Product successfully created");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = service.getProductById(id);
        if(id!= null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id,
                                                @RequestBody Product newProd){
        if(service.editProduct(id, newProd)){
            return ResponseEntity.status(HttpStatus.OK).body("Product successfully updated");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product");
        }
    }
}
