import java.awt.*;
import java.awt.event.*;

public class MyView extends javax.swing.JPanel {
    private MyModel model;

    /**
     * Set a model
     */
    public void setModel(MyModel newModel) {
        model = newModel;

        if (model != null)
            // Register the view as listener for the model
            model.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
    }

    public MyModel getModel() {
        return model;
    }


    public Color changeToColor(String clr) {
        if (clr == "Black")
            return Color.BLACK;
        if (clr == "Red")
            return Color.RED;
        if (clr == "Blue")
            return Color.BLUE;

        return Color.BLACK;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (model != null) {
            super.paintComponent(g);
            String text = model.getText();
            String color = model.getColor();
            int size = model.getSize();

            g.setColor(changeToColor(color));
            g.setFont(new Font("Verdana", Font.BOLD, size));
            g.drawChars(text.toCharArray(),0,text.length(),getWidth()/2,getHeight()/2);

        }

    }
}

