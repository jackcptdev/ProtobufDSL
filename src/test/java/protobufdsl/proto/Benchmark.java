// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Benchmark.proto

package protobufdsl.proto;

public final class Benchmark {
  private Benchmark() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MessageT1OrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional int64 field1 = 1;
    /**
     * <code>optional int64 field1 = 1;</code>
     */
    boolean hasField1();
    /**
     * <code>optional int64 field1 = 1;</code>
     */
    long getField1();

    // optional int32 field2 = 2;
    /**
     * <code>optional int32 field2 = 2;</code>
     */
    boolean hasField2();
    /**
     * <code>optional int32 field2 = 2;</code>
     */
    int getField2();

    // optional double field3 = 3;
    /**
     * <code>optional double field3 = 3;</code>
     */
    boolean hasField3();
    /**
     * <code>optional double field3 = 3;</code>
     */
    double getField3();

    // optional float field4 = 4;
    /**
     * <code>optional float field4 = 4;</code>
     */
    boolean hasField4();
    /**
     * <code>optional float field4 = 4;</code>
     */
    float getField4();

    // optional uint32 field5 = 5;
    /**
     * <code>optional uint32 field5 = 5;</code>
     */
    boolean hasField5();
    /**
     * <code>optional uint32 field5 = 5;</code>
     */
    int getField5();

    // optional uint64 field6 = 6;
    /**
     * <code>optional uint64 field6 = 6;</code>
     */
    boolean hasField6();
    /**
     * <code>optional uint64 field6 = 6;</code>
     */
    long getField6();

    // optional sint32 field7 = 7;
    /**
     * <code>optional sint32 field7 = 7;</code>
     */
    boolean hasField7();
    /**
     * <code>optional sint32 field7 = 7;</code>
     */
    int getField7();

    // optional sint64 field8 = 8;
    /**
     * <code>optional sint64 field8 = 8;</code>
     */
    boolean hasField8();
    /**
     * <code>optional sint64 field8 = 8;</code>
     */
    long getField8();

    // optional string field9 = 9;
    /**
     * <code>optional string field9 = 9;</code>
     */
    boolean hasField9();
    /**
     * <code>optional string field9 = 9;</code>
     */
    java.lang.String getField9();
    /**
     * <code>optional string field9 = 9;</code>
     */
    com.google.protobuf.ByteString
        getField9Bytes();

    // optional bytes field10 = 10;
    /**
     * <code>optional bytes field10 = 10;</code>
     */
    boolean hasField10();
    /**
     * <code>optional bytes field10 = 10;</code>
     */
    com.google.protobuf.ByteString getField10();
  }
  /**
   * Protobuf type {@code MessageT1}
   */
  public static final class MessageT1 extends
      com.google.protobuf.GeneratedMessage
      implements MessageT1OrBuilder {
    // Use MessageT1.newBuilder() to construct.
    private MessageT1(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private MessageT1(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final MessageT1 defaultInstance;
    public static MessageT1 getDefaultInstance() {
      return defaultInstance;
    }

    public MessageT1 getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private MessageT1(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              field1_ = input.readInt64();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              field2_ = input.readInt32();
              break;
            }
            case 25: {
              bitField0_ |= 0x00000004;
              field3_ = input.readDouble();
              break;
            }
            case 37: {
              bitField0_ |= 0x00000008;
              field4_ = input.readFloat();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              field5_ = input.readUInt32();
              break;
            }
            case 48: {
              bitField0_ |= 0x00000020;
              field6_ = input.readUInt64();
              break;
            }
            case 56: {
              bitField0_ |= 0x00000040;
              field7_ = input.readSInt32();
              break;
            }
            case 64: {
              bitField0_ |= 0x00000080;
              field8_ = input.readSInt64();
              break;
            }
            case 74: {
              bitField0_ |= 0x00000100;
              field9_ = input.readBytes();
              break;
            }
            case 82: {
              bitField0_ |= 0x00000200;
              field10_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protobufdsl.proto.Benchmark.internal_static_MessageT1_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobufdsl.proto.Benchmark.internal_static_MessageT1_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobufdsl.proto.Benchmark.MessageT1.class, protobufdsl.proto.Benchmark.MessageT1.Builder.class);
    }

    public static com.google.protobuf.Parser<MessageT1> PARSER =
        new com.google.protobuf.AbstractParser<MessageT1>() {
      public MessageT1 parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageT1(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<MessageT1> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // optional int64 field1 = 1;
    public static final int FIELD1_FIELD_NUMBER = 1;
    private long field1_;
    /**
     * <code>optional int64 field1 = 1;</code>
     */
    public boolean hasField1() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int64 field1 = 1;</code>
     */
    public long getField1() {
      return field1_;
    }

    // optional int32 field2 = 2;
    public static final int FIELD2_FIELD_NUMBER = 2;
    private int field2_;
    /**
     * <code>optional int32 field2 = 2;</code>
     */
    public boolean hasField2() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 field2 = 2;</code>
     */
    public int getField2() {
      return field2_;
    }

    // optional double field3 = 3;
    public static final int FIELD3_FIELD_NUMBER = 3;
    private double field3_;
    /**
     * <code>optional double field3 = 3;</code>
     */
    public boolean hasField3() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional double field3 = 3;</code>
     */
    public double getField3() {
      return field3_;
    }

    // optional float field4 = 4;
    public static final int FIELD4_FIELD_NUMBER = 4;
    private float field4_;
    /**
     * <code>optional float field4 = 4;</code>
     */
    public boolean hasField4() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional float field4 = 4;</code>
     */
    public float getField4() {
      return field4_;
    }

    // optional uint32 field5 = 5;
    public static final int FIELD5_FIELD_NUMBER = 5;
    private int field5_;
    /**
     * <code>optional uint32 field5 = 5;</code>
     */
    public boolean hasField5() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional uint32 field5 = 5;</code>
     */
    public int getField5() {
      return field5_;
    }

    // optional uint64 field6 = 6;
    public static final int FIELD6_FIELD_NUMBER = 6;
    private long field6_;
    /**
     * <code>optional uint64 field6 = 6;</code>
     */
    public boolean hasField6() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional uint64 field6 = 6;</code>
     */
    public long getField6() {
      return field6_;
    }

    // optional sint32 field7 = 7;
    public static final int FIELD7_FIELD_NUMBER = 7;
    private int field7_;
    /**
     * <code>optional sint32 field7 = 7;</code>
     */
    public boolean hasField7() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>optional sint32 field7 = 7;</code>
     */
    public int getField7() {
      return field7_;
    }

    // optional sint64 field8 = 8;
    public static final int FIELD8_FIELD_NUMBER = 8;
    private long field8_;
    /**
     * <code>optional sint64 field8 = 8;</code>
     */
    public boolean hasField8() {
      return ((bitField0_ & 0x00000080) == 0x00000080);
    }
    /**
     * <code>optional sint64 field8 = 8;</code>
     */
    public long getField8() {
      return field8_;
    }

    // optional string field9 = 9;
    public static final int FIELD9_FIELD_NUMBER = 9;
    private java.lang.Object field9_;
    /**
     * <code>optional string field9 = 9;</code>
     */
    public boolean hasField9() {
      return ((bitField0_ & 0x00000100) == 0x00000100);
    }
    /**
     * <code>optional string field9 = 9;</code>
     */
    public java.lang.String getField9() {
      java.lang.Object ref = field9_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          field9_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string field9 = 9;</code>
     */
    public com.google.protobuf.ByteString
        getField9Bytes() {
      java.lang.Object ref = field9_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        field9_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional bytes field10 = 10;
    public static final int FIELD10_FIELD_NUMBER = 10;
    private com.google.protobuf.ByteString field10_;
    /**
     * <code>optional bytes field10 = 10;</code>
     */
    public boolean hasField10() {
      return ((bitField0_ & 0x00000200) == 0x00000200);
    }
    /**
     * <code>optional bytes field10 = 10;</code>
     */
    public com.google.protobuf.ByteString getField10() {
      return field10_;
    }

    private void initFields() {
      field1_ = 0L;
      field2_ = 0;
      field3_ = 0D;
      field4_ = 0F;
      field5_ = 0;
      field6_ = 0L;
      field7_ = 0;
      field8_ = 0L;
      field9_ = "";
      field10_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, field1_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, field2_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeDouble(3, field3_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeFloat(4, field4_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeUInt32(5, field5_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeUInt64(6, field6_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        output.writeSInt32(7, field7_);
      }
      if (((bitField0_ & 0x00000080) == 0x00000080)) {
        output.writeSInt64(8, field8_);
      }
      if (((bitField0_ & 0x00000100) == 0x00000100)) {
        output.writeBytes(9, getField9Bytes());
      }
      if (((bitField0_ & 0x00000200) == 0x00000200)) {
        output.writeBytes(10, field10_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, field1_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, field2_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(3, field3_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, field4_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(5, field5_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(6, field6_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        size += com.google.protobuf.CodedOutputStream
          .computeSInt32Size(7, field7_);
      }
      if (((bitField0_ & 0x00000080) == 0x00000080)) {
        size += com.google.protobuf.CodedOutputStream
          .computeSInt64Size(8, field8_);
      }
      if (((bitField0_ & 0x00000100) == 0x00000100)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(9, getField9Bytes());
      }
      if (((bitField0_ & 0x00000200) == 0x00000200)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(10, field10_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobufdsl.proto.Benchmark.MessageT1 parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protobufdsl.proto.Benchmark.MessageT1 prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code MessageT1}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements protobufdsl.proto.Benchmark.MessageT1OrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return protobufdsl.proto.Benchmark.internal_static_MessageT1_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return protobufdsl.proto.Benchmark.internal_static_MessageT1_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                protobufdsl.proto.Benchmark.MessageT1.class, protobufdsl.proto.Benchmark.MessageT1.Builder.class);
      }

      // Construct using protobufdsl.proto.Benchmark.MessageT1.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        field1_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        field2_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        field3_ = 0D;
        bitField0_ = (bitField0_ & ~0x00000004);
        field4_ = 0F;
        bitField0_ = (bitField0_ & ~0x00000008);
        field5_ = 0;
        bitField0_ = (bitField0_ & ~0x00000010);
        field6_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000020);
        field7_ = 0;
        bitField0_ = (bitField0_ & ~0x00000040);
        field8_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000080);
        field9_ = "";
        bitField0_ = (bitField0_ & ~0x00000100);
        field10_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000200);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return protobufdsl.proto.Benchmark.internal_static_MessageT1_descriptor;
      }

      public protobufdsl.proto.Benchmark.MessageT1 getDefaultInstanceForType() {
        return protobufdsl.proto.Benchmark.MessageT1.getDefaultInstance();
      }

      public protobufdsl.proto.Benchmark.MessageT1 build() {
        protobufdsl.proto.Benchmark.MessageT1 result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public protobufdsl.proto.Benchmark.MessageT1 buildPartial() {
        protobufdsl.proto.Benchmark.MessageT1 result = new protobufdsl.proto.Benchmark.MessageT1(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.field1_ = field1_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.field2_ = field2_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.field3_ = field3_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.field4_ = field4_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.field5_ = field5_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.field6_ = field6_;
        if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
          to_bitField0_ |= 0x00000040;
        }
        result.field7_ = field7_;
        if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
          to_bitField0_ |= 0x00000080;
        }
        result.field8_ = field8_;
        if (((from_bitField0_ & 0x00000100) == 0x00000100)) {
          to_bitField0_ |= 0x00000100;
        }
        result.field9_ = field9_;
        if (((from_bitField0_ & 0x00000200) == 0x00000200)) {
          to_bitField0_ |= 0x00000200;
        }
        result.field10_ = field10_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof protobufdsl.proto.Benchmark.MessageT1) {
          return mergeFrom((protobufdsl.proto.Benchmark.MessageT1)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(protobufdsl.proto.Benchmark.MessageT1 other) {
        if (other == protobufdsl.proto.Benchmark.MessageT1.getDefaultInstance()) return this;
        if (other.hasField1()) {
          setField1(other.getField1());
        }
        if (other.hasField2()) {
          setField2(other.getField2());
        }
        if (other.hasField3()) {
          setField3(other.getField3());
        }
        if (other.hasField4()) {
          setField4(other.getField4());
        }
        if (other.hasField5()) {
          setField5(other.getField5());
        }
        if (other.hasField6()) {
          setField6(other.getField6());
        }
        if (other.hasField7()) {
          setField7(other.getField7());
        }
        if (other.hasField8()) {
          setField8(other.getField8());
        }
        if (other.hasField9()) {
          bitField0_ |= 0x00000100;
          field9_ = other.field9_;
          onChanged();
        }
        if (other.hasField10()) {
          setField10(other.getField10());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        protobufdsl.proto.Benchmark.MessageT1 parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (protobufdsl.proto.Benchmark.MessageT1) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional int64 field1 = 1;
      private long field1_ ;
      /**
       * <code>optional int64 field1 = 1;</code>
       */
      public boolean hasField1() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional int64 field1 = 1;</code>
       */
      public long getField1() {
        return field1_;
      }
      /**
       * <code>optional int64 field1 = 1;</code>
       */
      public Builder setField1(long value) {
        bitField0_ |= 0x00000001;
        field1_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 field1 = 1;</code>
       */
      public Builder clearField1() {
        bitField0_ = (bitField0_ & ~0x00000001);
        field1_ = 0L;
        onChanged();
        return this;
      }

      // optional int32 field2 = 2;
      private int field2_ ;
      /**
       * <code>optional int32 field2 = 2;</code>
       */
      public boolean hasField2() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional int32 field2 = 2;</code>
       */
      public int getField2() {
        return field2_;
      }
      /**
       * <code>optional int32 field2 = 2;</code>
       */
      public Builder setField2(int value) {
        bitField0_ |= 0x00000002;
        field2_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 field2 = 2;</code>
       */
      public Builder clearField2() {
        bitField0_ = (bitField0_ & ~0x00000002);
        field2_ = 0;
        onChanged();
        return this;
      }

      // optional double field3 = 3;
      private double field3_ ;
      /**
       * <code>optional double field3 = 3;</code>
       */
      public boolean hasField3() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional double field3 = 3;</code>
       */
      public double getField3() {
        return field3_;
      }
      /**
       * <code>optional double field3 = 3;</code>
       */
      public Builder setField3(double value) {
        bitField0_ |= 0x00000004;
        field3_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional double field3 = 3;</code>
       */
      public Builder clearField3() {
        bitField0_ = (bitField0_ & ~0x00000004);
        field3_ = 0D;
        onChanged();
        return this;
      }

      // optional float field4 = 4;
      private float field4_ ;
      /**
       * <code>optional float field4 = 4;</code>
       */
      public boolean hasField4() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional float field4 = 4;</code>
       */
      public float getField4() {
        return field4_;
      }
      /**
       * <code>optional float field4 = 4;</code>
       */
      public Builder setField4(float value) {
        bitField0_ |= 0x00000008;
        field4_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float field4 = 4;</code>
       */
      public Builder clearField4() {
        bitField0_ = (bitField0_ & ~0x00000008);
        field4_ = 0F;
        onChanged();
        return this;
      }

      // optional uint32 field5 = 5;
      private int field5_ ;
      /**
       * <code>optional uint32 field5 = 5;</code>
       */
      public boolean hasField5() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional uint32 field5 = 5;</code>
       */
      public int getField5() {
        return field5_;
      }
      /**
       * <code>optional uint32 field5 = 5;</code>
       */
      public Builder setField5(int value) {
        bitField0_ |= 0x00000010;
        field5_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint32 field5 = 5;</code>
       */
      public Builder clearField5() {
        bitField0_ = (bitField0_ & ~0x00000010);
        field5_ = 0;
        onChanged();
        return this;
      }

      // optional uint64 field6 = 6;
      private long field6_ ;
      /**
       * <code>optional uint64 field6 = 6;</code>
       */
      public boolean hasField6() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>optional uint64 field6 = 6;</code>
       */
      public long getField6() {
        return field6_;
      }
      /**
       * <code>optional uint64 field6 = 6;</code>
       */
      public Builder setField6(long value) {
        bitField0_ |= 0x00000020;
        field6_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint64 field6 = 6;</code>
       */
      public Builder clearField6() {
        bitField0_ = (bitField0_ & ~0x00000020);
        field6_ = 0L;
        onChanged();
        return this;
      }

      // optional sint32 field7 = 7;
      private int field7_ ;
      /**
       * <code>optional sint32 field7 = 7;</code>
       */
      public boolean hasField7() {
        return ((bitField0_ & 0x00000040) == 0x00000040);
      }
      /**
       * <code>optional sint32 field7 = 7;</code>
       */
      public int getField7() {
        return field7_;
      }
      /**
       * <code>optional sint32 field7 = 7;</code>
       */
      public Builder setField7(int value) {
        bitField0_ |= 0x00000040;
        field7_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional sint32 field7 = 7;</code>
       */
      public Builder clearField7() {
        bitField0_ = (bitField0_ & ~0x00000040);
        field7_ = 0;
        onChanged();
        return this;
      }

      // optional sint64 field8 = 8;
      private long field8_ ;
      /**
       * <code>optional sint64 field8 = 8;</code>
       */
      public boolean hasField8() {
        return ((bitField0_ & 0x00000080) == 0x00000080);
      }
      /**
       * <code>optional sint64 field8 = 8;</code>
       */
      public long getField8() {
        return field8_;
      }
      /**
       * <code>optional sint64 field8 = 8;</code>
       */
      public Builder setField8(long value) {
        bitField0_ |= 0x00000080;
        field8_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional sint64 field8 = 8;</code>
       */
      public Builder clearField8() {
        bitField0_ = (bitField0_ & ~0x00000080);
        field8_ = 0L;
        onChanged();
        return this;
      }

      // optional string field9 = 9;
      private java.lang.Object field9_ = "";
      /**
       * <code>optional string field9 = 9;</code>
       */
      public boolean hasField9() {
        return ((bitField0_ & 0x00000100) == 0x00000100);
      }
      /**
       * <code>optional string field9 = 9;</code>
       */
      public java.lang.String getField9() {
        java.lang.Object ref = field9_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          field9_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string field9 = 9;</code>
       */
      public com.google.protobuf.ByteString
          getField9Bytes() {
        java.lang.Object ref = field9_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          field9_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string field9 = 9;</code>
       */
      public Builder setField9(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000100;
        field9_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string field9 = 9;</code>
       */
      public Builder clearField9() {
        bitField0_ = (bitField0_ & ~0x00000100);
        field9_ = getDefaultInstance().getField9();
        onChanged();
        return this;
      }
      /**
       * <code>optional string field9 = 9;</code>
       */
      public Builder setField9Bytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000100;
        field9_ = value;
        onChanged();
        return this;
      }

      // optional bytes field10 = 10;
      private com.google.protobuf.ByteString field10_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes field10 = 10;</code>
       */
      public boolean hasField10() {
        return ((bitField0_ & 0x00000200) == 0x00000200);
      }
      /**
       * <code>optional bytes field10 = 10;</code>
       */
      public com.google.protobuf.ByteString getField10() {
        return field10_;
      }
      /**
       * <code>optional bytes field10 = 10;</code>
       */
      public Builder setField10(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000200;
        field10_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes field10 = 10;</code>
       */
      public Builder clearField10() {
        bitField0_ = (bitField0_ & ~0x00000200);
        field10_ = getDefaultInstance().getField10();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:MessageT1)
    }

    static {
      defaultInstance = new MessageT1(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:MessageT1)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_MessageT1_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_MessageT1_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017Benchmark.proto\"\254\001\n\tMessageT1\022\016\n\006field" +
      "1\030\001 \001(\003\022\016\n\006field2\030\002 \001(\005\022\016\n\006field3\030\003 \001(\001\022" +
      "\016\n\006field4\030\004 \001(\002\022\016\n\006field5\030\005 \001(\r\022\016\n\006field" +
      "6\030\006 \001(\004\022\016\n\006field7\030\007 \001(\021\022\016\n\006field8\030\010 \001(\022\022" +
      "\016\n\006field9\030\t \001(\t\022\017\n\007field10\030\n \001(\014B\023\n\021prot" +
      "obufdsl.proto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_MessageT1_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_MessageT1_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_MessageT1_descriptor,
              new java.lang.String[] { "Field1", "Field2", "Field3", "Field4", "Field5", "Field6", "Field7", "Field8", "Field9", "Field10", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}