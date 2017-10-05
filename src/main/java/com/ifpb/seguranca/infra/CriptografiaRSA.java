package com.ifpb.seguranca.infra;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author rodrigobento
 */
public class CriptografiaRSA {

    private BigInteger n, d, e, p, q, z;
    private SecureRandom numeroAleatorio;
    private int bitlen = 1024;

    public CriptografiaRSA() {
        
        // Gerando os valores apartir de um bit com tamanho de 1024
        
        this.numeroAleatorio = new SecureRandom();
        
        p = BigInteger.probablePrime(bitlen, numeroAleatorio);
        q = BigInteger.probablePrime(bitlen, numeroAleatorio);
        
        this.n = p.multiply(q);
        
        this.z = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        
        this.e = new BigInteger("3");
        
        while (z.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        
        this.d = e.modInverse(z);
    }
        
    // Criptografar, utilizando (e, n) tbm conhecidos como chaves publicas
    public synchronized String criptografar(String message) {
        return (new BigInteger(message.getBytes())).modPow(e, n).toString();
    }
    
    // Descriptografar, utilizando (d, n) tbm conhecidos como chaves privadas
    public synchronized String descriptar(String message) {
        return new String((new BigInteger(message)).modPow(d, n).toByteArray());
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getM() {
        return z;
    }

    public void setM(BigInteger m) {
        this.z = m;
    }

    public SecureRandom getR() {
        return numeroAleatorio;
    }

    public void setR(SecureRandom r) {
        this.numeroAleatorio = r;
    }

    public int getBitlen() {
        return bitlen;
    }

    public void setBitlen(int bitlen) {
        this.bitlen = bitlen;
    }

}
