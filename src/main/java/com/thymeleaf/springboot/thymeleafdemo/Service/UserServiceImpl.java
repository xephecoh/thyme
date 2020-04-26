package com.thymeleaf.springboot.thymeleafdemo.Service;

import com.thymeleaf.springboot.thymeleafdemo.DAO.PaymentUsersRepository;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    PaymentUsersRepository repository;

    @Autowired
    public UserServiceImpl (PaymentUsersRepository repository){
        this.repository=repository;
    }

    @Override
    public List<PaymentUser> findAll() {
        return repository.findAll();
    }

    @Override
    public PaymentUser findById(int id) {
        Optional<PaymentUser> userOptional = repository.findById(id);
        PaymentUser user=null;
        if(userOptional.isPresent()){
            user =userOptional.get();
        }else{
            throw new RuntimeException("no user with such id" + id);
        }
        return user;
    }

    @Override
    public void save(PaymentUser user) {
    repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
