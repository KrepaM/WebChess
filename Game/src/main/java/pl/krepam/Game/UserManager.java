package pl.krepam.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
	
	private UserRepo userRepo;

	public UserRepo getUserRepo() {
		return userRepo;
	}
	
	@Autowired
	public UserManager(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
}
