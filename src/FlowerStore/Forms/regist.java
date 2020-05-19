/*
 * Created by JFormDesigner on Tue May 19 11:17:28 CST 2020
 */

package FlowerStore.Forms;

import java.awt.*;
import javax.swing.*;

/**
 * @author Ruvik
 */
public class regist extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel username;
    private JLabel user;
    private JLabel password1;
    private JLabel password2;
    private JButton regist_button;
    private JTextField username_text;
    private JTextField password1_text;
    private JTextField password2_text;
    public regist() {
        initComponents();
    }

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new regist().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        username = new JLabel();
        user = new JLabel();
        password1 = new JLabel();
        password2 = new JLabel();
        regist_button = new JButton();
        username_text = new JTextField();
        password1_text = new JTextField();
        password2_text = new JTextField();

        //======== this ========
        setTitle("\u6ce8\u518c");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- username ----
        username.setText("REGIST");
        username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 6f));
        contentPane.add(username);
        username.setBounds(167, 60, 108, username.getPreferredSize().height);

        //---- user ----
        user.setText("\u7528\u6237\u540d");
        user.setFont(user.getFont().deriveFont(user.getFont().getSize() + 4f));
        contentPane.add(user);
        user.setBounds(new Rectangle(new Point(80, 140), user.getPreferredSize()));

        //---- password1 ----
        password1.setText("\u5bc6\u7801");
        password1.setFont(password1.getFont().deriveFont(password1.getFont().getSize() + 4f));
        contentPane.add(password1);
        password1.setBounds(80, 225, 40, 22);

        //---- password2 ----
        password2.setText("\u786e\u8ba4\u5bc6\u7801");
        password2.setFont(password2.getFont().deriveFont(password2.getFont().getSize() + 4f));
        contentPane.add(password2);
        password2.setBounds(new Rectangle(new Point(80, 310), password2.getPreferredSize()));

        //---- regist_button ----
        regist_button.setText("\u6ce8\u518c");
        regist_button.setFont(regist_button.getFont().deriveFont(regist_button.getFont().getSize() + 4f));
        contentPane.add(regist_button);
        regist_button.setBounds(140, 460, 120, regist_button.getPreferredSize().height);
        contentPane.add(username_text);
        username_text.setBounds(80, 170, 240, 30);
        contentPane.add(password1_text);
        password1_text.setBounds(80, 255, 240, 30);
        contentPane.add(password2_text);
        password2_text.setBounds(80, 340, 240, 30);

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
        setSize(400, 560);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
