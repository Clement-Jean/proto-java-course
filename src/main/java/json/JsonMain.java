package json;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.SimpleOuterClass;

import java.util.Arrays;

public class JsonMain {

    private static String toJSON(SimpleOuterClass.Simple message) throws InvalidProtocolBufferException {
        return JsonFormat.printer()
                // .omittingInsignificantWhitespace()
                // .includingDefaultValueFields()
                .print(message);
    }

    private static SimpleOuterClass.Simple fromJSON(String json) throws InvalidProtocolBufferException {
        SimpleOuterClass.Simple.Builder builder = SimpleOuterClass.Simple.newBuilder();

        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(json, builder);

        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
                .setId(42)
                .setIsSimple(true)
                .setName("A name")
                .addAllSampleLists(Arrays.asList(1, 2, 3))
                .build();

        String json = toJSON(message);

        System.out.println(json);
        System.out.println(fromJSON(json));
    }
}
