package org.github.tt4g.gradle.jacoco.playground;

import java.util.List;

public class MessagePrintDispatcher {

    private final List<MessagePrinter> messagePrinters;

    private int currentIndex;

    private MessagePrinter current;

    public MessagePrintDispatcher(MessagePrinter ...messagePrinter) {
        assert messagePrinter.length != 0;

        this.messagePrinters = List.of(messagePrinter);
        this.currentIndex = 0;
        this.current = this.messagePrinters.get(this.currentIndex);
    }

    public void dispatch(MessageProvider messageProvider) {
        this.current.print(messageProvider);
    }

    public void rotate() {
        int nextIndex = this.currentIndex + 1;

        if (nextIndex == this.messagePrinters.size()) {
            nextIndex = 0;
        }

        this.currentIndex = nextIndex;
        this.current = this.messagePrinters.get(this.currentIndex);
    }

}
