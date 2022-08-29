package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Code;

public interface CodeRepository extends JpaRepository<Code, String>{}
