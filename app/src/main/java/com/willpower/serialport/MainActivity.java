package com.willpower.serialport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.willpower.logger.AndroidLogHelper;
import com.willpower.logger.Configure;
import com.willpower.serial.SPConnector;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static AndroidLogHelper logger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger = AndroidLogHelper.createLogger(Configure.create()
                .filterClass(Comm.class)
                .matchPackage("com.xingrui.serialport")
                .globalTag(MainActivity.class.getSimpleName())
                .logLevel(Log.VERBOSE)
                .logDirectory("/Xingrui/log/")
                .logFilePrefix("xingrui"));

        logger.deleteLogByOverdueDay(0);

        List<File> files = logger.getFileByDate(System.currentTimeMillis());

        for (File f :
                files) {
            logger.v(f.getName());
        }

        Comm.log();

        SPConnector.setSuPath("");

        Comm.log();
    }
}
