package ru.yandex.incoming34.SpringHomeWork7.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.SpringHomeWork7.entities.Authority;

@Repository
public interface AuthorityRepo extends CrudRepository<Authority, Long>{

}
