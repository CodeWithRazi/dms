package com.tcs.dms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dms.dto.DocumentDto;
import com.tcs.dms.service.DocumentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/document")
public class DocumentController {

	private DocumentService documentService;

	@PostMapping
	public ResponseEntity<DocumentDto> createDocument(@RequestBody DocumentDto documentDto) {
		DocumentDto savedDocument = documentService.createDocument(documentDto);
		return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<DocumentDto> getDocumentById(@PathVariable("id") Long documentId) {
		DocumentDto documentDto = documentService.getDocumentById(documentId);
		return ResponseEntity.ok(documentDto);
	}

	@GetMapping
	public ResponseEntity<List<DocumentDto>> getAllDocuments() {
		List<DocumentDto> documents = documentService.getAllDocuments();
		return ResponseEntity.ok(documents);
	}

	@PutMapping("{id}")
	public ResponseEntity<DocumentDto> updateDocument(@PathVariable("id") Long documentId,
			@RequestBody DocumentDto updatedDocument) {
		DocumentDto documentDto = documentService.updateDocument(documentId, updatedDocument);
		return ResponseEntity.ok(documentDto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDocument(@PathVariable("id") Long documentId){
		documentService.deleteDocument(documentId);
		
		return ResponseEntity.ok("Document deleted successfully!.");
	}

}
