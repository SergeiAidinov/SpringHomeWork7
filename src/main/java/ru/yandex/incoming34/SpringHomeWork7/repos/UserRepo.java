package ru.yandex.incoming34.SpringHomeWork7.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.SpringHomeWork7.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	@Query(nativeQuery = true, value = "SELECT FROM users WHERE username := userName")
	User findOneByUsername(@Param("userName") String userName);

	//List<String> findRolesOfUser(String userName);

}
