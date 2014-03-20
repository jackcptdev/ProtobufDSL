package protobufdsl.stream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 19, 2014 5:43:53 PM
 * 
 */
import java.io.*;

public class DataOutputStreamLE extends FilterOutputStream {

    public DataOutputStreamLE(OutputStream out) {
        super(out);
    }

    public void writeFully(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
    }

    public void writeFully(byte[] b) throws IOException {
        writeFully(b, 0, b.length);
    }

    public void write(byte[] b) throws IOException {
        writeFully(b, 0, b.length);
    }

    public void writeBoolean(boolean b) throws IOException {
        out.write(b ? 1 : 0);
    }

    public void writeByte(int b) throws IOException {
        out.write(b);
    }

    public void writeUnsignedByte(int b) throws IOException {
        out.write(b);
    }

    public void writeShort(int s) throws IOException {
        out.write(s & 0xFF);
        out.write((s >>> 8) & 0xFF);
    }

    public void writeUnsignedShort(int s) throws IOException {
        out.write(s & 0xFF);
        out.write((s >>> 8) & 0xFF);
    }

    public void writeChar(int c) throws IOException {
        out.write(c & 0xFF);
        out.write((c >>> 8) & 0xFF);
    }

    public void writeInt(int i) throws IOException {
        out.write(i & 0xFF);
        out.write((i >>> 8) & 0xFF);
        out.write((i >>> 16) & 0xFF);
        out.write((i >>> 24) & 0xFF);
    }

    // 4,294,967,295
    public void writeUnsignedInt(long i) throws IOException {
        out.write((int)(i & 0xFF));
        out.write((int)((i >>> 8) & 0xFF));
        out.write((int)((i >>> 16) & 0xFF));
        out.write((int)((i >>> 24) & 0xFF));
    }

    public void writeLong(long l) throws IOException {
        out.write((int) l & 0xFF);
        out.write((int) (l >>> 8) & 0xFF);
        out.write((int) (l >>> 16) & 0xFF);
        out.write((int) (l >>> 24) & 0xFF);
        out.write((int) (l >>> 32) & 0xFF);
        out.write((int) (l >>> 40) & 0xFF);
        out.write((int) (l >>> 48) & 0xFF);
        out.write((int) (l >>> 56) & 0xFF);
    }

    public void writeUTF(String s) throws IOException {
        writeUTF8(s);
    }

    public void writeUTF8(String s) throws IOException {
        byte[] b = s.getBytes("utf-8");
        this.writeUnsignedShort(b.length);
        this.write(b);
    }

    public void writeUTF16(String utf16) throws IOException {
        byte[] b = utf16.getBytes("UTF-16LE");
        writeUnsignedShort(b.length);
        writeFully(b);
    }

    public void writeANSI(String ansi) throws IOException {
        byte[] b = ansi.getBytes("ISO8859-1");
        writeUnsignedShort(b.length);
        writeFully(b);
    }

    public final void writeFloat(float f) throws IOException {
        this.writeInt(Float.floatToIntBits(f));
    }

    public final void writeDouble(double d) throws IOException {
        this.writeLong(Double.doubleToLongBits(d));
    }

}
