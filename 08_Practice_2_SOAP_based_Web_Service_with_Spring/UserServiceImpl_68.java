package com.example.demo.service;
import com.example.demo.model.SoapUser;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service // Annotate service with @Service
public class UserServiceImpl implements UserService {
private static final Map<Long, SoapUser> mockStorage = new HashMap<>();
static {
// Seeding database records matching lab configuration paths
mockStorage.put(1L, new SoapUser(1L, "Rahul Kumar", "rahul@aditya.edu.in"));
mockStorage.put(2L, new SoapUser(2L, "Ananya Sen", "ananya@aditya.edu.in"));
}
@Override
public SoapUser getUserById(Long id) {
return mockStorage.get(id);
}
}
