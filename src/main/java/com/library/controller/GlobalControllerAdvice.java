package com.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.library.entity.User;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ModelAttribute("fullname_loggedIn")
    public String addFullNameLoggedIn(HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            return ((User) loggedInUser).getFullname();
        }
        return null;
    }
	@ModelAttribute("role_loggedIn")
	public String addRoleLoggedIn(HttpSession session) {
	    Object loggedInUser = session.getAttribute("loggedInUser");
	    if (loggedInUser != null) {
	        return ((User) loggedInUser).getRole();
	    }
	    return null;
	}
	@ModelAttribute("id_loggedIn")
	public Long idLoggedIn(HttpSession session) {
	    Object loggedInUser = session.getAttribute("loggedInUser");
	    if (loggedInUser != null) {
	        return ((User) loggedInUser).getId();
	    }
	    return null;
	}

}
