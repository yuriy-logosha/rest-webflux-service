package com.example.restwebfluxservice.repository;

import com.example.restwebfluxservice.model.IncomingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingDataRepository extends JpaRepository<IncomingData, String> {

}
