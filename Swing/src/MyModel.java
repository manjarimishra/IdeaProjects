

import java.awt.event.*;
import java.util.*;

public class MyModel {
    /** Property radius. */
    private String text =  "Brahma";

    /** Property filled. */
    private String color = "Red";

    private int size = 12;

    /** Property color. */
    private java.awt.Color awtColor;

    /** Utility field used by event firing mechanism. */
    private ArrayList<ActionListener> actionListenerList             = new ArrayList<ActionListener>();
    ;

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setText(String text) {
        this.text = text;

        // Notify the listener for the change on text
        processEvent(
                new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "text"));
    }
    public void setColor(String  color) {
        this.color= color;

        // Notify the listener for the change on color
        processEvent(
                new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "color"));
    }
    public void setSize(int size) {
        this.size= size;

        // Notify the listener for the change on size
        processEvent(
                new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "size"));
    }



        /** Register an action event listener */
    public synchronized void addActionListener(ActionListener l) {
        actionListenerList.add(l);
    }

    /** Remove an action event listener */
    public synchronized void removeActionListener(ActionListener l) {
        if ( actionListenerList.contains(l))
            actionListenerList.remove(l);
    }
    /** Fire TickEvent */
    private void processEvent(ActionEvent e) {
        ArrayList<ActionListener> list;

        synchronized (this) {
            list = (ArrayList<ActionListener>)(actionListenerList.clone());
        }

        for (int i = 0; i < list.size(); i++) {
            ActionListener listener = list.get(i);
            listener.actionPerformed(e);
        }
    }
}
