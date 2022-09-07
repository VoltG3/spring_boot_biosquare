package com.data.biosquare.repository;

import com.data.biosquare.model.Biosquare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiosquareRepository extends JpaRepository<Biosquare, Long> {

}
