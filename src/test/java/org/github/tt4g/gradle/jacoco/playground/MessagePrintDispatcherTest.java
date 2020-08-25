package org.github.tt4g.gradle.jacoco.playground;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessagePrintDispatcherTest {

    @Test
    public void dispatch(
        @Mock MessagePrinter firstMessagePrinter,
        @Mock MessagePrinter secondMessagePrinter,
        @Mock MessagePrinter thirdMessagePrinter,
        @Mock MessageProvider messageProvider) {

        MessagePrintDispatcher messagePrintDispatcher =
            new MessagePrintDispatcher(
                firstMessagePrinter,
                secondMessagePrinter,
                thirdMessagePrinter);

        messagePrintDispatcher.dispatch(messageProvider);

        Mockito.verify(firstMessagePrinter, Mockito.times(1)).print(messageProvider);
        Mockito.verify(secondMessagePrinter, Mockito.never()).print(Mockito.any());
        Mockito.verify(thirdMessagePrinter, Mockito.never()).print(Mockito.any());

        messagePrintDispatcher.rotate();
        messagePrintDispatcher.dispatch(messageProvider);

        Mockito.verify(firstMessagePrinter, Mockito.times(1)).print(messageProvider);
        Mockito.verify(secondMessagePrinter, Mockito.times(1)).print(messageProvider);
        Mockito.verify(thirdMessagePrinter, Mockito.never()).print(Mockito.any());

        messagePrintDispatcher.rotate();
        messagePrintDispatcher.dispatch(messageProvider);

        Mockito.verify(firstMessagePrinter, Mockito.times(1)).print(messageProvider);
        Mockito.verify(secondMessagePrinter, Mockito.times(1)).print(messageProvider);
        Mockito.verify(thirdMessagePrinter, Mockito.times(1)).print(messageProvider);

        messagePrintDispatcher.rotate();
        messagePrintDispatcher.dispatch(messageProvider);

        Mockito.verify(firstMessagePrinter, Mockito.times(2)).print(messageProvider);
        Mockito.verify(secondMessagePrinter, Mockito.times(1)).print(messageProvider);
        Mockito.verify(thirdMessagePrinter, Mockito.times(1)).print(messageProvider);
    }

}
