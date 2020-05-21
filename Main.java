package FlowerStore;

import FlowerStore.Forms.login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 设置本机系统外观
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//Nimbus风格，jdk6 update10版本以后的才会出现
            new login().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
