package com.xcfh.util;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.security.Key;

/**
 * Created by zhangfan on 2014/10/8.
 */
public class Encrypt {
    /**
     * DES加密
     */
    public static byte[] ensecret(InputStream inputStream) {

        return secret(inputStream, Cipher.ENCRYPT_MODE);
    }

    /**
     * DES解密
     */
    public static byte[] desecret(InputStream inputStream) {

        return secret(inputStream, Cipher.DECRYPT_MODE);
    }

    /**
     * DES实现
     */
    public static byte[] secret(InputStream inputStream, int mode) {

        ObjectInputStream objectInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(Class.class.getClass().getResourceAsStream("/secret.key"));
            byteArrayOutputStream = new ByteArrayOutputStream();
            Key key = (Key)objectInputStream.readObject();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode,key);
            crypt(inputStream, byteArrayOutputStream, cipher);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) {

        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more) {
            try {
                inLength = in.read(inBytes);
                if (inLength == blockSize) {
                    int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                    out.write(outBytes, 0, outLength);
                } else {
                    more = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        try {

            if (inLength > 0) {
                outBytes = cipher.doFinal(inBytes, 0, inLength);
            } else {
                outBytes = cipher.doFinal();
            }
            out.write(outBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
