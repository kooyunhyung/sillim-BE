package com.example.sillim.service;

import com.example.sillim.entity.User;
import com.example.sillim.repository.UserRepository;
import com.example.sillim.util.Sha256;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByLogin(User userParam) throws NoSuchAlgorithmException {
        // password는 해싱을 하여 변환
        Sha256 sha256 = new Sha256();
        userParam.setUserPassword(sha256.encrypt(userParam.getUserPassword()));

        Optional<User> user = userRepository.findByLogin(userParam);
        return user;
    }

    public void save(User userParam) throws NoSuchAlgorithmException {
        // password는 해싱을 하여 변환
        Sha256 sha256 = new Sha256();
        userParam.setUserPassword(sha256.encrypt(userParam.getUserPassword()));

        userRepository.save(userParam);
    }

    public Optional<List<User>> findAll() {
        List<User> users = userRepository.findAll();
        return Optional.of(users);
    }

    public Optional<User> findOne(int id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public void update(int id, User userParam) throws NoSuchAlgorithmException {
        // password는 해싱을 하여 변환
        Sha256 sha256 = new Sha256();
        userParam.setUserPassword(sha256.encrypt(userParam.getUserPassword()));

        userRepository.updateUser(id, userParam);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }




}
