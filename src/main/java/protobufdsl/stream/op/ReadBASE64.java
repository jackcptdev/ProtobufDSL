package protobufdsl.stream.op;

import java.io.IOException;

import protobufdsl.stream.DataInput;

import sun.misc.BASE64Decoder;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 10:40:36 AM
 * 
 */
public class ReadBASE64 {

    public Object read(DataInput in) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return new String(decoder.decodeBuffer(in.readUTF8()), "utf-8");
    }

}
