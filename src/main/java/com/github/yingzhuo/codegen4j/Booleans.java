/*
 *   ____ ___  ____  _____ ____ _____ _   _ _  _       _
 *  / ___/ _ \|  _ \| ____/ ___| ____| \ | | || |     | |
 * | |  | | | | | | |  _|| |  _|  _| |  \| | || |_ _  | |
 * | |__| |_| | |_| | |__| |_| | |___| |\  |__   _| |_| |
 *  \____\___/|____/|_____\____|_____|_| \_|  |_|  \___/
 *  https://github.com/yingzhuo/codegen4j
 */
package com.github.yingzhuo.codegen4j;

public class Booleans implements RandomGen {

    private Booleans() {
    }

    public static boolean next() {
        return RANDOM.nextBoolean();
    }

}
