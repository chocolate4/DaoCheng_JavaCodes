package other;

import java.util.Base64;

/**
 * 作用：
 * 可以用来保护加密代码
 */

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException,InstantiationException, IllegalAccessException {
        new HelloClassLoader().findClass("work2.Hello2").newInstance();
    }

    @Override
    protected Class<?> findClass(String name){
        String helloBase64 = "NQFFQf///8v/4vX/+f/w9v/v/+73/+31/+z/6/j/6vj/6f7/+cOWkZaLwf7//NfWqf7/+7yQm5r+//CzlpGasYqSnZqNq56dk5r+//uSnpaR/v/p16SzlZ6JntCTnpGY0KyLjZaRmMTWqf7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4/+jz/+f/5v7//IyMjPj/5fP/5P/j/v/0iJCNlM3Qt5qTk5D+/++Vnome0JOekZjQsJ2VmpyL/v/vlZ6JntCTnpGY0KyGjIuakv7//JCKi/7/6rOVnome0JaQ0K+NlpGLrIuNmp6SxP7/7JWeiZ7QlpDQr42WkYusi42anpL+//iPjZaRi5OR/v/q17OVnome0JOekZjQrIuNlpGYxNap/97/+v/5///////9//7/+P/3//7/9v///+L//v/+////+tVI//5O/////v/1////+f/+/////P/2//T/8//+//b////a//3//v////ZN//3t/En/+07////+//X////1//3////6//f/+f/+//L////9//EK";
        byte[] bytes = decode(helloBase64);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}
