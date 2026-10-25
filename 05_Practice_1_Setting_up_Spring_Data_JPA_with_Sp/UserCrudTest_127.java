package com.example.demo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import java.util.List;
@SpringBootTest
public class UserCrudTest {
@Autowired
private UserRepository userRepository;
@Test
public void executeDatabaseCrudSequence() {
System.out.println("\n================= INITIALIZING DATA JPA TESTS =================");
// 1. CREATE OPERATION
User studentA = new User("John Doe", "john.doe@aditya.edu.in");
User studentB = new User("Alice Smith", "alice.s@aditya.edu.in");
userRepository.save(studentA);
userRepository.save(studentB);
System.out.println("[CREATE] Success! Injected persistent models inside H2 database instance context.");
// 2. READ ALL OPERATION
List<User> activeUsers = userRepository.findAll();
System.out.println("[READ ALL] Displaying existing user schema records below:");
activeUsers.forEach(System.out.println);
// 3. UPDATE OPERATION
Optional<User> foundUserOpt = userRepository.findById(1L);
if (foundUserOpt.isPresent()) {
User existingUser = foundUserOpt.get();
existingUser.setName("John Developer");
userRepository.save(existingUser);
System.out.println("[UPDATE] Success! Synchronized altered fields to record index ID: 1");
}
// Verify Update Action Result
System.out.println("[READ INDIVIDUAL] Verifying changes made to Record index ID 1:");
userRepository.findById(1L).ifPresent(System.out.println);
// 4. DELETE OPERATION
userRepository.deleteById(2L);
System.out.println("[DELETE] Terminated record row corresponding to Identifier Index ID: 2");
// Confirm Final Context Volume Status
long runtimeRecordCount = userRepository.count();
System.out.println("[COUNT] Remaining Database Row Balance Vector Total: " + runtimeRecordCount);
System.out.println("================== DATA JPA TESTS COMPLETED ==================\n");
}
}
