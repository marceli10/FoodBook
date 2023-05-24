package com.example.foodbook.repository;

import com.example.foodbook.model.security.Provider;
import com.example.foodbook.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends Neo4jRepository<User, UUID> {

    @Query("OPTIONAL MATCH (u: User {email: $email, provider: $provider}) RETURN u")
    Optional<User> findUserByEmailAndProvider(String email, Provider provider);
}
