// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: T1.proto

package protobufdsl.proto;

public final class T1 {
  private T1() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MessageT1OrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional int32 name = 1;
    /**
     * <code>optional int32 name = 1;</code>
     */
    boolean hasName();
    /**
     * <code>optional int32 name = 1;</code>
     */
    int getName();

    // optional string age = 2;
    /**
     * <code>optional string age = 2;</code>
     */
    boolean hasAge();
    /**
     * <code>optional string age = 2;</code>
     */
    java.lang.String getAge();
    /**
     * <code>optional string age = 2;</code>
     */
    com.google.protobuf.ByteString
        getAgeBytes();
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
              name_ = input.readInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              age_ = input.readBytes();
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
      return protobufdsl.proto.T1.internal_static_MessageT1_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobufdsl.proto.T1.internal_static_MessageT1_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobufdsl.proto.T1.MessageT1.class, protobufdsl.proto.T1.MessageT1.Builder.class);
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
    // optional int32 name = 1;
    public static final int NAME_FIELD_NUMBER = 1;
    private int name_;
    /**
     * <code>optional int32 name = 1;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 name = 1;</code>
     */
    public int getName() {
      return name_;
    }

    // optional string age = 2;
    public static final int AGE_FIELD_NUMBER = 2;
    private java.lang.Object age_;
    /**
     * <code>optional string age = 2;</code>
     */
    public boolean hasAge() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string age = 2;</code>
     */
    public java.lang.String getAge() {
      java.lang.Object ref = age_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          age_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string age = 2;</code>
     */
    public com.google.protobuf.ByteString
        getAgeBytes() {
      java.lang.Object ref = age_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        age_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      name_ = 0;
      age_ = "";
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
        output.writeInt32(1, name_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getAgeBytes());
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
          .computeInt32Size(1, name_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getAgeBytes());
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

    public static protobufdsl.proto.T1.MessageT1 parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static protobufdsl.proto.T1.MessageT1 parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static protobufdsl.proto.T1.MessageT1 parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobufdsl.proto.T1.MessageT1 parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protobufdsl.proto.T1.MessageT1 prototype) {
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
       implements protobufdsl.proto.T1.MessageT1OrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return protobufdsl.proto.T1.internal_static_MessageT1_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return protobufdsl.proto.T1.internal_static_MessageT1_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                protobufdsl.proto.T1.MessageT1.class, protobufdsl.proto.T1.MessageT1.Builder.class);
      }

      // Construct using protobufdsl.proto.T1.MessageT1.newBuilder()
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
        name_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        age_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return protobufdsl.proto.T1.internal_static_MessageT1_descriptor;
      }

      public protobufdsl.proto.T1.MessageT1 getDefaultInstanceForType() {
        return protobufdsl.proto.T1.MessageT1.getDefaultInstance();
      }

      public protobufdsl.proto.T1.MessageT1 build() {
        protobufdsl.proto.T1.MessageT1 result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public protobufdsl.proto.T1.MessageT1 buildPartial() {
        protobufdsl.proto.T1.MessageT1 result = new protobufdsl.proto.T1.MessageT1(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.name_ = name_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.age_ = age_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof protobufdsl.proto.T1.MessageT1) {
          return mergeFrom((protobufdsl.proto.T1.MessageT1)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(protobufdsl.proto.T1.MessageT1 other) {
        if (other == protobufdsl.proto.T1.MessageT1.getDefaultInstance()) return this;
        if (other.hasName()) {
          setName(other.getName());
        }
        if (other.hasAge()) {
          bitField0_ |= 0x00000002;
          age_ = other.age_;
          onChanged();
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
        protobufdsl.proto.T1.MessageT1 parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (protobufdsl.proto.T1.MessageT1) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional int32 name = 1;
      private int name_ ;
      /**
       * <code>optional int32 name = 1;</code>
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional int32 name = 1;</code>
       */
      public int getName() {
        return name_;
      }
      /**
       * <code>optional int32 name = 1;</code>
       */
      public Builder setName(int value) {
        bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 name = 1;</code>
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = 0;
        onChanged();
        return this;
      }

      // optional string age = 2;
      private java.lang.Object age_ = "";
      /**
       * <code>optional string age = 2;</code>
       */
      public boolean hasAge() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string age = 2;</code>
       */
      public java.lang.String getAge() {
        java.lang.Object ref = age_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          age_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string age = 2;</code>
       */
      public com.google.protobuf.ByteString
          getAgeBytes() {
        java.lang.Object ref = age_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          age_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string age = 2;</code>
       */
      public Builder setAge(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        age_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string age = 2;</code>
       */
      public Builder clearAge() {
        bitField0_ = (bitField0_ & ~0x00000002);
        age_ = getDefaultInstance().getAge();
        onChanged();
        return this;
      }
      /**
       * <code>optional string age = 2;</code>
       */
      public Builder setAgeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        age_ = value;
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
      "\n\010T1.proto\"&\n\tMessageT1\022\014\n\004name\030\001 \001(\005\022\013\n" +
      "\003age\030\002 \001(\tB\023\n\021protobufdsl.proto"
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
              new java.lang.String[] { "Name", "Age", });
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