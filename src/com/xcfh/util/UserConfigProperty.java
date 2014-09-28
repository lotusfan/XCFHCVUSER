package com.xcfh.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * Created by zhangfan on 2014/10/10.
 */
public class UserConfigProperty {
    private static Properties properties;

    public static String getValue(String key) throws Exception {

        return getProperties().getProperty(key);
    }

    public static Properties getProperties() throws Exception {
        if (properties == null) {
            properties = new Properties();
            properties.load(Class.class.getResourceAsStream("/userconfig.property"));
        }
        return properties;
    }

    public static void updateProperties(String key, String value) throws Exception {
        if (properties == null) {
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream("../../userconfig.property");
        properties.setProperty(key, value);
        properties.store(new BufferedWriter(new OutputStreamWriter(fileOutputStream)), "utf-8");
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

}
