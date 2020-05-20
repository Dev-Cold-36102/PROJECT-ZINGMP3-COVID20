package com.codegym.service;

import com.codegym.model.Users;
import com.codegym.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<Users> usersList() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        Optional<Users> users = Optional.ofNullable(usersRepository.findOne(id));
        Users users1= users.get();
        return users1;
    }

    @Override
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public Users findByUserName(String username) {
        Users users = usersRepository.findUsersByUserName(username);
        return users;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users users=usersRepository.findUsersByUserName(username);
//        List<GrantedAuthority> authorities=new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(users.getRole().getAuthority()));
//        User user=new User(users.getUserName(),users.getPassword(),authorities);
//        return user;

}
