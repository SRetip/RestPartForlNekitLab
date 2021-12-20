package com.example.demo.controller;


import com.example.demo.dto.BalanceDto;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.HzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kazinich")
public class MainController {
    private final UserRepository userRepository;
    private final HzService hzService;

    @Autowired
    public MainController(UserRepository userRepository, HzService hzService) {
        this.userRepository = userRepository;
        this.hzService = hzService;
    }


    @PostMapping(path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody UserDto userDto) {
        User user = new User();
        if (!hzService.checkPassword(user.getPassword()))
            return null;
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setBalance(0d);
        return userRepository.save(user);
    }


    @PostMapping(path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody UserDto userDto) {
        return userRepository.findUserByLoginAndPassword(userDto.getLogin(), userDto.getPassword());
    }

    @PostMapping(path = "/increaseBalance",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User increaseBalance(@RequestBody BalanceDto balanceDto) {
        double sum = balanceDto.getBalance() + balanceDto.getCount();
        User user = userRepository.findUserByLogin(balanceDto.getLogin());
        user.setBalance(sum);
        return userRepository.save(user);
    }

    @PostMapping(path = "/decreaseBalance",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User decreaseBalance(@RequestBody BalanceDto balanceDto) {
        double sum = balanceDto.getBalance() - balanceDto.getCount();
        User user = userRepository.findUserByLogin(balanceDto.getLogin());
        user.setBalance(sum);
        return userRepository.save(user);
    }
}
