/*
 *   ____ ___  ____  _____ ____ _____ _   _ _  _       _
 *  / ___/ _ \|  _ \| ____/ ___| ____| \ | | || |     | |
 * | |  | | | | | | |  _|| |  _|  _| |  \| | || |_ _  | |
 * | |__| |_| | |_| | |__| |_| | |___| |\  |__   _| |_| |
 *  \____\___/|____/|_____\____|_____|_| \_|  |_|  \___/
 *  https://github.com/yingzhuo/codegen4j
 */
package com.github.yingzhuo.codegen4j;

import java.util.UUID;

public final class UUIDs {

    private UUIDs() {
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuid36() {
        return UUID.randomUUID().toString();
    }

    public static String uuid32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
