package org.github.tt4g.gradle.jacoco.playground;

public class NullMessagePrinter implements MessagePrinter {

    @Override
    public void print(MessageProvider messageProvider) {
        // Don't output message provided by MessageProvider.
    }

}
