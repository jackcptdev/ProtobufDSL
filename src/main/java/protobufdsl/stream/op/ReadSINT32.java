package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:39:52 AM
 * 
 */
public class ReadSINT32 {

    public Object read(DataInput in) throws IOException {
        return in.readInt();
    }

}
