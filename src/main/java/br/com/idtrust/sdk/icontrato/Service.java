package br.com.idtrust.sdk.icontrato;

import br.com.idtrust.sdk.icontrato.exception.SDKException;
import br.com.idtrust.sdk.icontrato.model.DocumentPackage;

public interface Service {

    public void SendDocument(DocumentPackage documentPackage)
            throws SDKException;

}
