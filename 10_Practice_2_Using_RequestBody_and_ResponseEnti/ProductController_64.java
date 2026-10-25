package com.example.demo.controller;
import com.example.demo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/products")
public class ProductController {
// Internal simulated list matrix repository for holding product resources
private final List<Product> productList = new ArrayList<>();
private long currentId = 1;
public ProductController() {
// Seeding standard initial data records
productList.add(new Product(currentId++, "Laptop", 75000.00));
productList.add(new Product(currentId++, "Smartphone", 25000.00));
}
// READ operation - Fetch all products with ResponseEntity
@GetMapping
public ResponseEntity<List<Product>> getAllProducts() {
return new ResponseEntity<>(productList, HttpStatus.OK);
}
// READ operation - Fetch product by ID with ResponseEntity (Handling Not Found)
@GetMapping("/{id}")
public ResponseEntity<?> getProductById(@PathVariable Long id) {
Optional<Product> productOpt = productList.stream()
.filter(p -> p.getId().equals(id))
.findFirst();
if (productOpt.isPresent()) {
return new ResponseEntity<>(productOpt.get(), HttpStatus.OK);
} else {
return new ResponseEntity<>("Product with ID " + id + " not found.", HttpStatus.NOT_FOUND);
}
}
// CREATE operation - Using @RequestBody and ResponseEntity
@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
newProduct.setId(currentId++);
productList.add(newProduct);
// Returning HTTP 201 Created alongside the newly processed resource object
return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
}
// UPDATE operation - Using @RequestBody (Handling Context Matches)
@PutMapping("/{id}")
public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product updatedProductData) {
Optional<Product> productOpt = productList.stream()
.filter(p -> p.getId().equals(id))
.findFirst();
if (productOpt.isPresent()) {
Product existingProduct = productOpt.get();
existingProduct.setName(updatedProductData.getName());
existingProduct.setPrice(updatedProductData.getPrice());
return new ResponseEntity<>(existingProduct, HttpStatus.OK);
} else {
return new ResponseEntity<>("Failed to update: Product ID " + id + " does not exist.", HttpStatus.NOT_FOUND);
}
}
// DELETE operation - Returning explicit response status contexts
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
boolean removed = productList.removeIf(p -> p.getId().equals(id));
if (removed) {
return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
} else {
return new ResponseEntity<>("Cannot delete: Product ID " + id + " not found.", HttpStatus.NOT_FOUND);
}
}
}
