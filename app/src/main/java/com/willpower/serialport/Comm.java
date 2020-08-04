package com.willpower.serialport;

import static com.willpower.serialport.MainActivity.logger;

public class Comm {
    public static String SERIALPORT_TTYS3 = "/dev/ttyS3";
    public static String SERIALPORT_TTYS2 = "/dev/ttyS2";
    public static String SERIALPORT_TTYS1 = "/dev/ttyS1";
    public static String SERIALPORT_TTYS0 = "/dev/ttyS0";

    public static void log() {
        logger.vToFile("{\"key1\":\"value\",\"key2\":\"value\",\"key3\":\"value\",\"key4\":\"value\",\"key5\":\"value\"" +
                ",\"key6\":\"value\"}");
    }
}
