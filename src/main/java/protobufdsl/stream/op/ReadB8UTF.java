package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:40:47 AM
 * 
 */
public class ReadB8UTF {

    private final int length;

    public ReadB8UTF(int length) {
        this.length = length;
    }

    public Object read(DataInput in) throws IOException {
        byte[] bs = new byte[length];
        in.readFully(bs);
        return new String(bs, "utf-8");
    }

    public int getLength() {
        return length;
    }

}
