package com.ra.controller.admin;

import com.ra.model.dto.product.ProductDTO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.category.CategoryService;
import com.ra.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private final CategoryService categoryService;
    private final ProductService productService;
    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "admin/product/index";
    }

    @GetMapping("/add")
    public String add(Model model, ProductDTO productDTO){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product",productDTO);
        model.addAttribute("categories",categories);
        return "admin/product/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute ProductDTO productDTO){
        if(productService.create(productDTO)){
            return "admin/product/index";
        }
        return "admin/product/add";
    }
}
