/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers;

/**
 *
 * @author madave91
 */
import hu.elte.pubManager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("")
    public String productList(Model model) {
        model.addAttribute("title", "Product list");
        model.addAttribute("product", productService.productTypeStartingWith("vodka"));
        return "products";
    }
}
