package com.ifpb.seguranca.infra;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.RSAKeyGenParameterSpec;

public class GeradorChave {

    private static final int RSAKEYSIZE = 1024;

    public void geraParChaves(File chavePublica, File chavePrivada)
            throws IOException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            CertificateException, KeyStoreException {

        // Gerador das chaves em formato RSA
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(new RSAKeyGenParameterSpec(RSAKEYSIZE,
                RSAKeyGenParameterSpec.F4));
        KeyPair kpr = kpg.generateKeyPair();

        // Chave privada
        PrivateKey priv = kpr.getPrivate();

        // Chave publica
        PublicKey pub = kpr.getPublic();

        //-- Gravando a chave pública em formato serializado
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(chavePublica));
        oos.writeObject(pub);
        oos.close();

        //-- Gravando a chave privada em formato serializado
        oos = new ObjectOutputStream(new FileOutputStream(chavePrivada));
        oos.writeObject(priv);
        oos.close();

    }

}
