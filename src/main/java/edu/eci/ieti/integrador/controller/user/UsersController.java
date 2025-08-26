package edu.eci.ieti.integrador.controller.user;

import edu.eci.ieti.integrador.exception.UserNotFoundException;
import edu.eci.ieti.integrador.service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.eci.ieti.integrador.repository.user.User;
import edu.eci.ieti.integrador.repository.user.UserDto;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto user) {
        URI createdUserUri = URI.create("");
        User currentUser = this.usersService.save(new User(user));
        return ResponseEntity.created(createdUserUri).body(currentUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.usersService.all();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        User user = this.usersService.findById(id);
        if(user != null) {
            return ResponseEntity.ok(user);
        }
        throw new UserNotFoundException(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserDto input) {
        User op = this.usersService.findById(id);
        if(op != null) {
            User updatedUser = this.usersService.update(new User(input),id);
            return ResponseEntity.ok(updatedUser);
        }
        throw new UserNotFoundException(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        User currentUser = this.usersService.findById(id);
        if(currentUser != null) {
            this.usersService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        throw new UserNotFoundException(id);
    }
}
