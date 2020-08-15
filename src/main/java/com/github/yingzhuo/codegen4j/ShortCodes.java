/*
 *   ____ ___  ____  _____ ____ _____ _   _ _  _       _
 *  / ___/ _ \|  _ \| ____/ ___| ____| \ | | || |     | |
 * | |  | | | | | | |  _|| |  _|  _| |  \| | || |_ _  | |
 * | |__| |_| | |_| | |__| |_| | |___| |\  |__   _| |_| |
 *  \____\___/|____/|_____\____|_____|_| \_|  |_|  \___/
 *  https://github.com/yingzhuo/codegen4j
 */
package com.github.yingzhuo.codegen4j;

public final class ShortCodes {

    private ShortCodes() {
    }

    public static String next() {
        Hashids hashids = new Hashids(UUIDs.uuid36(), 6);
        return hashids.encode(
                Numbers.nextLong(1, 50),
                Numbers.nextLong(50, 100)
        );
    }

}
