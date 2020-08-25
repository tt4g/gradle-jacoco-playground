package org.github.tt4g.gradle.jacoco.playground;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageProviderImplTest {

    @Test
    public void provideMessage() {
        String message = "foo";

        MessageProviderImpl messageProviderImpl = new MessageProviderImpl(message);

        Assertions.assertThat(messageProviderImpl.provideMessage())
            .isEqualTo(message);
    }

}
