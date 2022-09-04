package qhv.alex.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qhv.alex.spring.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
