package com.tcs.dms.mapper;

import com.tcs.dms.dto.DocumentDto;
import com.tcs.dms.entity.Document;

public class DocumentMapper {

	public static DocumentDto mapToDocumentDto(Document document) {
		return new DocumentDto(document.getId(), document.getDocumentTitle(), document.getAuthor(),
				document.getLanguage());
	}

	public static Document mapToDocument(DocumentDto documentDto) {
		return new Document(
				documentDto.getId(),
				documentDto.getDocumentTitle(),
				documentDto.getAuthor(),
				documentDto.getLanguage()
				);
	}

}
