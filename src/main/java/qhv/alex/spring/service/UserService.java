package qhv.alex.spring.service;

import qhv.alex.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User create(User user);

    User update(User user);

    boolean delete(Long id);
}
