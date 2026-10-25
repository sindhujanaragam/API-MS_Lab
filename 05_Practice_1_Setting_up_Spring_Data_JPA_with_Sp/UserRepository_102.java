package com.example.demo.repository;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository // Declares a dedicated abstract data manipulation persistence bean component route
public interface UserRepository extends JpaRepository<User, Long> {
// Standard CRUD abstractions (save, findAll, findById, deleteById) are extended implicitly
}
