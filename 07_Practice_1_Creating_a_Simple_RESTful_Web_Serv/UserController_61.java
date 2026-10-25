package com.example.demo.controller;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/users")
public class UserController {
// Internal simulated list matrix repository for holding user resources
private final List<User> userList = new ArrayList<>();
private long currentId = 1;
public UserController() {
// Initializing mock static user index records for development checking
userList.add(new User(currentId++, "Rahul Kumar", "rahul@aditya.edu.in"));
userList.add(new User(currentId++, "Ananya Sen", "ananya@aditya.edu.in"));
}
// 1. READ ALL - HTTP GET
@GetMapping
public List<User> getAllUsers() {
return userList;
}
// 2. READ BY ID - HTTP GET
@GetMapping("/{id}")
public User getUserById(@PathVariable Long id) {
return userList.stream()
.filter(user -> user.getId().equals(id))
.findFirst()
.orElseThrow(() -> new RuntimeException("User Record Index ID: " + id + " not found!"));
}
// 3. CREATE - HTTP POST
@PostMapping
public User createUser(@RequestBody User newUser) {
newUser.setId(currentId++);
userList.add(newUser);
return newUser;
}
// 4. UPDATE - HTTP PUT
@PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User updatedUserData) {
User existingUser = userList.stream()
.filter(user -> user.getId().equals(id))
.findFirst()
.orElseThrow(() -> new RuntimeException("User Record Index ID: " + id + " not found!"));
existingUser.setName(updatedUserData.getName());
existingUser.setEmail(updatedUserData.getEmail());
return existingUser;
}
// 5. DELETE - HTTP DELETE
@DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
User existingUser = userList.stream()
.filter(user -> user.getId().equals(id))
.findFirst()
.orElseThrow(() -> new RuntimeException("User Record Index ID: " + id + " not found!"));
userList.remove(existingUser);
return "User record matching Index identifier ID " + id + " has been completely removed.";
}
}
