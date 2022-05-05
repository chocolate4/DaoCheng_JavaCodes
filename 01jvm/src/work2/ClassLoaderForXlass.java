package work2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("Hello.xlass");
        try {
            byte[] bArray = new byte[inputStream.available()];
            inputStream.read(bArray);
            byte[] decodeBytes = decode(bArray);
            return defineClass(name,decodeBytes,0,decodeBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name,e);
        }finally {
            close(inputStream);
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
