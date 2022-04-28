package work2;

import java.io.*;
import java.lang.reflect.Method;

public class ClassLoaderForXlass extends ClassLoader{

    public static void main(String[] args) throws Exception {
        ClassLoaderForXlass cl = new ClassLoaderForXlass();
        Class<?> clazz = cl.loadClass("Hello");
        for(Method m : clazz.getDeclaredMethods()){
            System.out.println(clazz.getSimpleName() + "." + m.getName());
        }
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream("/Users/daochengzhang/JavaCode/01jvm/src/work2/resources/Hello.xlass");
            byte[] bArray = new byte[inputStream.available()];
            System.out.println(bArray.length);
            inputStream.read(bArray);
//            return defineClass("hh",bArray,0,bArray.length);
            byte[] decodeBytes = decode(bArray);
            System.out.println(decodeBytes.length);
            inputStream.close();
            return defineClass(null,decodeBytes,0,decodeBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name,e);
        }
    }

    private static byte[] decode(byte[] bArray){
        byte[] result = new byte[bArray.length];
        for (int i = 0; i < bArray.length; i++) {
            result[i] = (byte) (255 - bArray[i]);
        }
        return result;
    }

    private static void close(Closeable res){
        if(null != res){
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
