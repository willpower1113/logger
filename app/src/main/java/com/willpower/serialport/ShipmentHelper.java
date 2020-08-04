package com.willpower.serialport;

import android.util.Log;

import com.willpower.serial.SPConnector;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 货柜驱动板串口通信辅助类
 */
public class ShipmentHelper {

    private volatile boolean poll;

    private SPConnector connector;//串口通信工具

    private InputStream is;

    private OutputStream os;

    private static ShipmentHelper helper;

    private File driver;

    public static ShipmentHelper instance() {
        if (helper == null) {
            synchronized (ShipmentHelper.class) {
                if (helper == null) {
                    helper = new ShipmentHelper();
                }
            }
        }
        return helper;
    }

    private ShipmentHelper() {
    }

    /**
     * @param driver   -- 串口地址
     * @param baudrate -- 波特率
     * @param dataBits -- 起始位
     * @param stopBits -- 结束位
     * @param parity   -- 效验
     * @throws IOException
     * @throws InterruptedException
     */
    public boolean open(String driver, int baudrate, int dataBits, int stopBits, char parity) {
        this.connector = new SPConnector();
        this.driver = new File(driver);
        try {
            this.connector.init(this.driver);
            return this.connector.openPort(baudrate, dataBits, stopBits, parity);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(SPConnector.TAG, "open serialport error: ", e);
            return false;
        }
    }

}
