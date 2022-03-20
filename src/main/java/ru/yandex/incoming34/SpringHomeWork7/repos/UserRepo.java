package ru.yandex.incoming34.SpringHomeWork7.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.SpringHomeWork7.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
