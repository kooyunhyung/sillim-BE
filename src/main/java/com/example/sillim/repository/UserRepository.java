package com.example.sillim.repository;

import com.example.sillim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.userEmail = :#{#userParam.userEmail} AND u.userPassword = :#{#userParam.userPassword}")
    Optional<User> findByLogin(@Param("userParam") User userParam);


    Optional<User> findById(Integer id);

    void deleteById(Integer id);

    @Transactional
    default void updateUser(int id, User userParam) {
        findById(id).ifPresent(findUser -> {
            findUser.setUserEmail(userParam.getUserEmail());
            findUser.setUserPassword(userParam.getUserPassword());
            findUser.setUserName(userParam.getUserName());
            findUser.setUserSex((userParam.getUserSex()));
            findUser.setUserPhone(userParam.getUserPhone());
        });

    }
}
