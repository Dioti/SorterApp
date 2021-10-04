package com.sparta.java.sorter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

public class SorterGUI {

    // stores a static reference to Logger - avoids multiple instances
    private static Logger logger = Logger.getLogger("SorterApp");

    public static void main(String[] args) {
        // set up logger
        // by default, uses root of the project
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("Logger created and configured successfully");

        // set Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            logger.debug("Look and Feel set to " + UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
            logger.error("Look and Feel could not be set");
        }

        // set up window
        JFrame app = new JFrame("Sorter");
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add gui pane
        SorterGUIPane pane = new SorterGUIPane(logger);
        logger.info("Created GUI");

        // pack and display
        app.add(pane);
        app.pack();
        app.setLocationRelativeTo(null); // center window
        app.getContentPane().requestFocusInWindow(); // disable autofocus on buttons
        app.setVisible(true);
        logger.info("App is now running");
    }
}
