/*
 * Created by JFormDesigner on Thu May 14 23:10:50 CST 2020
 */

package FlowerStore.Forms;

import java.awt.*;
import javax.swing.*;

/**
 * @author Ruvik
 */
public class Manager_Home extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public Manager_Home(){
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5386\u53f2\u8ba2\u5355", panel2);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //---- label1 ----
                label1.setText("\u5e97\u94fa\u540d\u5b57");
                panel3.add(label1);
                label1.setBounds(new Rectangle(new Point(70, 60), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u5e97\u94fa\u5730\u5740");
                panel3.add(label2);
                label2.setBounds(70, 140, 50, label2.getPreferredSize().height);

                //---- label3 ----
                label3.setText("\u5e97\u94fa\u7ecf\u7406");
                panel3.add(label3);
                label3.setBounds(new Rectangle(new Point(70, 220), label3.getPreferredSize()));
                panel3.add(textField1);
                textField1.setBounds(150, 55, 205, textField1.getPreferredSize().height);
                panel3.add(textField2);
                textField2.setBounds(150, 135, 205, 30);
                panel3.add(textField3);
                textField3.setBounds(150, 215, 205, 30);

                //---- button1 ----
                button1.setText("\u4fdd\u5b58");
                panel3.add(button1);
                button1.setBounds(190, 410, 110, button1.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5e97\u94fa\u4fe1\u606f", panel3);

            //======== panel1 ========
            {
                panel1.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7ba1\u7406\u9c9c\u82b1", panel1);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 865, 565);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(880, 610);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
