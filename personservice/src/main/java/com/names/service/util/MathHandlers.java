package com.names.service.util;

import java.util.Random;

public class MathHandlers {

    public static int getRandom(int min, int max){
        final Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
