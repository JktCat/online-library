package com.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.UserService;

@Controller
public class UserController {

 
    private UserService userService;  
    private BookService bookService;
    
	public UserController(UserService userService, BookService bookService) {
		super();
		this.userService = userService;
		this.bookService = bookService;
	}


	@GetMapping("/account/login")
    public String getLoginPage() {
        return "login";
    }
    

    @GetMapping("account/sign-up")
    public String getSignUpPage(Model model) {
    	User user = new User();
		model.addAttribute("user", user);
        return "sign_up";
    }
    
    @PostMapping("/account/sign-up")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
    	
        String username = user.getUsername();
        User existingUser = userService.findByUserName(username);
        if (existingUser != null) {
            model.addAttribute("error", true);
            return "sign_up";
        } else {
            userService.saveUser(user);
            return "redirect:/account/login";
        }
    }

    @GetMapping("/home")
    public String getHomePage(HttpSession session, Model model) {
    	User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            String fullName = loggedInUser.getFullname();   
        }
        model.addAttribute("books", bookService.getAllBooks());
        return "home_page";
    } 

    @GetMapping("/user/home")
    public String getUserHomePage() {
        return "user_home";
    }
    
//    private boolean isValidLogin(String username, String password) {
//        return userService.existsByUsernameAndPassword(username, password);
//    }
    
    @PostMapping("/account/login")
    public String loginUser(@RequestParam("username") String username,
    		@RequestParam("password") String password, HttpSession session,Model model) {
        
    	User user = userService.findByUserName(username);
        if (user != null && user.getPassword().equals(password)) {
        	 session.setAttribute("loggedInUser", user);
//             model.addAttribute("fullname_loggedIn", user.getFullname());
            if(user.getRole().equals("USER")) {
            	return "redirect:/home";
            }else {
            	return "redirect:/books";
            }
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "login";
        }
    }
    
    @GetMapping("/account/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}

