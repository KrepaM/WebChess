package pl.krepam.Game;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	/*
	@Query(value = "select name, passwd from Users where name=?1 and passwd=?2", nativeQuery = true)
	Boolean findBynameAndpasswd(String name, String passwd);
	*/
	@Query(value = "select id from Users where name=?1", nativeQuery = true)
	Long findByname(String name);
	
	Boolean existsByname(String name);
	Boolean existsBypasswd(String passwd);
}
