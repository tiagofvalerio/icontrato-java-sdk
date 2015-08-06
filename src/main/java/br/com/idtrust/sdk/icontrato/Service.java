package br.com.idtrust.sdk.icontrato;

import br.com.idtrust.sdk.icontrato.exception.SDKException;
import br.com.idtrust.sdk.icontrato.model.DocumentBuilder;

public interface Service {

    public void SendDocument(DocumentBuilder documentPackage)
            throws SDKException;

}
