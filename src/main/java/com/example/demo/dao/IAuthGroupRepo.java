package com.example.demo.dao;

import com.example.demo.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthGroupRepo extends JpaRepository<AuthGroup,Long> {
	List<AuthGroup> findByaUsername(String username);
}