package work2;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/daochengzhang/JavaCode/01jvm/src/work2/resource/Hello.class");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer=new byte[inputStream.available()];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }
//        System.out.println(len);
        inputStream.close();
        bos.close();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (255 - buffer[i]);
//            System.out.print(","+buffer[i]);
        }
        FileOutputStream out = new FileOutputStream("/Users/daochengzhang/JavaCode/01jvm/src/work2/resource/Hello1.class");
        int b = 0;
        for(int i=0; i<buffer.length; i++) {
            out.write(buffer[i]);
        }
        out.close();

//        System.out.println(new String(buffer,0,buffer.length));
    }
}
