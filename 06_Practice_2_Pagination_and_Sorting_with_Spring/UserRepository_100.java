package com.example.demo.repository;
import com.example.demo.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
// Custom data fetching using manual JPQL statement with structural Sort parameter integration
@Query("SELECT u FROM User u")
List<User> findAllUsersCustomSorted(Sort sort);
}
