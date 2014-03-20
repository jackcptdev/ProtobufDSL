package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:40:54 AM
 * 
 */
public class ReadANSI {

    public Object read(DataInput in) throws IOException {
        return in.readANSI();
    }

}
