package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity // Designates this Java class object as a database table relation schema mapping
@Table(name = "users")
public class User {
@Id // Explicitly markers this field instance variable as the relational Primary Key component
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String email;
// Default No-Args Constructor required implicitly by the JPA Specification runtime
public User() {}
// Multi-argument field population constructor layer logic
public User(String name, String email) {
this.name = name;
this.email = email;
}
// Encapsulated field Accessors and Mutators
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
@Override
public String toString() {
return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
}
}
