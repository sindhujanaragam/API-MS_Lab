package com.example.demo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import java.util.List;
@SpringBootTest
public class UserCustomQueryTest {
@Autowired
private UserRepository userRepository;
@Test
public void testCustomQuerySortingExecution() {
System.out.println("\n--- STARTING CUSTOM @QUERY SORTING VERIFICATION TEST ---");
// Formulating dynamic Sort strategy using target field constraints in descending order
Sort descSortOrder = Sort.by(Sort.Direction.DESC, "name");
List<User> customSortedList = userRepository.findAllUsersCustomSorted(descSortOrder);
System.out.println("[@QUERY SORT] Fetching raw output mapping results directly down below:");
customSortedList.forEach(user ->
System.out.println(" -> Name: " + user.getName() + " | Email: " + user.getEmail())
);
System.out.println("--- CUSTOM @QUERY SORTING VERIFICATION TEST COMPLETED ---\n");
}
}
