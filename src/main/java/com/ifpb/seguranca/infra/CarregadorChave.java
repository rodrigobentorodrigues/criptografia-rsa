package com.ifpb.seguranca.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class CarregadorChave {

    public PublicKey carregaChavePublica(File fPub) throws IOException, ClassNotFoundException {
        // Abre o arquivo onde contem a chave publica, gerada no inicio da aplicacao
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fPub));
        // Insere o conteudo do arquivo nesse objeto PublicKey
        PublicKey ret = (PublicKey) ois.readObject();
        ois.close();
        // Retorna a chave publica
        return ret;
    }

    public PrivateKey carregaChavePrivada(File fPvk) throws IOException, ClassNotFoundException {
        // Abre o arquivo onde contem a chave privada, gerada no inicio da aplicacao
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fPvk));
        // Insere o conteudo do arquivo nesse objeto PrivateKey
        PrivateKey ret = (PrivateKey) ois.readObject();
        ois.close();
        return ret;
    }
}
