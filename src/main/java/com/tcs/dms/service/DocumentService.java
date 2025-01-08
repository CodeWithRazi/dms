package com.tcs.dms.service;

import java.util.List;

import com.tcs.dms.dto.DocumentDto;

public interface DocumentService {

	DocumentDto createDocument(DocumentDto documentDto);

	DocumentDto getDocumentById(Long documentId);

	List<DocumentDto> getAllDocuments();

	DocumentDto updateDocument(Long documentId, DocumentDto updatedDocument);
	
	void deleteDocument(Long documentId);

}
