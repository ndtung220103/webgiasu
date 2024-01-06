package com.webgiasu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webgiasu.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Long>{

}
