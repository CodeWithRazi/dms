package com.tcs.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tcs.dms.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
