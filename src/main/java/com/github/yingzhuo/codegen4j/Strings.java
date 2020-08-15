/*
 *   ____ ___  ____  _____ ____ _____ _   _ _  _       _
 *  / ___/ _ \|  _ \| ____/ ___| ____| \ | | || |     | |
 * | |  | | | | | | |  _|| |  _|  _| |  \| | || |_ _  | |
 * | |__| |_| | |_| | |__| |_| | |___| |\  |__   _| |_| |
 *  \____\___/|____/|_____\____|_____|_| \_|  |_|  \___/
 *  https://github.com/yingzhuo/codegen4j
 */
package com.github.yingzhuo.codegen4j;

import java.util.Random;

public final class Strings implements RandomGen {

    private Strings() {
    }

    public static String next(final int count) {
        return next(count, false, false);
    }

    public static String nextAscii(final int count) {
        return next(count, 32, 127, false, false);
    }

    public static String nextAscii(final int minLengthInclusive, final int maxLengthExclusive) {
        return nextAscii(Numbers.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static String nextAlphabetic(final int count) {
        return next(count, true, false);
    }

    public static String nextAlphabetic(final int minLengthInclusive, final int maxLengthExclusive) {
        return nextAlphabetic(Numbers.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static String nextAlphanumeric(final int count) {
        return next(count, true, true);
    }

    public static String nextAlphanumeric(final int minLengthInclusive, final int maxLengthExclusive) {
        return nextAlphanumeric(Numbers.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static String nextGraph(final int count) {
        return next(count, 33, 126, false, false);
    }

    public static String nextGraph(final int minLengthInclusive, final int maxLengthExclusive) {
        return nextGraph(Numbers.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static String nextNumeric(final int count) {
        return next(count, false, true);
    }

    public static String nextNumeric(final int minLengthInclusive, final int maxLengthExclusive) {
        return nextNumeric(Numbers.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static String nextPrint(final int count) {
        return next(count, 32, 126, false, false);
    }

    public static String nextPrint(final int minLengthInclusive, final int maxLengthExclusive) {
        return nextPrint(Numbers.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static String next(final int count, final boolean letters, final boolean numbers) {
        return next(count, 0, 0, letters, numbers);
    }

    public static String next(final int count, final int start, final int end, final boolean letters, final boolean numbers) {
        return next(count, start, end, letters, numbers, null, RANDOM);
    }

    public static String next(final int count, final int start, final int end, final boolean letters, final boolean numbers, final char... chars) {
        return next(count, start, end, letters, numbers, chars, RANDOM);
    }

    public static String next(int count, int start, int end, final boolean letters, final boolean numbers,
                              final char[] chars, final Random random) {
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        }
        if (chars != null && chars.length == 0) {
            throw new IllegalArgumentException("The chars array must not be empty");
        }

        if (start == 0 && end == 0) {
            if (chars != null) {
                end = chars.length;
            } else {
                if (!letters && !numbers) {
                    end = Character.MAX_CODE_POINT;
                } else {
                    end = 'z' + 1;
                    start = ' ';
                }
            }
        } else {
            if (end <= start) {
                throw new IllegalArgumentException("Parameter end (" + end + ") must be greater than start (" + start + ")");
            }
        }

        final int zero_digit_ascii = 48;
        final int first_letter_ascii = 65;

        if (chars == null && (numbers && end <= zero_digit_ascii
                || letters && end <= first_letter_ascii)) {
            throw new IllegalArgumentException("Parameter end (" + end + ") must be greater then (" + zero_digit_ascii + ") for generating digits " +
                    "or greater then (" + first_letter_ascii + ") for generating letters.");
        }

        final StringBuilder builder = new StringBuilder(count);
        final int gap = end - start;

        while (count-- != 0) {
            int codePoint;
            if (chars == null) {
                codePoint = random.nextInt(gap) + start;

                switch (Character.getType(codePoint)) {
                    case Character.UNASSIGNED:
                    case Character.PRIVATE_USE:
                    case Character.SURROGATE:
                        count++;
                        continue;
                }

            } else {
                codePoint = chars[random.nextInt(gap) + start];
            }

            final int numberOfChars = Character.charCount(codePoint);
            if (count == 0 && numberOfChars > 1) {
                count++;
                continue;
            }

            if (letters && Character.isLetter(codePoint)
                    || numbers && Character.isDigit(codePoint)
                    || !letters && !numbers) {
                builder.appendCodePoint(codePoint);

                if (numberOfChars == 2) {
                    count--;
                }

            } else {
                count++;
            }
        }
        return builder.toString();
    }

    public static String next(final int count, final String chars) {
        if (chars == null) {
            return next(count, 0, 0, false, false, null, RANDOM);
        }
        return next(count, chars.toCharArray());
    }

    public static String next(final int count, final char... chars) {
        if (chars == null) {
            return next(count, 0, 0, false, false, null, RANDOM);
        }
        return next(count, 0, chars.length, false, false, chars, RANDOM);
    }

}
