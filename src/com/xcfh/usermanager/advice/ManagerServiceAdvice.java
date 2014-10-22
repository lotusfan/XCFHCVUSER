package com.xcfh.usermanager.advice;

import com.xcfh.util.Encrypt;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * Created by zhangfan on 2014/10/9.
 */
@Service("ManagerServiceAdvice")
public class ManagerServiceAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        System.out.println("method=" + method.getName());
        System.out.println("object type = " + o.getClass().getName());
        objects[0] = getJSON((InputStream) objects[0]);


    }
    /**
     * 加密流转为明文JSON
     * 中文字符编码UTF-8
     */
    public JsonObject getJSON(InputStream inputStream) {
        JsonObject json = null;
        try {
            byte[] jsonbyte = Encrypt.desecret(inputStream);
            JsonReader jsonReader = Json.createReader(new StringReader(new String(jsonbyte, Charset.forName("utf-8"))));
            json = jsonReader.readObject();
            jsonReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
