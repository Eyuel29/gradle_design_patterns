package com.joel.creational.factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.spi.TimeZoneNameProvider;

import com.joel.creational.factory.CustomLogger;

public class CustomLoggerFactory {

    public CustomLogger getLogger(CustomLoggers loggerType){
        switch (loggerType) {
            case CustomFileLogger:
                return new CustomFileLogger();
            case CustomConsoleLogger:
                return new CustomConsoleLogger();
            case CustomFrameLogger:
                return new CustomFrameLogger();
            default:
                throw new IllegalArgumentException("Invalid logger type!");
        }
    }

    private class CustomFileLogger extends CustomLogger {
        File file = new File("./src/main/java/com/joel/creational/factory/custom-log.txt");
        @Override
        public void log(String message) {
            try (FileOutputStream fos = new FileOutputStream(file, true)) {  // 'true' to append to the file
                fos.write((message + "\n").getBytes());
                fos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class CustomConsoleLogger extends CustomLogger {

        @Override
        public void log(String message) {
            System.out.println(
                "[ " +Thread.currentThread().getName()+ " ] " + 
                LocalDateTime.now().toString() +" "+
                message
            );
        }
    }

    private class CustomFrameLogger extends CustomLogger {
        JFrame frame;
        JTextArea textArea;
        JButton clearButton;
        
        CustomFrameLogger() {
            frame = new JFrame();
            textArea = new JTextArea();
            clearButton = new JButton();
            textArea.setRows(10);
            textArea.setSize(300, 250);
            clearButton.setText("Clear");
        
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                }
            });
        
            frame.setLayout(new BorderLayout());
            frame.add(textArea, BorderLayout.CENTER);
            frame.add(clearButton, BorderLayout.SOUTH);
        
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        @Override
        public void log(String message) {
            textArea.append(message + "\n");
        }
    }   

    static enum CustomLoggers {
        CustomFileLogger,
        CustomConsoleLogger,
        CustomFrameLogger
    }
}
