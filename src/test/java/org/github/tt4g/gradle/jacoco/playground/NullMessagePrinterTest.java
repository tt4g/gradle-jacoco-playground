package org.github.tt4g.gradle.jacoco.playground;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.verification.VerificationMode;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class NullMessagePrinterTest {

    @Test
    public void doNotCallMessageProvider(@Mock MessageProvider messageProvider) {
        NullMessagePrinter nullMessagePrinter = new NullMessagePrinter();

        nullMessagePrinter.print(messageProvider);

        Mockito.verify(messageProvider, Mockito.never()).provideMessage();
    }

}
