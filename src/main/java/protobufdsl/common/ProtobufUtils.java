package protobufdsl.common;

import protobufdsl.protogenerate.ProtoMessageStructGenerator;

import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.DescriptorProto.Builder;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 18, 2014 10:23:10 AM
 * 
 */
public class ProtobufUtils {

    public static com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Builder addFieldToStruct(
            DescriptorProto.Builder messageBuilder, String fieldName, int fieldNumber,
            com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type value,
            com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label label) {

        return messageBuilder.addFieldBuilder().setName(fieldName).setNumber(fieldNumber).setType(value)
                .setLabel(label);
    }

    public static com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Builder addFieldToStruct(
            DescriptorProto.Builder messageBuilder, String fieldName, int fieldNumber, String typeName,
            com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label label) {
        return messageBuilder.addFieldBuilder().setName(fieldName).setTypeName(typeName).setNumber(fieldNumber)
                .setLabel(label);
    }

    public static com.google.protobuf.DescriptorProtos.DescriptorProto.Builder createMessageStruct(String messageName) {
        return DescriptorProto.newBuilder().setName(messageName);
    }

    public static com.google.protobuf.Descriptors.FileDescriptor createMessageProtoFile(
            com.google.protobuf.DescriptorProtos.DescriptorProto.Builder... builders)
            throws DescriptorValidationException {
        FileDescriptorProto.Builder fileDescriptorProtoBuilder = FileDescriptorProto.newBuilder();
        for (com.google.protobuf.DescriptorProtos.DescriptorProto.Builder b : builders) {
            fileDescriptorProtoBuilder.addMessageType(b);
        }
        FileDescriptorProto fileDescriptorProto = fileDescriptorProtoBuilder.build();
        com.google.protobuf.Descriptors.FileDescriptor fileDescriptor = com.google.protobuf.Descriptors.FileDescriptor
                .buildFrom(fileDescriptorProto, new com.google.protobuf.Descriptors.FileDescriptor[0]);
        return fileDescriptor;
    }

    public static com.google.protobuf.DynamicMessage.Builder createMessagePackBuilder(
            com.google.protobuf.Descriptors.FileDescriptor fileDescriptor, String messageName) {
        Descriptor messageDesc = fileDescriptor.findMessageTypeByName(messageName);
        com.google.protobuf.DynamicMessage.Builder messagePackBuilder = DynamicMessage.newBuilder(messageDesc);
        return messagePackBuilder;
    }

    public static com.google.protobuf.DynamicMessage.Builder createMessagePackBuilder(Descriptor messageDesc) {
        return DynamicMessage.newBuilder(messageDesc);
    }

    public static com.google.protobuf.DynamicMessage.Builder cloneMessagePackBuilder(
            com.google.protobuf.DynamicMessage.Builder src) {
        return src.clone();
    }

    public static void main(String[] args) throws DescriptorValidationException {
        Builder messageDetailStruct = createMessageStruct("Detail");
        addFieldToStruct(messageDetailStruct, "first", 1,
                com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING,
                com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL);

        addFieldToStruct(messageDetailStruct, "id", 2,
                com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32,
                com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL);

        FileDescriptor file = createMessageProtoFile(messageDetailStruct);

        Descriptor messageDetailDescriptor = file.findMessageTypeByName("Detail");

        com.google.protobuf.DynamicMessage.Builder messageDetailPackBuilder = createMessagePackBuilder(file, "Detail");
        messageDetailPackBuilder.setField(messageDetailDescriptor.findFieldByNumber(1), "first detail.");
        messageDetailPackBuilder.setField(messageDetailDescriptor.findFieldByNumber(2), new Integer(11111));

        com.google.protobuf.DynamicMessage.Builder messageDetailPackBuilder2 = messageDetailPackBuilder.clone();
        messageDetailPackBuilder2.setField(messageDetailDescriptor.findFieldByNumber(1), "sdfsdf");

        DynamicMessage msg1 = messageDetailPackBuilder.build();
        System.out.println(msg1);

        DynamicMessage msg2 = messageDetailPackBuilder2.build();
        System.out.println(msg2);

        long start = System.currentTimeMillis();
        int count = 2000000;
        long sum = 0;
        for (int i = 0; i < count; i++) {
            com.google.protobuf.DynamicMessage.Builder temp = messageDetailPackBuilder.clone();
            // com.google.protobuf.DynamicMessage.Builder temp =
            // createMessagePackBuilder(messageDetailDescriptor);
            temp.setField(messageDetailDescriptor.findFieldByNumber(1),
                    String.format("hellooooooooooooooooooooooooooooooooooo%d", i));
            temp.setField(messageDetailDescriptor.findFieldByNumber(2), i);
            DynamicMessage tempMsg = temp.build();
            Object f = tempMsg.getField(messageDetailDescriptor.findFieldByNumber(2));
            sum += (Integer) f;
        }
        long spend = System.currentTimeMillis() - start;
        System.out.println("Sum: " + sum);
        System.out.println("Spent: " + spend);
        System.out.println("Fields: " + count * 2);
        double fps = count * 1000.0 * 2.0 / spend;
        System.out.println("Fields per second(fps): " + fps);
        double mps = fps / 15.0;
        System.out.println("possible messages per second(mps): " + mps);
    }
}
