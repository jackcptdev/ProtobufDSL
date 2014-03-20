package protobufdsl.stream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 11, 2014 11:28:12 AM
 * 
 */
public class DataInputStreamLE extends FilterInputStream implements DataInput {
    /**
     * Creates a DataInputStreamLE that uses the specified underlying
     * InputStream.
     * 
     * @param in
     *            the specified input stream
     */
    public DataInputStreamLE(InputStream in) {
        super(in);
    }

    public DataInputStreamLE(byte[] bytes) {
        this(new ByteArrayInputStream(bytes));
    }

    /**
     * Creates a DataInputStreamLE that uses the specified underlying
     * InputStream. This can increase Performance.
     * 
     * @param in
     *            the specified buffered input stream
     */
    public DataInputStreamLE(BufferedInputStream in) {
        super(in);
    }

    public final void readFully(byte[] b) throws IOException {
        readFully(b, 0, b.length);
    }

    public final void readFully(byte[] b, int off, int len) throws IOException {
        if (len < 0)
            throw new IndexOutOfBoundsException("buffer len:" + len);
        InputStream in = this.in;
        int n = 0;
        while (n < len) {
            int count = in.read(b, off + n, len - n);
            if (count < 0)
                throw new EOFException("eof in read fully:" + len);
            n += count;
        }
    }

    public final int skipBytes(int n) throws IOException {
        InputStream in = this.in;
        int total = 0;
        int cur = 0;
        while ((total < n) && ((cur = (int) in.skip(n - total)) > 0)) {
            total += cur;
        }
        return total;
    }

    public final boolean readBoolean() throws IOException {
        int ch = in.read();
        if (ch < 0)
            throw new EOFException("eof in read 1 byte");
        return (ch != 0);
    }

    public final byte readByte() throws IOException {
        int ch = in.read();
        if (ch < 0)
            throw new EOFException("eof in read 1 byte");
        return (byte) (ch);
    }

    public final int readUnsignedByte() throws IOException {
        int ch = in.read();
        if (ch < 0)
            throw new EOFException("eof in read 1 byte");
        return ch;
    }

    public final short readShort() throws IOException {
        InputStream in = this.in;
        int ch1 = in.read();
        int ch2 = in.read();
        if ((ch1 | ch2) < 0)
            throw new EOFException("eof in read 2 byte");
        return (short) ((ch2 << 8) + (ch1 << 0));
    }

    public final int readUnsignedShort() throws IOException {
        InputStream in = this.in;
        int ch1 = in.read();
        int ch2 = in.read();
        if ((ch1 | ch2) < 0)
            throw new EOFException("eof in read 2 byte");
        return (ch2 << 8) + (ch1 << 0);
    }

    public final char readChar() throws IOException {
        InputStream in = this.in;
        int ch1 = in.read();
        int ch2 = in.read();
        if ((ch1 | ch2) < 0)
            throw new EOFException("eof in read 1 byte");
        return (char) ((ch2 << 8) + (ch1 << 0));
    }

    public final int readInt() throws IOException {
        InputStream in = this.in;
        int ch1 = in.read();
        int ch2 = in.read();
        int ch3 = in.read();
        int ch4 = in.read();
        if ((ch1 | ch2 | ch3 | ch4) < 0)
            throw new EOFException("eof in read 4 byte");
        return ((ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0));
    }

    public final long readLong() throws IOException {
        return (readInt() & 0xFFFFFFFFL) + ((long) (readInt()) << 32);
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public final String readUTF() throws IOException {
        return readUTF8();
    }

    public final String readUTF8() throws IOException {
        int utflen = readUnsignedShort();
        byte bytearr[] = new byte[utflen];
        readFully(bytearr, 0, utflen);
        return new String(bytearr, 0, utflen, "UTF-8");
    }

    public final String readUTF16() throws IOException {
        int charlen = readUnsignedShort();
        byte chararr[] = new byte[charlen];
        readFully(chararr, 0, charlen);
        return new String(chararr, 0, charlen, "UTF-16LE");
    }

    public final String readANSI() throws IOException {
        int charlen = readUnsignedShort();
        byte chararr[] = new byte[charlen];
        readFully(chararr, 0, charlen);
        return new String(chararr, 0, charlen, "ISO8859-1");
    }

    public long readUnsignedInt() throws IOException {
        return (readInt() & 0xFFFFFFFFL);
    }

}
