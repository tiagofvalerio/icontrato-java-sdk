package br.com.idtrust.sdk.icontrato.model.assembler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import br.com.idtrust.sdk.icontrato.model.Document;
import br.com.idtrust.sdk.icontrato.ws.client.dto.DocumentDTO;

public class DocumentAssembler implements Assembler<Document, DocumentDTO> {

    @Override
    public DocumentDTO assembly(Document document) {

        try {
            DocumentDTO documentDTO = new DocumentDTO();

            // documentDTO.setEmailOwner(document.getEmailOwner());
            documentDTO.setFileName(document.getFileName());

            documentDTO.setDocumentBytes(
                    new byte[document.getDocumentStream().available()]);

            document.getDocumentStream().read(documentDTO.getDocumentBytes());
            documentDTO.setDocumentBytes(
                    Base64.getEncoder().encode(documentDTO.getDocumentBytes()));
            documentDTO.setDocumentType(DocumentDTO.DocumentType.PDF);

            return documentDTO;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Document convert(DocumentDTO documentDTO) {
        Document document = new Document()
                .withDocumentStream(new ByteArrayInputStream(
                        documentDTO.getDocumentBytes()))
                // .withEmailOwner(documentDTO.getEmailOwner())
                .withfileName(documentDTO.getFileName());

        return document;
    }

}
