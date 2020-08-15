/*
 *   ____ ___  ____  _____ ____ _____ _   _ _  _       _
 *  / ___/ _ \|  _ \| ____/ ___| ____| \ | | || |     | |
 * | |  | | | | | | |  _|| |  _|  _| |  \| | || |_ _  | |
 * | |__| |_| | |_| | |__| |_| | |___| |\  |__   _| |_| |
 *  \____\___/|____/|_____\____|_____|_| \_|  |_|  \___/
 *  https://github.com/yingzhuo/codegen4j
 */
package com.github.yingzhuo.codegen4j;

/**
 * @author 应卓
 * @since 0.0.3
 */
public final class NumberHidings {

    private static final String DEFAULT_SALT = "https://github.com/yingzhuo/codegen4j";
    private static final Hashids HASHIDS = new Hashids(DEFAULT_SALT, 8);
    private static final long MAX = 9007199254740992L;

    private NumberHidings() {
    }

    public static String hide(long number) {
        Validate.isTrue(number >= 0, "Number cannot be negative.");

        if (number >= MAX) {
            String numberString = String.valueOf(number);
            int length = numberString.length();
            String part1 = numberString.substring(0, length / 2);
            String part2 = numberString.substring(length / 2);
            long number1 = Long.parseLong(part1);
            long number2 = Long.parseLong(part2);
            return HASHIDS.encode(number1, number2);
        } else {
            return HASHIDS.encode(number);
        }
    }

    public static String hide(String number) {
        return hide(Long.parseLong(number));
    }

    public static long show(String hash) {
        long[] parts = HASHIDS.decode(hash);
        if (parts.length == 1) {
            return parts[0];
        } else {
            StringBuilder numberString = new StringBuilder();
            for (long part : parts) {
                numberString.append(part);
            }
            return Long.parseLong(numberString.toString());
        }
    }

    public static String showAsString(String hash) {
        return String.valueOf(show(hash));
    }

}
