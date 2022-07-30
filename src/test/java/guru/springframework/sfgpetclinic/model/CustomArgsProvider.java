package guru.springframework.sfgpetclinic.model;

/*
 * by bennani  / 2022
 * testing-java-junit5
 */

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments( ExtensionContext extensionContext ) throws Exception {
        return Stream.of(
                Arguments.of("FL", 361, 1),
                Arguments.of("OH", 362, 12),
                Arguments.of("MI", 3641, 991));
    }
}
