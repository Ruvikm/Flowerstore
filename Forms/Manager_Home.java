/*
 * Created by JFormDesigner on Thu May 14 23:10:50 CST 2020
 */

package FlowerStore.Forms;

import javax.swing.table.*;
import FlowerStore.Entity.Customer;
import FlowerStore.Entity.Flower;
import FlowerStore.Entity.Store;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import static FlowerStore.Forms.Customer_Home.isInteger;

/**
 * @author Ruvik
 */
public class Manager_Home extends JFrame {

    DefaultTableModel OnSellList=new DefaultTableModel();//表格的数据源
    private String head[]=new String[] {"名字", "价格","数量", "颜色"};//销售花的表头
    private String OrderList[]=new String[] {"名字", "单价","数量", "总价","日期"};//订单的表头
    private int StoreID;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel manange_panel;
    private JScrollPane scrollPane2;
    private JTable OnSelll_List;
    private JLabel OnsSellTip;
    private JLabel label12;
    private JLabel label13;
    private JSpinner InNum;
    private JSpinner OutNum;
    private JComboBox comboBoxIn;
    private JComboBox comboBoxOut;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JComboBox comboBoxName;
    private JLabel label17;
    private JComboBox comboBoxColor;
    private JLabel label18;
    private JTextField textFieldNum1;
    private JLabel label19;
    private JTextField textFieldNum2;
    private JButton Choose;
    private JPanel history_panel;
    private JScrollPane scrollPane1;
    private JTable historylist;
    private JLabel history_tip;
    private JPanel information_panel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField_location;
    private JTextField textField_time;
    private JButton Save;
    private JLabel label4;
    private JLabel StoreIDlanel;
    private JComboBox StoreNameBox;
    private JLabel label5;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JPasswordField OrdpasswordField;
    private JPasswordField NewpasswordField;
    private JButton SavePassWord;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public Manager_Home(){
        initComponents();
    }

    private void thisWindowOpened(WindowEvent e) {
        // TODO add your code here
        InitStaticData();
        initHistoryPanel();
        initOnSellList();
    }

    private void StoreNameBoxItemStateChanged(ItemEvent e) {
        // TODO add your code here
        String ChooseName = null;
        if (StoreNameBox.getSelectedItem() != null) {
            ChooseName = (String) StoreNameBox.getSelectedItem();
        } //获取被选中的项
        initInformationPanel(ChooseName);
        initHistoryPanel();
        initOnSellList();
    }

    private void initInformationPanel(String StoreName){
        Store store=new Store();
        store= FactoryService.getFlowerStoreService().CheckStoreByName(StoreName);
        StoreID=store.getStore_id();
        StoreIDlanel.setText(String.valueOf(store.getStore_id()));
        textField_location.setText(store.getStore_location());
        textField_time.setText(store.getStore_Bishours());
    }

    private void initOnSellList(){
        OnSellList = new DefaultTableModel(FactoryService.getFlowerStoreService().Sell_CheckAllFlowers(head,StoreID), head) {
            //使不可编辑
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        if(FactoryService.getFlowerStoreService().Sell_CheckAllFlowers(OrderList,StoreID).length!=0){
            OnSelll_List.setModel(OnSellList);//填充Jtable
            OnSelll_List.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            OnsSellTip.setVisible(false);
            OnSelll_List.setVisible(true);

        }
        else{
            OnsSellTip.setVisible(true);
            OnSelll_List.setVisible(false);
        }

        //清空组件选项
        comboBoxName.removeAllItems();
        comboBoxColor.removeAllItems();
        comboBoxIn.removeAllItems();
        comboBoxOut.removeAllItems();

        //初始化下拉框
        comboBoxName.addItem(null);
        comboBoxColor.addItem(null);

        List<Flower> NameList=FactoryService.getFlowerStoreService().CheckFlowerByStoreID(StoreID);
        //填充名字
        for(Flower v:NameList){
            comboBoxName.addItem(v.getFlower_name());
            comboBoxIn.addItem(v.getFlower_name());
            comboBoxOut.addItem(v.getFlower_name());
        }

        List<String> ColorList=FactoryService.getFlowerStoreService().CheckAllColorsByStoreID(StoreID);
        for(String v:ColorList){
            comboBoxColor.addItem(v);
        }
        comboBoxIn.setSelectedIndex(-1);
        comboBoxOut.setSelectedIndex(-1);
    }

    private void initHistoryPanel(){
        DefaultTableModel tableModelOrders=new DefaultTableModel();//表格的数据源
        tableModelOrders = new DefaultTableModel(FactoryService.getFlowerStoreService().CheckAllStoreOrders(OrderList,StoreID), OrderList) {
            //使不可编辑
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        if(FactoryService.getFlowerStoreService().CheckAllStoreOrders(OrderList,StoreID).length!=0){
            historylist.setModel(tableModelOrders);//填充Jtable
            historylist.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            history_tip.setText("要继续嘎油才会财源滚滚鸭~");

            historylist.setVisible(true);
        }
        else{
            history_tip.setText("宁的生意也太惨谈了8");
            historylist.setVisible(false);
        }
    }

    private void InitStaticData(){
        //商店信息
        List<Store> list=new ArrayList<>();
        list= FactoryService.getFlowerStoreService().CheckAllMyStore();
        for(Store item : list) {
            StoreNameBox.addItem(item.getStore_name());
        }
        initInformationPanel((String) StoreNameBox.getSelectedItem());
    }

    private void SaveActionPerformed(ActionEvent e) {
        // TODO add your code here
        String Name=null;
        String Location=null;
        String WorkTime=null;
        if (StoreNameBox.getSelectedItem() != null) {
            Name = (String) StoreNameBox.getSelectedItem();
        } //获取被选中的项
        if(textField_location.getText()!=null)
            Location=textField_location.getText();
        if(textField_time.getText()!=null)
            WorkTime=textField_time.getText();
        if(FactoryService.getFlowerStoreService().EditInformation(StoreID,Name,Location,WorkTime))
            JOptionPane.showMessageDialog(null, "修改成功！");
        else
            JOptionPane.showMessageDialog(null, "修改出错！");

    }

    private void SavePassWordActionPerformed(ActionEvent e) {
        // TODO add your code here
        String OriginalP = String.valueOf(OrdpasswordField.getPassword());
        String NewP = String.valueOf(NewpasswordField.getPassword());
        if (FactoryService.getFlowerStoreService().ChangePassWord(1,OriginalP,NewP)) {
            JOptionPane.showMessageDialog(null, "修改密码成功！");
        } else
            JOptionPane.showMessageDialog(null, "原密码错误！");

    }

    private void ChooseActionPerformed(ActionEvent e) {
        // TODO add your code here
        String StoreName=FactoryService.getFlowerStoreService().CheckStoreByID(StoreID).getStore_name();
        String flowerName = null;
        String color = null;
        int LowNum = -1;
        int HighNum = -1;
        boolean Num1Flag=true;
        boolean Num2Flag=true;
        if (!textFieldNum1.getText().equals("")) {
            if (isInteger(textFieldNum1.getText())) {
                Num1Flag = true;
                LowNum = Integer.parseInt(textFieldNum1.getText());
            } else {
                JOptionPane.showMessageDialog(null, "最低库存应为大于0的整数！");
                Num1Flag = false;
            }
        }

        if (!textFieldNum2.getText().equals("")) {
            if (isInteger(textFieldNum2.getText())) {
                Num2Flag = true;
                HighNum = Integer.parseInt(textFieldNum2.getText());
            } else {
                JOptionPane.showMessageDialog(null, "最高库存应为大于0的整数！");
                Num2Flag = false;
            }
        }

        if (comboBoxName.getSelectedItem() != null) {
            flowerName = (String) comboBoxName.getSelectedItem();
        }

        if (comboBoxColor.getSelectedItem() != null) {
            color = (String) comboBoxColor.getSelectedItem();
        }
        if (Num1Flag && Num2Flag) {
            OnSellList.getDataVector().clear();
            OnSellList = new DefaultTableModel(FactoryService.getFlowerStoreService().FilterFlowers(flowerName, color, StoreName, LowNum, HighNum, -1, -1, head), head) {
                //使不可编辑
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            if (FactoryService.getFlowerStoreService().FilterFlowers(flowerName, color, StoreName, LowNum, HighNum, -1, -1, head).length != 0) {
                OnSelll_List.setModel(OnSellList);//填充Jtable
                manange_panel.revalidate();
                scrollPane1.validate();
            }
            else
                JOptionPane.showMessageDialog(null, "找不到结果！");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        manange_panel = new JPanel();
        scrollPane2 = new JScrollPane();
        OnSelll_List = new JTable();
        OnsSellTip = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        InNum = new JSpinner();
        OutNum = new JSpinner();
        comboBoxIn = new JComboBox();
        comboBoxOut = new JComboBox();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        comboBoxName = new JComboBox();
        label17 = new JLabel();
        comboBoxColor = new JComboBox();
        label18 = new JLabel();
        textFieldNum1 = new JTextField();
        label19 = new JLabel();
        textFieldNum2 = new JTextField();
        Choose = new JButton();
        history_panel = new JPanel();
        scrollPane1 = new JScrollPane();
        historylist = new JTable();
        history_tip = new JLabel();
        information_panel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField_location = new JTextField();
        textField_time = new JTextField();
        Save = new JButton();
        label4 = new JLabel();
        StoreIDlanel = new JLabel();
        StoreNameBox = new JComboBox();
        label5 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        OrdpasswordField = new JPasswordField();
        NewpasswordField = new JPasswordField();
        SavePassWord = new JButton();
        label6 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);

            //======== manange_panel ========
            {
                manange_panel.setLayout(null);

                //======== scrollPane2 ========
                {

                    //---- OnSelll_List ----
                    OnSelll_List.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\u540d\u5b57", "\u4ef7\u683c", "\u6570\u91cf", "\u989c\u8272"
                        }
                    ));
                    scrollPane2.setViewportView(OnSelll_List);
                }
                manange_panel.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 685, 210);

                //---- OnsSellTip ----
                OnsSellTip.setText("\u5b81\u8fd8\u6ca1\u8fdb\u8d27\u5417\uff1f");
                OnsSellTip.setVisible(false);
                manange_panel.add(OnsSellTip);
                OnsSellTip.setBounds(575, 480, 90, OnsSellTip.getPreferredSize().height);

                //---- label12 ----
                label12.setText("\u8fdb\u8d27");
                label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 2f));
                manange_panel.add(label12);
                label12.setBounds(55, 235, 28, 18);

                //---- label13 ----
                label13.setText("\u51fa\u4ed3");
                label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 2f));
                manange_panel.add(label13);
                label13.setBounds(new Rectangle(new Point(55, 315), label13.getPreferredSize()));

                //---- InNum ----
                InNum.setModel(new SpinnerNumberModel(1, 1, 9999, 5));
                manange_panel.add(InNum);
                InNum.setBounds(105, 265, 90, InNum.getPreferredSize().height);

                //---- OutNum ----
                OutNum.setModel(new SpinnerNumberModel(1, 1, 99999, 5));
                manange_panel.add(OutNum);
                OutNum.setBounds(105, 345, 90, OutNum.getPreferredSize().height);

                //---- comboBoxIn ----
                comboBoxIn.setSelectedIndex(-1);
                manange_panel.add(comboBoxIn);
                comboBoxIn.setBounds(210, 265, 80, comboBoxIn.getPreferredSize().height);

                //---- comboBoxOut ----
                comboBoxOut.setSelectedIndex(-1);
                manange_panel.add(comboBoxOut);
                comboBoxOut.setBounds(210, 345, 80, comboBoxOut.getPreferredSize().height);

                //---- label14 ----
                label14.setText("\u65b0\u589e\u54c1\u79cd");
                label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 2f));
                label14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                manange_panel.add(label14);
                label14.setBounds(new Rectangle(new Point(55, 395), label14.getPreferredSize()));

                //---- label15 ----
                label15.setText("\u7b5b\u9009");
                label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 2f));
                manange_panel.add(label15);
                label15.setBounds(new Rectangle(new Point(390, 235), label15.getPreferredSize()));

                //---- label16 ----
                label16.setText("\u82b1\u540d");
                label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 1f));
                label16.setLabelFor(comboBoxName);
                manange_panel.add(label16);
                label16.setBounds(new Rectangle(new Point(430, 270), label16.getPreferredSize()));

                //---- comboBoxName ----
                comboBoxName.setSelectedIndex(-1);
                manange_panel.add(comboBoxName);
                comboBoxName.setBounds(475, 265, 80, comboBoxName.getPreferredSize().height);

                //---- label17 ----
                label17.setText("\u989c\u8272");
                label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 1f));
                label17.setLabelFor(comboBoxColor);
                manange_panel.add(label17);
                label17.setBounds(new Rectangle(new Point(430, 320), label17.getPreferredSize()));

                //---- comboBoxColor ----
                comboBoxColor.setSelectedIndex(-1);
                manange_panel.add(comboBoxColor);
                comboBoxColor.setBounds(475, 315, 80, comboBoxColor.getPreferredSize().height);

                //---- label18 ----
                label18.setText("\u5e93\u5b58");
                label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 1f));
                manange_panel.add(label18);
                label18.setBounds(new Rectangle(new Point(430, 370), label18.getPreferredSize()));
                manange_panel.add(textFieldNum1);
                textFieldNum1.setBounds(480, 365, 49, 30);

                //---- label19 ----
                label19.setText("\u2014\u2014");
                manange_panel.add(label19);
                label19.setBounds(new Rectangle(new Point(540, 370), label19.getPreferredSize()));
                manange_panel.add(textFieldNum2);
                textFieldNum2.setBounds(570, 365, 49, 30);

                //---- Choose ----
                Choose.setText("\u7b5b\u9009");
                Choose.addActionListener(e -> ChooseActionPerformed(e));
                manange_panel.add(Choose);
                Choose.setBounds(549, 455, 90, Choose.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < manange_panel.getComponentCount(); i++) {
                        Rectangle bounds = manange_panel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = manange_panel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    manange_panel.setMinimumSize(preferredSize);
                    manange_panel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7ba1\u7406\u9c9c\u82b1", manange_panel);

            //======== history_panel ========
            {
                history_panel.setLayout(null);

                //======== scrollPane1 ========
                {

                    //---- historylist ----
                    historylist.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\u540d\u5b57", "\u5355\u4ef7", "\u6570\u91cf", "\u603b\u4ef7", "\u65e5\u671f"
                        }
                    ));
                    historylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    scrollPane1.setViewportView(historylist);
                }
                history_panel.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 690, 305);

                //---- history_tip ----
                history_tip.setText("\u8981\u7ee7\u7eed\u560e\u6cb9\u624d\u4f1a\u8d22\u6e90\u6eda\u6eda\u9e2d~");
                history_tip.setFont(history_tip.getFont().deriveFont(history_tip.getFont().getSize() + 1f));
                history_panel.add(history_tip);
                history_tip.setBounds(65, 400, 400, history_tip.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < history_panel.getComponentCount(); i++) {
                        Rectangle bounds = history_panel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = history_panel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    history_panel.setMinimumSize(preferredSize);
                    history_panel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5386\u53f2\u8ba2\u5355", history_panel);

            //======== information_panel ========
            {
                information_panel.setLayout(null);

                //---- label1 ----
                label1.setText("\u5e97\u94fa\u540d\u5b57");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 1f));
                information_panel.add(label1);
                label1.setBounds(80, 90, 54, 18);

                //---- label2 ----
                label2.setText("\u5e97\u94fa\u5730\u5740");
                label2.setLabelFor(textField_location);
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 1f));
                information_panel.add(label2);
                label2.setBounds(80, 142, 54, 18);

                //---- label3 ----
                label3.setText("\u8425\u4e1a\u65f6\u95f4");
                label3.setLabelFor(textField_time);
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 1f));
                information_panel.add(label3);
                label3.setBounds(80, 194, 54, 18);
                information_panel.add(textField_location);
                textField_location.setBounds(160, 136, 204, 30);
                information_panel.add(textField_time);
                textField_time.setBounds(160, 188, 204, 30);

                //---- Save ----
                Save.setText("\u4fdd\u5b58");
                Save.addActionListener(e -> SaveActionPerformed(e));
                information_panel.add(Save);
                Save.setBounds(516, 240, 110, Save.getPreferredSize().height);

                //---- label4 ----
                label4.setText("StoreID :");
                information_panel.add(label4);
                label4.setBounds(555, 20, 54, 22);

                //---- StoreIDlanel ----
                StoreIDlanel.setText("123");
                information_panel.add(StoreIDlanel);
                StoreIDlanel.setBounds(610, 20, 68, 22);

                //---- StoreNameBox ----
                StoreNameBox.setEditable(true);
                StoreNameBox.addItemListener(e -> StoreNameBoxItemStateChanged(e));
                information_panel.add(StoreNameBox);
                StoreNameBox.setBounds(160, 84, 204, 30);

                //---- label5 ----
                label5.setText("\u5e97\u94fa\u4fe1\u606f");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
                information_panel.add(label5);
                label5.setBounds(new Rectangle(new Point(50, 30), label5.getPreferredSize()));

                //---- label7 ----
                label7.setText("\u4fee\u6539\u5bc6\u7801");
                label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));
                information_panel.add(label7);
                label7.setBounds(new Rectangle(new Point(50, 310), label7.getPreferredSize()));

                //---- label8 ----
                label8.setText("\u539f\u5bc6\u7801");
                label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 1f));
                information_panel.add(label8);
                label8.setBounds(80, 370, 40, 18);

                //---- label9 ----
                label9.setText("\u65b0\u5bc6\u7801");
                label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 1f));
                information_panel.add(label9);
                label9.setBounds(80, 425, 40, 18);
                information_panel.add(OrdpasswordField);
                OrdpasswordField.setBounds(160, 365, 204, 30);
                information_panel.add(NewpasswordField);
                NewpasswordField.setBounds(160, 420, 204, 30);

                //---- SavePassWord ----
                SavePassWord.setText("\u4fdd\u5b58");
                SavePassWord.addActionListener(e -> SavePassWordActionPerformed(e));
                information_panel.add(SavePassWord);
                SavePassWord.setBounds(515, 455, 110, 30);

                //---- label6 ----
                label6.setText("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
                information_panel.add(label6);
                label6.setBounds(85, 275, 550, label6.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < information_panel.getComponentCount(); i++) {
                        Rectangle bounds = information_panel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = information_panel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    information_panel.setMinimumSize(preferredSize);
                    information_panel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7ba1\u7406\u5e97\u94fa", information_panel);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 770, 520);

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
        setSize(780, 560);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
