/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.c.project4.project4;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
}