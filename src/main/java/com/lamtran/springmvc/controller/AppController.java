package com.lamtran.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lamtran.springmvc.model.Product;
import com.lamtran.springmvc.model.UserProfile;
import com.lamtran.springmvc.service.ProductService;
import com.lamtran.springmvc.service.UserProfileService;
import com.lamtran.springmvc.service.UserService;
import com.lamtran.springmvc.model.User;
 
 
 
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
	
	@RequestMapping(value = { "/edit-product-{proID}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int proID, ModelMap model) {
		Product product = proService.getProductById(proID);
		model.addAttribute("product", product);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addProduct";
	}
	@RequestMapping(value = { "/edit-product-{proID}" }, method = RequestMethod.POST)
	public String updateProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable String proID) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		proService.updateProduct(product);

		model.addAttribute("message", "Product " + product.getProName() + " " + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "addProduct";
	}

	
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int proID) {
		userService.deleteUserById(proID);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}
	
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.getAllUserProfile();
    }
     
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/product";  
        }
    }
 
    @RequestMapping(value = { "/user-details-{username}"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model, @PathVariable String username) {
		User user = userService.getByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("loggedinuser", getPrincipal());
		return "user-details";
	}
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
 
 
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
     
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
 
 
}