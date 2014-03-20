package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:33:17 AM
 * 
 */
public class ReadUTF8 {

    public Object read(DataInput in) throws IOException {
        return in.readUTF8();
    }

}
