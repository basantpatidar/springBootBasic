package com.spring.boot.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.boot.app.entity.UserEntity;

@Repository
public interface SignupRepository extends JpaRepository<UserEntity, Long>  {
	
	@Query(value="SELECT * FROM user_entity p WHERE LOWER(p.username) = LOWER(?1)", nativeQuery=true)
    public List<UserEntity> findByUsername(@Param("username") String username);

	@Query(value="SELECT p FROM UserEntity p WHERE LOWER(p.username) = LOWER(?1)")
    public List<UserEntity> findByUsername1(@Param("username") String username);
	
}


