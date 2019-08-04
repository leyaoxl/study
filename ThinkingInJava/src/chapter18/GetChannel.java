package chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int SIZE = 50;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("lala.txt").getChannel();
        fc.write(ByteBuffer.wrap("yaole is handsome".getBytes()));
        fc.close();
        fc = new RandomAccessFile("lala.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("wangyi is a beauty".getBytes()));
        fc.close();
        fc = new FileInputStream("lala.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
    }
}
