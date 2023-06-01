package com.scb.banking;

import com.scb.banking.enums.AccountTypeEnum;

import java.util.Random;

public class Tester {
    private static final Integer MIN_RANGE = 0;
    private static final Integer MAX_RANGE = 999999999;
    public static void main(String[] args) {
        System.out.println(AccountTypeEnum.values());
    }


    public static Integer generateAccountNumber() {
        Random random = new Random();
        return random.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
    }
}
