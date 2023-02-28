package com.itc.hms.repository;

import com.itc.hms.entity.LogsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsDetailsRepository extends JpaRepository<LogsDetails, Integer> {

}
