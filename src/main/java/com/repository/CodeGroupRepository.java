package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Code;
import com.entity.CodeGroup;

public interface CodeGroupRepository extends JpaRepository<CodeGroup, String>{}
