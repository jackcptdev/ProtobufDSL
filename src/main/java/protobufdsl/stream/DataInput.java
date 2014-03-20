package protobufdsl.stream;

import java.io.IOException;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 11:29:50 AM
 * 
 */
public interface DataInput {

    void readFully(byte b[]) throws IOException;

    void readFully(byte b[], int off, int len) throws IOException;

    int skipBytes(int n) throws IOException;

    boolean readBoolean() throws IOException;

    byte readByte() throws IOException;

    int readUnsignedByte() throws IOException;

    short readShort() throws IOException;

    int readUnsignedShort() throws IOException;

    char readChar() throws IOException;

    int readInt() throws IOException;

    long readUnsignedInt() throws IOException;

    long readLong() throws IOException;

    float readFloat() throws IOException;

    double readDouble() throws IOException;

    String readUTF() throws IOException;

    String readUTF8() throws IOException;

    String readUTF16() throws IOException;

    String readANSI() throws IOException;
}
