
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CircleController extends JPanel {
    private MyModel model;
    private JTextField jText = new JTextField();
    private JComboBox<String> jColor = new JComboBox<String>(new String[]{"Black","Red" ,"Blue"});
    private JComboBox jSize = new JComboBox<Integer>(new Integer[]{12,18,24,32});

    /** Creates new form CircleController */
    public CircleController() {
        // Panel to group labels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(new JLabel("Text"));
        panel1.add(new JLabel("color"));
        panel1.add(new JLabel("size"));


        // Panel to group text field, combo box, and another panel
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        panel2.add(jText);
        panel2.add(jColor);
        panel2.add(jSize);

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);

        // Register listeners
        jText.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (model != null) // Set radius in the model
                                            model.setText(jText.getText());
                                    }
                                });
        jColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model != null) // Set filled property value in the model
                    model.setColor(((String) jColor.getSelectedItem()).toString());
            }});
        jSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model != null) // Set filled property value in the model
                    model.setSize(((Integer) Integer.parseInt(jSize.getSelectedItem().toString())));

            }});

    }


    public void setModel(MyModel newModel) {
        model = newModel;
    }

    public MyModel getModel() {
        return model;
    }
}


