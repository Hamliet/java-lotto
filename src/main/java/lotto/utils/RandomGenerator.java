package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            randomNumbers.add(random.nextInt(MAX_LOTTO_NUMBER) + 1);
        }
        return randomNumbers;
    }
}
