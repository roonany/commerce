package com.rsupport.commerce.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.core.io.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;


public class StringUtils {
    public static boolean isEmpty(String...args) {
        for(String str : args) {
            if(org.apache.commons.lang3.StringUtils.isEmpty(str)) {
               return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(String str) {
        return org.apache.commons.lang3.StringUtils.isNotEmpty(str);
    }

    public static boolean isBlank(String...args) {
        for (String str : args) {
            if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotBlank(String str){
        return org.apache.commons.lang3.StringUtils.isNotBlank(str);
    }

    public static String replace(String text, String searchString, String replacement) {
        return org.apache.commons.lang3.StringUtils.replace(text, searchString, replacement);
    }

    public static String remove(String str, String removeString) {
        return org.apache.commons.lang3.StringUtils.remove(str, removeString);
    }

    public static String removeStart(String str, String remove) {
        return org.apache.commons.lang3.StringUtils.removeStart(str, remove);
    }

    public static String removeEnd(String str, String remove) {
        return org.apache.commons.lang3.StringUtils.removeEnd(str, remove);
    }

    public static String substring(String str, int start, int end) {
        return org.apache.commons.lang3.StringUtils.substring(str, start, end);
    }

    public static int indexOf(String str, String searchStr) {
        return org.apache.commons.lang3.StringUtils.indexOf(str, searchStr);
    }

    public static String trim(String str) {
        return org.apache.commons.lang3.StringUtils.trimToEmpty(str);
    }

    public static String deleteWhitespace(String str) {
        return org.apache.commons.lang3.StringUtils.deleteWhitespace(str);
    }

    public static String defaultString(String str) {
        return org.apache.commons.lang3.StringUtils.defaultString(str);
    }

    public static String defaultString(String str, String defaultStr) {
        return org.apache.commons.lang3.StringUtils.defaultString(str, defaultStr);
    }

    public static String defaultIfBlank(String str, String defaultStr) {
        return org.apache.commons.lang3.StringUtils.defaultIfBlank(str, defaultStr);
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        return org.apache.commons.lang3.StringUtils.containsIgnoreCase(str, searchStr);
    }

    public static String lowerCase(String str) {
        return org.apache.commons.lang3.StringUtils.lowerCase(str);
    }

    public static String upperCase(String str) {
        return org.apache.commons.lang3.StringUtils.upperCase(str);
    }

    public static boolean contains(String str, String searchString) {
        return org.apache.commons.lang3.StringUtils.contains(str, searchString);
    }

    public static String[] split(String str, String delim) {
        return org.apache.commons.lang3.StringUtils.split(str, delim);
    }

    public static String uncapitalize(String str) {
        return org.springframework.util.StringUtils.uncapitalize(str);
    }

    public static String collectionToDelimitedString(Collection coll, String delim) {
        return org.springframework.util.StringUtils.collectionToDelimitedString(coll, delim);
    }

    public static String collectionToCommaDelimitedString(Collection coll) {
        return org.springframework.util.StringUtils.collectionToCommaDelimitedString(coll);
    }

    public static String join(Object[] array, String seperator) {
        return org.apache.commons.lang3.StringUtils.join(array, seperator);
    }

    public static boolean equals(CharSequence str1, CharSequence str2) {
        return org.apache.commons.lang3.StringUtils.equalsIgnoreCase(str1, str2);
    }

    public static String left(String str, int len) {
        return org.apache.commons.lang3.StringUtils.left(str, len);
    }

    public static String right(String str, int len) {
        return org.apache.commons.lang3.StringUtils.right(str, len);
    }

    public static String substringBetween(String str, String open, String close) {
        return  org.apache.commons.lang3.StringUtils.substringBetween(str, open, close);
    }

    public static String substringAfterLast(String str, String separator) {
        return org.apache.commons.lang3.StringUtils.substringAfterLast(str, separator);
    }

    public static String substringAfter(String str, String separator) {
        return org.apache.commons.lang3.StringUtils.substringAfter(str, separator);
    }

    public static String substringBefore(String str, String separator) {
        return org.apache.commons.lang3.StringUtils.substringBefore(str, separator);
    }

    public static String substringBeforeLast(String str, String separator) {
        return org.apache.commons.lang3.StringUtils.substringBeforeLast(str, separator);
    }

    public static String join(List<String> list, String seperator) {
        return org.apache.commons.lang3.StringUtils.join(list, seperator);
    }

    public static String getString(Resource resource) {
        try {
            InputStream inputStream = resource.getInputStream();
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, "UTF-8");
            return writer.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] getBytes(String str, String charset) {
        if (str == null)
            return null;
        return str.getBytes(Charset.forName(charset));
    }

    public static String toString(Object object) {
        return ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE);
    }

    public static String toJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{}";
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        return jsonString;
    }

    public static String toXmlString(Object object) {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
            m.marshal(object, writer);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        return writer.toString();
    }

    public static boolean startWith(String str, String prefix) {
        return org.apache.commons.lang3.StringUtils.startsWith(str, prefix);
    }

    public static int getByteLength(String value){
       int byteLength = 0;
       if(isNotBlank(value)){
          char tempChar[] = new char[value.length()];
          for(int i=0; i<tempChar.length; i++){
             tempChar[i] = value.charAt(i);
             if(tempChar[i] < 128){
                byteLength++;
             }else{
                byteLength+=2;
             }
          }
       }
       return byteLength;
    }
}