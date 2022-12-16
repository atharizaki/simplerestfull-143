/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.c.project4.project4;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author athar
 */
@ControllerAdvice
@RestController
public class ProductServiceController {
    private static final Map<String, Product> productRepo = new HashMap<>();
    static {
      //Variabel Honey
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      
      
        
      productRepo.put(honey.getId(), honey);
      
      //Variabel Almond
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      
   }
    
    //Method GET
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   
   //Method POST
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
      // kondisi if else jika ada id product yang sama pada method POST
      if(productRepo.containsKey(product.getId())){ 
            return new ResponseEntity<>("ID Product Cannot be the Same, please check again", HttpStatus.OK);
        }
      else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created Successfully", HttpStatus.CREATED);
        }
   }
   
   //Method PUT
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
       //kondisi jika Id produk yang ingin diupdate tidak ada
      if(!productRepo.containsKey(id))throw new ProductNotFoundException();
      productRepo.remove(id);
      product.setId(id);
      productRepo.put(id, product);
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }   
   
   //Method DELETE
    
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      productRepo.remove(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
    
}