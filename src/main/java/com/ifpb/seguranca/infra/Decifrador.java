package com.ifpb.seguranca.infra;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decifrador {

    public byte[] decifra(PrivateKey chavePrivada, 
            byte[] textoCifrado, byte[] chaveCifrada) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException {

        byte[] textoDecifrado = null;
        
        // Decifrando a chave simétrica com a chave privada
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.DECRYPT_MODE, chavePrivada);
        byte[] chaveDecifrada = rsa.doFinal(chaveCifrada);
        
        // Decifrando o texto com a chave simétrica decifrada
        Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
        aes.init(Cipher.DECRYPT_MODE, new SecretKeySpec(
                chaveDecifrada, "AES"), ivspec);
        textoDecifrado = aes.doFinal(textoCifrado);
        
        return textoDecifrado;

    }

}
