package com.idw.templatewebapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.idw.templatewebapp.domain.User;
import com.idw.templatewebapp.repository.UserRepository;

 /* @author avanderwoude
 */
@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/")
    @ResponseBody
    public String home() {
        //String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "Welcome";
    }
}