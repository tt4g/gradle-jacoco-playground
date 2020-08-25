package org.github.tt4g.gradle.jacoco.playground;

public class Application {

    private Application() {

    }

    public static void main(String[] args) {
        Application application = new Application();

        application.run();
    }

    void run() {
        MessagePrintDispatcher messagePrintDispatcher = createMessagePrintDispatcher();
        MessageProvider messageProvider = new MessageProviderImpl("Hello, World!");

        messagePrintDispatcher.dispatch(messageProvider);
        messagePrintDispatcher.rotate();
        messagePrintDispatcher.dispatch(messageProvider);
    }

    MessagePrintDispatcher createMessagePrintDispatcher() {
        SystemOutMessagePrinter systemOutMessagePrinter = new SystemOutMessagePrinter();
        NullMessagePrinter nullMessagePrinter = new NullMessagePrinter();

        return new MessagePrintDispatcher(nullMessagePrinter, systemOutMessagePrinter);
    }

}
