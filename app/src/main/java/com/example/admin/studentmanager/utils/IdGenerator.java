package com.example.admin.studentmanager.utils;

import java.util.UUID;

/**
 * Created by admin on 29.06.2017.
 */

public class IdGenerator {
    public static Long generateId() {
        return UUID.randomUUID().getLeastSignificantBits();
    }
}