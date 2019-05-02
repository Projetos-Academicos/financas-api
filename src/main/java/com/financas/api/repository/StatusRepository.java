package com.financas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.api.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
