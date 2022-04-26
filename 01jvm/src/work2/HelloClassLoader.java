package work2;

import java.util.Base64;

/**
 * 作用：
 * 可以用来保护加密代码
 */

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException,InstantiationException, IllegalAccessException {
        new HelloClassLoader().findClass("work2.Hello").newInstance();
    }

    @Override
    protected Class<?> findClass(String name){
        String helloBase64 = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABYMABcAGAEAGEhlbGxvIENsYXNzIEluaXRpYWxpemVkIQcAGQwAGgAbAQALd29yazIvSGVsbG8BABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABQAGAAAAAAACAAEABwAIAAEACQAAAB0AAQABAAAABSq3AAGxAAAAAQAKAAAABgABAAAAAwAIAAsACAABAAkAAAAlAAIAAAAAAAmyAAISA7YABLEAAAABAAoAAAAKAAIAAAAFAAgABgABAAwAAAACAA0=";
        byte[] bytes = decode(helloBase64);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}
