package br.com.idtrust.sdk.icontrato.model.assembler;

public interface Assembler<T, U> {

    U assembly(T obj);

    T convert(U obj);

}
