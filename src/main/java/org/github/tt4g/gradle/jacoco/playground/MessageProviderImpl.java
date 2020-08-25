package org.github.tt4g.gradle.jacoco.playground;

public class MessageProviderImpl implements MessageProvider {

    private final String message;

    public MessageProviderImpl(String message) {
        assert message != null;

        this.message = message;
    }

    @Override
    public String provideMessage() {
        return this.message;
    }

}
