package com.cleytonorocha.app.inovapotiguar.util;

import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumUtils {
    public static Enum<?> enumAleatorio(Class<? extends Enum<?>> enumClass) {
        Method method;
        try {
            method = enumClass.getDeclaredMethod("toEnum", Integer.class);
            Enum<?> enumerated = (Enum<?>) method.invoke(
                    enumClass.getClass(),
                    RandomUtils.nextInt(0, enumClass.getEnumConstants().length));
            return enumerated;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
