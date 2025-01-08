package com.tcs.dms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tcs.dms.dto.DocumentDto;
import com.tcs.dms.entity.Document;
import com.tcs.dms.exception.ResourceNotFoundException;
import com.tcs.dms.mapper.DocumentMapper;
import com.tcs.dms.repository.DocumentRepository;
import com.tcs.dms.service.DocumentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	@Override
	public DocumentDto createDocument(DocumentDto documentDto) {

		Document document = DocumentMapper.mapToDocument(documentDto);
		Document savedDocument = documentRepository.save(document);

		return DocumentMapper.mapToDocumentDto(savedDocument);
	}

	@Override
	public DocumentDto getDocumentById(Long documentId) {

		Document document = documentRepository.findById(documentId).orElseThrow(
				() -> new ResourceNotFoundException("Document does not exists with give id : " + documentId));
		return DocumentMapper.mapToDocumentDto(document);
	}

	@Override
	public List<DocumentDto> getAllDocuments() {
		List<Document> documents = documentRepository.findAll();
		return documents.stream().map((document) -> DocumentMapper.mapToDocumentDto(document))
				.collect(Collectors.toList());
	}

	@Override
	public DocumentDto updateDocument(Long documentId, DocumentDto updatedDocument) {

		Document document = documentRepository.findById(documentId).orElseThrow(
				() -> new ResourceNotFoundException("Document does not exists with give id : " + documentId));

		document.setDocumentTitle(updatedDocument.getDocumentTitle());
		document.setAuthor(updatedDocument.getAuthor());
		document.setLanguage(updatedDocument.getLanguage());
		Document updatedDocumentObj = documentRepository.save(document);

		return DocumentMapper.mapToDocumentDto(updatedDocumentObj);
	}

	@Override
	public void deleteDocument(Long documentId) {
		Document document = documentRepository.findById(documentId).orElseThrow(
				() -> new ResourceNotFoundException("Document does not exists with given id : " + documentId));

		documentRepository.delete(document);

	}

}
