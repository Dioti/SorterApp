package com.sparta.java.sorter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SorterGUIPane extends JPanel {


    SorterController controller;
    String[] sortTypes = {"Bubble Sort", "Merge Sort", "Quick Sort", "Binary Tree Sort", "Insertion Sort",
            "Selection Sort", "Collections Sort", "Arrays Sort", "Parallel Sort"};
    int selectedSorterIndex = 0;
    int[] selectedSorters = new int[sortTypes.length];
    int arrSize = 10;
    boolean randArr = false;

    ArrayGenListener agl;
    JTextField arrTextField;
    JLabel arrSizeLabel;
    JSpinner arrSizeSpinner;
    JTextArea displayText;

    Logger logger;

    public SorterGUIPane() {
        this.logger = Logger.getLogger("SorterApp_Test");
        PropertyConfigurator.configure("log4j.properties");
        this.setBorder(new EmptyBorder(5, 5, 5, 5)); // padding
        createGUI();
    }

    public SorterGUIPane(Logger logger) {
        this.logger = logger;
        this.setBorder(new EmptyBorder(5, 5, 5, 5)); // padding
        createGUI();
    }

    private void createGUI() {
        JPanel controls = new JPanel();
        controls.setLayout(new BorderLayout(5, 5));

        // create array generation options
        JPanel arrGen = new JPanel();
        arrGen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Array Generation"));
        arrGen.setLayout(new BoxLayout(arrGen, BoxLayout.Y_AXIS));
        JPanel arrGenTop = new JPanel();
        JPanel arrGenBottom = new JPanel();
        JRadioButton specifyArray = new JRadioButton("Enter an array", true);
        JRadioButton randomArray = new JRadioButton("Use a random array");
        ButtonGroup bg = new ButtonGroup();
        bg.add(specifyArray);
        bg.add(randomArray);
        agl = new ArrayGenListener();
        specifyArray.addActionListener(agl);
        randomArray.addActionListener(agl);
        arrTextField = new JTextField("9,8,7,6,5,4,3,2,1");
        arrTextField.setPreferredSize(new Dimension(200, 20));
        arrTextField.setVisible(!randArr); // set default visibility
        arrSizeLabel = new JLabel("Size:");
        arrSizeLabel.setVisible(randArr); // set default visibility
        arrSizeSpinner = new JSpinner(new SpinnerNumberModel(arrSize, 1, Integer.MAX_VALUE, 1));
        arrSizeSpinner.setVisible(randArr); // set default visibility
        arrSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                SpinnerNumberModel model = (SpinnerNumberModel) ((JSpinner) e.getSource()).getModel();
                arrSize = model.getNumber().intValue();
                logger.debug("arrSize=" + arrSize);
            }
        });

        // add array generation options
        arrGenTop.add(specifyArray);
        arrGenTop.add(randomArray);
        arrGenBottom.add(arrTextField);
        arrGenBottom.add(arrSizeLabel);
        arrGenBottom.add(arrSizeSpinner);
        arrGen.add(arrGenTop);
        arrGen.add(arrGenBottom);
        controls.add(arrGen, BorderLayout.PAGE_START);
        logger.debug("Created GUI elements for array generation");

        // create sorter options
        JPanel sorterOpt = new JPanel();
        sorterOpt.setLayout(new GridLayout(0,3));
        sorterOpt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sort Options"));
        SorterListener sl = new SorterListener();
        for(int i = 0; i < sortTypes.length; i++) {
            JCheckBox cb = new JCheckBox(sortTypes[i]);
            cb.addItemListener(sl);
            if(i == selectedSorterIndex) { // checked by default
                cb.setSelected(true);
            }
            sorterOpt.add(cb);
        }

        JButton sortButton = new JButton("Sort");
        sortButton.setBorder(new EmptyBorder(15,0,15,0));
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String originalStr = "";
                String sortedStr = "";
                long[] times = new long[sortTypes.length];
                for(int i = 0; i < sortTypes.length; i++) {
                    if(selectedSorters[i] == 1) {
                        if (randArr) { // generate random array
                            controller = new SorterController(String.valueOf(i+1), arrSize);
                            logger.debug("Random array -> sortType=" + controller.getSortType() + ", size=" + arrSize);
                        } else { // use user given array
                            int[] arr = textToArray(arrTextField.getText()); // convert string to array
                            controller = new SorterController(String.valueOf(i+1), arr);
                            logger.debug("User given array -> sortType=" + controller.getSortType() + ", size=" + arrSize);
                        }
                        if(i == 0) {
                            originalStr = arrayToString(controller.getArray());
                            logger.debug("Original array: " + originalStr);
                        }
                        logger.info("Starting " + controller.getSortType() + "...");
                        long start = System.nanoTime();
                        controller.sort();
                        long stop = System.nanoTime();
                        logger.info("Sort completed!");
                        if(i == 0) {
                            sortedStr = arrayToString(controller.getArray());
                            logger.debug("Sorted array: " + sortedStr);
                        }
                        times[i] = (stop - start);
                    }
                }
                displayArrays(originalStr, sortedStr, times);

                /*String type = String.valueOf(selectedSorterIndex + 1);
                logger.debug("selectedSorterIndex=" + selectedSorterIndex + ", randArr=" + randArr);
                logger.info("Selected sort type: " + type);
                if(randArr) { // generate random array
                    controller = new SorterController(type, arrSize);
                    logger.debug("SorterController created with a random array of size " + arrSize);
                } else { // use user given array
                    int[] arr = textToArray(arrTextField.getText()); // convert string to array
                    controller = new SorterController(type, arr);
                    logger.debug("SorterController created with a user created array of size " + arr.length);
                }
                String originalStr = arrayToString(controller.getArray());
                logger.debug("Original array: " + originalStr);
                logger.info("Starting sort...");
                long start = System.nanoTime();
                controller.sort();
                long stop = System.nanoTime();
                logger.info("Sort completed!");
                String sortedStr = arrayToString(controller.getArray());
                logger.debug("Sorted array: " + sortedStr);
                displayArrays(originalStr, sortedStr, (stop-start));
                logger.info("Time taken: " + (stop-start) + " nanoseconds");*/
            }
        });

        // add sorter options
        controls.add(sorterOpt);
        controls.add(sortButton, BorderLayout.PAGE_END);
        logger.debug("Created GUI elements for sort type options");

        // add display pane
        JPanel displayPane = new JPanel();
        int h = (int) Math.ceil(controls.getPreferredSize().getHeight());
        displayPane.setPreferredSize(new Dimension(400, h));
        displayPane.setLayout(new BoxLayout(displayPane, BoxLayout.Y_AXIS));
        displayPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Result"));
        displayText = new JTextArea();
        displayText.setEditable(false);
        displayText.setWrapStyleWord(true);
        displayText.setLineWrap(true);
        JScrollPane displayScroll =  new JScrollPane(displayText,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        displayPane.add(displayScroll);
        logger.debug("Created GUI elements for sorted output");

        this.add(controls);
        this.add(displayPane);
    }

    public void displayArrays(String original, String sorted, long timeTaken) {
        String str = "Original array:\n" + original +
                "\n\nSorted array:\n" + sorted +
                "\n\n" + controller.getSortType() + ": " + (timeTaken) + " nanoseconds";
        updateDisplay(str);
        logger.debug("Output has been successfully updated");
    }

    public void displayArrays(String original, String sorted, long[] times) {
        StringBuilder str = new StringBuilder("Original array:\n" + original +
                "\n\nSorted array:\n" + sorted +
                "\n\n");
        for(int i = 0; i < times.length; i++) {
            if(times[i] != 0) {
                String sortTime = sortTypes[i] + ": " + times[i] + " nanoseconds";
                str.append(sortTime);
                logger.info(sortTime);
                if (i < times.length - 1) { // no \n after last element
                    str.append("\n");
                }
            }
        }
        updateDisplay(str.toString());
        logger.debug("Output has been successfully updated");
    }

    public void updateDisplay(String str) {
        displayText.setText(str);
    }

    public int[] textToArray(String str) {
        // do a bit of sanitising
        // TODO: detect non-numeric, non-comma characters in input string
        //  and disable the Sort button if there are
        str = str.replaceAll("\\s",","); // change whitespaces to commas
        str = str.replaceAll(",,",","); // remove possible duplicate commas
        String[] parts = str.split(","); // comma separated
        int[] intArr = new int[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                intArr[i] = Integer.parseInt(parts[i]);
            }
            logger.debug("Input array string was successfully parsed as an int array");
            return intArr;
        } catch (NumberFormatException e) {
            logger.error("Input array string is invalid - does the text contain only ints?");
            return new int[0];
        } catch (Exception e) {
            logger.error("Input array string is invalid");
            e.printStackTrace();
            return new int[0];
        }
    }

    public String arrayToString(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length - 1) { // no space after last element
                str += " ";
            }
        }
        return str;
    }

    class ArrayGenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            logger.debug("The option \"" + str + "\" was selected");
            switch(str) {
                case "Enter an array":
                    randArr = false;
                    break;
                case "Use a random array":
                    randArr = true;
                    break;
                default:
                    logger.error(str + " is not a valid option for array generation");
            }
            arrTextField.setVisible(!randArr);
            arrSizeLabel.setVisible(randArr);
            arrSizeSpinner.setVisible(randArr);
        }
    }

    class SorterListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String type = ((JCheckBox) e.getSource()).getText();
            int index = getIndex(type, sortTypes);
            if(e.getStateChange() == ItemEvent.SELECTED) { // checkbox has been selected
                selectedSorters[index] = 1;
            } else { // checkbox has been deselected
                selectedSorters[index] = 0;
            };
        }
        private int getIndex(String str, String[] arr) {
            for(int i = 0; i < arr.length; i++) {
                if(str.equals(arr[i])) {
                    return i; // index of string
                }
            }
            return -1; // -1 = string not found
        }
    }

}
