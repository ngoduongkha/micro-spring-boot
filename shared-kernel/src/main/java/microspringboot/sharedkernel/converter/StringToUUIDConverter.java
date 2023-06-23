package microspringboot.sharedkernel.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToUUIDConverter implements Converter<String, UUID> {
    @Override
    public UUID convert(@NonNull String source) {
        return UUID.fromString(source);
    }

    @Override
    @NonNull
    public <U> Converter<String, U> andThen(@NonNull Converter<? super UUID, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
