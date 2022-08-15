package simple;

import example.simple.SimpleOuterClass;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {
        SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
                .setId(42)
                .setIsSimple(true)
                .setName("My name")
                .addSampleLists(1)
                .addSampleLists(2)
                .addSampleLists(3)
                .addAllSampleLists(Arrays.asList(4, 5, 6))
                .build();

        System.out.println(message);
    }
}
