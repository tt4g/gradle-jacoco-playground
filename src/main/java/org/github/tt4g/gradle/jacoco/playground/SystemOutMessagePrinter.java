package org.github.tt4g.gradle.jacoco.playground;

public class SystemOutMessagePrinter implements MessagePrinter {

    @Override
    public void print(MessageProvider messageProvider) {
        String message = messageProvider.provideMessage();

        System.out.println(message);
    }

}
