package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:39:42 AM
 * 
 */
public class ReadSINT64 {

    public Object read(DataInput in) throws IOException {
        return in.readLong();
    }

}
