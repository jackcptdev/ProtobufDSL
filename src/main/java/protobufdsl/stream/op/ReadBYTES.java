package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:40:26 AM
 * 
 */
public class ReadBYTES {

    private final int length;

    public ReadBYTES(int length) {
        this.length = length;
    }

    public Object read(DataInput in) throws IOException {
        byte[] bs = new byte[length];
        in.readFully(bs);
        return bs;
    }

    public int getLength() {
        return length;
    }

}
