package pl.krepam.Game;


import java.lang.management.ManagementFactory;
import java.sql.Date;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserApi {
	
	private UserManager userManager;

	@Autowired
	public UserApi(UserManager userManager) {
		this.userManager = userManager;
	}
	
	@GetMapping("/login")
	public Cookie login(@RequestParam String name, @RequestParam String passwd) {
		Long usr = userManager.getUserRepo().findByname(name);
		System.out.println(usr);
		if(userManager.getUserRepo().existsByname(name) && userManager.getUserRepo().existsBypasswd(passwd))	return new Cookie("UserId", userManager.getUserRepo().findByname(name).toString());
		else	return new Cookie("UserId", "Error");
	}
	
	@PostMapping("/register")
	public Boolean register(@RequestParam String name, @RequestParam String passwd) {
		if(name.length()>4 && name.length()<11 && passwd.length()>4 && passwd.length()<11 && !userManager.getUserRepo().existsByname(name)) {
			userManager.getUserRepo().save(new User(name,passwd));
			return true;
		}
		else return false;
	}
	
	@GetMapping("")
	public Cookie page() {
		Long a = System.currentTimeMillis();
		return new Cookie("VisitorId", a.toString());
	}
	
	/*
	@PostMapping("/game")
	public String game(@RequestParam String move) {
		
		//sprawdzenie jaki to uzytkownik i ktora to gra
		
		
		if(move.length()==5) {
			if()
		}
		else if(move.equals("0-0")) {
			
		}
		else	return "Wrong";
	}
	*/
}
