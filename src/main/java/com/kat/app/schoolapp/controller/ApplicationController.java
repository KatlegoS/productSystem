package com.kat.app.schoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kat.app.schoolapp.model.Product;
import com.kat.app.schoolapp.service.ProductService;

@Controller
public class ApplicationController {
	
	@Autowired
	private  ProductService productService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Product> listProducts = productService.listAll();
	    model.addAttribute("listProducts", listProducts);
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	    return "new-product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
	    return "redirect:/";
	}	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit-product");
	    Product product = productService.get(id);
	    mav.addObject("product", product);
	    return mav;
	}
	
	
}
