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
 * 随机布尔值生成工具
 *
 * @author 应卓
 * @since 0.0.1
 */
public final class Booleans implements RandomGen {

    private Booleans() {
    }

    public static boolean next() {
        return RANDOM.nextBoolean();
    }

}
