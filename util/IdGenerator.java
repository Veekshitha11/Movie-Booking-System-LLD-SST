package util;

import java.util.UUID;

public class IdGenerator {
    private static IdGenerator instance;

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public String generate() {
        return UUID.randomUUID().toString();
    }
}