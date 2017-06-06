package com.lamtran.springmvc.controller;

import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lamtran.springmvc.model.Product;
import com.lamtran.springmvc.model.UserProfile;
import com.lamtran.springmvc.service.ProductService;
import com.lamtran.springmvc.service.UserProfileService;
import com.lamtran.springmvc.service.UserService;
 
 
 
@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
 
	@Autowired
    ProductService proService; 
	
    @Autowired
    UserService userService;
    
    @Autowired
    UserProfileService userProfileService;
     
    @Autowired
    MessageSource messageSource;
 
    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
     
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
     
     
    @RequestMapping(value = { "/", "/product" }, method = RequestMethod.GET)
	public String listProducts(ModelMap model) {
            List<Product> list = proService.getAllProduct();
            model.addAttribute("list", list);
            model.addAttribute("loggedinuser", getPrincipal());
            return "product";
	}
 

	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addProduct";
	}

	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String saveEmployee(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("message", "add product has failed");
			return "addProduct";
		}
	
		proService.saveProduct(product);

		model.addAttribute("message", "Product	 " + product.getProName() + " added successfully");
		return "addProduct";
	}
	
  
    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.getAllUserProfile();
    }
     
    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/product";  
        }
    }
 
 
 
    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    @SuppressWarnings("unused")
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
     
    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
 
 
}