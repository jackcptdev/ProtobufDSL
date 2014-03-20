package protobufdsl.action.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

import protobufdsl.stream.DataInputStreamLE;
import protobufdsl.stream.DataOutputStreamLE;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 19, 2014 5:55:28 PM
 * 
 */
public class TestInAndOut {

    @Test
    public void testInAndOut() throws IOException {

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStreamLE dos = new DataOutputStreamLE(bout);
        dos.writeInt(100);
        dos.writeUTF("hello");
        dos.flush();

        byte[] data = bout.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStreamLE dis = new DataInputStreamLE(bis);

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF8());

    }
}
