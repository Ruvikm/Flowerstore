/*
 * Created by JFormDesigner on Thu May 14 23:10:50 CST 2020
 */

package FlowerStore.Forms;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import FlowerStore.Entity.Customer;
import FlowerStore.Entity.Flower;
import FlowerStore.Entity.Store;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.*;

import static FlowerStore.Forms.Customer_Home.isInteger;

/**
 * @author Ruvik
 */
public class Manager_Home extends JFrame {

    DefaultTableModel OnSellList = new DefaultTableModel();//表格的数据源
    private String head[] = new String[]{"名字", "价格", "数量", "颜色"};//销售花的表头
    private String OrderList[] = new String[]{"名字", "单价", "数量", "总价", "日期"};//订单的表头
    private int StoreID;//全局变量ID
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel manange_panel;
    private JScrollPane scrollPane2;
    private JTable OnSelll_List;
    private JLabel OnsSellTip;
    private JLabel label12;
    private JLabel label13;
    private JSpinner JSpinnerIn;
    private JSpinner JSpinnerOut;
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
    private JButton buttonIn;
    private JButton buttonOut;
    private JTextField textFieldName;
    private JTextField textFieldPrice;
    private JTextField textFieldColor;
    private JLabel label10;
    private JLabel label11;
    private JLabel label20;
    private JButton Newbutton;
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
    private JLabel label21;
    private JPanel newStore_panel;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JTextField textName;
    private JTextField textLocation;
    private JTextField textTime;
    private JButton SaveNewStore;
    private JLabel label25;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public Manager_Home() {
        initComponents();
    }



    //region初始化数据

    private static void OnloadPicture(JButton developer,String FileName) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        /** 过滤文件类型 * */
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png","png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(developer);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            /** 得到选择的文件* */
            File[] arrfiles = chooser.getSelectedFiles();
            if (arrfiles == null || arrfiles.length == 0) {
                return;
            }
            FileInputStream input = null;
            FileOutputStream out = null;
            String path = ".\\src\\FlowerStore\\img\\flowers";//相对路径
            try {
                for (File f : arrfiles) {
                    File dir = new File(path);
                    /** 目标文件夹 * */
                    File[] fs = dir.listFiles();
                    HashSet<String> set = new HashSet<String>();
                    for (File file : fs) {
                        set.add(file.getName());
                    }
                    /** 判断是否已有该文件* */
                    if (set.contains(f.getName())) {
                        JOptionPane.showMessageDialog(new JDialog(), f.getName() + ":该文件已存在！");
                        return;
                    }
                    input = new FileInputStream(f);
                    byte[] buffer = new byte[1024];
                    File des = new File(path, FileName+".png");
                    out = new FileOutputStream(des);
                    int len = 0;
                    while (-1 != (len = input.read(buffer))) {
                        out.write(buffer, 0, len);
                    }
                    out.close();
                    input.close();
                }
                JOptionPane.showMessageDialog(null, "上传图片成功！", "提示",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, "上传图片失败！", "提示",
                        JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "上传图片失败！", "提示",
                        JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
        }
    }

    //窗口打开时
    private void thisWindowOpened(WindowEvent e) {
        // TODO add your code here
        InitStaticData();
        initHistoryPanel();
        initOnSellList();
    }

    //个人信息界面
    private void initInformationPanel(String StoreName) {


        Store store = new Store();
        store = FactoryService.getFlowerStoreService().CheckStoreByName(StoreName);
        StoreID = store.getStore_id();
        StoreIDlanel.setText(String.valueOf(store.getStore_id()));
        textField_location.setText(store.getStore_location());
        textField_time.setText(store.getStore_Bishours());
    }

    //查询界面
    private void initOnSellList() {
        OnSellList = new DefaultTableModel(FactoryService.getFlowerStoreService().Sell_CheckAllFlowers(head, StoreID), head) {
            //使不可编辑
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        if (FactoryService.getFlowerStoreService().Sell_CheckAllFlowers(OrderList, StoreID).length != 0) {
            OnSelll_List.setModel(OnSellList);//填充Jtable
            OnSelll_List.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            OnsSellTip.setVisible(false);
            OnSelll_List.setVisible(true);

        } else {
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

        List<Flower> NameList = FactoryService.getFlowerStoreService().CheckFlowerByStoreID(StoreID);
        //填充名字
        for (Flower v : NameList) {
            comboBoxName.addItem(v.getFlower_name());
            comboBoxIn.addItem(v.getFlower_name());
            comboBoxOut.addItem(v.getFlower_name());
        }

        List<String> ColorList = FactoryService.getFlowerStoreService().CheckAllColorsByStoreID(StoreID);
        for (String v : ColorList) {
            comboBoxColor.addItem(v);
        }
        comboBoxIn.setSelectedIndex(-1);
        comboBoxOut.setSelectedIndex(-1);
    }

    //endregion


    //region 商店信息界面

    //账单界面
    private void initHistoryPanel() {
        DefaultTableModel tableModelOrders = new DefaultTableModel();//表格的数据源
        tableModelOrders = new DefaultTableModel(FactoryService.getFlowerStoreService().CheckAllStoreOrders(OrderList, StoreID), OrderList) {
            //使不可编辑
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        if (FactoryService.getFlowerStoreService().CheckAllStoreOrders(OrderList, StoreID).length != 0) {
            historylist.setModel(tableModelOrders);//填充Jtable
            historylist.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            history_tip.setText("要继续嘎油才会财源滚滚鸭~");

            historylist.setVisible(true);
        } else {
            history_tip.setText("宁的生意也太惨谈了8");
            historylist.setVisible(false);
        }
    }

    //加载商店列表
    private void InitStaticData() {
        //商店信息

        List<Store> list = new ArrayList<>();
        list = FactoryService.getFlowerStoreService().CheckAllMyStore();
        for (Store item : list) {
            StoreNameBox.addItem(item.getStore_name());
        }
        initInformationPanel((String) StoreNameBox.getSelectedItem());
    }

    //商店信息中下拉商店变化时
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

    //endregion


    //region 查询界面

    //保存商店信息
    private void SaveActionPerformed(ActionEvent e) {
        // TODO add your code here
        String Name = null;
        String Location = null;
        String WorkTime = null;
        if (StoreNameBox.getSelectedItem() != null) {
            Name = (String) StoreNameBox.getSelectedItem();
        } //获取被选中的项
        if (textField_location.getText() != null)
            Location = textField_location.getText();
        if (textField_time.getText() != null)
            WorkTime = textField_time.getText();
        if (FactoryService.getFlowerStoreService().EditInformation(StoreID, Name, Location, WorkTime))
            JOptionPane.showMessageDialog(null, "修改成功！");
        else
            JOptionPane.showMessageDialog(null, "修改出错！");

    }

    //保存新密码
    private void SavePassWordActionPerformed(ActionEvent e) {
        // TODO add your code here
        String OriginalP = String.valueOf(OrdpasswordField.getPassword());
        String NewP = String.valueOf(NewpasswordField.getPassword());
        if (FactoryService.getFlowerStoreService().ChangePassWord(1, OriginalP, NewP)) {
            JOptionPane.showMessageDialog(null, "修改密码成功！");
        } else
            JOptionPane.showMessageDialog(null, "原密码错误！");

    }

    //查找
    private void ChooseActionPerformed(ActionEvent e) {
        // TODO add your code here
        String StoreName = FactoryService.getFlowerStoreService().CheckStoreByID(StoreID).getStore_name();
        String flowerName = null;
        String color = null;
        int LowNum = -1;
        int HighNum = -1;
        boolean Num1Flag = true;
        boolean Num2Flag = true;
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
            } else
                JOptionPane.showMessageDialog(null, "找不到结果！");
        }

    }

    //进货
    private void buttonInActionPerformed(ActionEvent e) {
        // TODO add your code here
        boolean NameFlag = false;
        boolean NumFlag = false;
        int InNum = 0;
        String Name = null;
        if (comboBoxIn.getSelectedItem() != null) {
            Name = (String) comboBoxIn.getSelectedItem();
            NameFlag = true;
        }
        if ((int) JSpinnerIn.getValue() != 0) {
            InNum = (int) JSpinnerIn.getValue();
            NumFlag = true;
        }

        if (NumFlag && NameFlag) {
            if (FactoryService.getFlowerStoreService().In(StoreID, Name, InNum)) {
                JOptionPane.showMessageDialog(null, "进货成功！");
                initOnSellList();
                JSpinnerIn.setValue(0);
            }
        } else
            JOptionPane.showMessageDialog(null, "进货信息错误！");


    }

    //添加新品种

    //出仓
    private void buttonOutActionPerformed(ActionEvent e) {
        // TODO add your code here
        // TODO add your code here
        boolean NameFlag = false;
        boolean NumFlag = false;
        int OutNum = 0;
        String Name = null;
        if (comboBoxOut.getSelectedItem() != null) {
            Name = (String) comboBoxOut.getSelectedItem();
            NameFlag = true;
        }
        if ((int) JSpinnerOut.getValue() != 0) {
            OutNum = (int) JSpinnerOut.getValue();
            NumFlag = true;
        }

        if (NumFlag && NameFlag) {
            if (FactoryService.getFlowerStoreService().Out(StoreID, Name, OutNum)) {
                JOptionPane.showMessageDialog(null, "出货成功！");
                initOnSellList();
                JSpinnerOut.setValue(0);
            } else
                JOptionPane.showMessageDialog(null, "出仓失败！");
        } else
            JOptionPane.showMessageDialog(null, "出仓信息错误！");
    }


    //endregion


    //region 新增商店界面

    private void SaveNewStoreActionPerformed(ActionEvent e) {
        // TODO add your code here
        String Name = null;
        String Location = null;
        String WorkTime = null;
        boolean NFlag = false;
        boolean LFlag = false;
        boolean WFlag = false;

        if (!textName.getText().equals("")) {
            Name = textName.getText();
            NFlag = true;
        } else {
            JOptionPane.showMessageDialog(null, "名字不能为空！");
        }
        if (!textLocation.getText().equals("")) {
            Location = textLocation.getText();
            LFlag = true;
        } else {
            JOptionPane.showMessageDialog(null, "地址不能为空！");
        }
        if (!textTime.getText().equals("")) {
            WorkTime = textTime.getText();
            WFlag = true;
        } else {
            JOptionPane.showMessageDialog(null, "营业时间不能为空！");
        }

        if (NFlag && LFlag && WFlag) {
            List<Store> storeList = new ArrayList<>();
            Store store = new Store();
            store.setStore_name(Name);
            store.setStore_location(Location);
            store.setStore_Bishours(WorkTime);
            storeList.add(store);
            if (FactoryService.getFlowerStoreService().AddStore(storeList)) {
                JOptionPane.showMessageDialog(null, "新商店开业成功！");
                StoreNameBox.addItem(Name);
            } else
                JOptionPane.showMessageDialog(null, "名字重复！");
        }

    }

    //endregion


    //region 上传图片文件

    private void NewbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here

        boolean NameFlag = false;
        boolean ColorFlag = false;
        boolean PriceFlag = false;

        String NewName = null;
        String NewColor = null;
        int NewPrice = 0;
        if (!textFieldName.getText().equals("")) {
            NewName = textFieldName.getText();
            NameFlag = true;
        }
        if (!textFieldColor.getText().equals("")) {
            NewColor = textFieldColor.getText();
            ColorFlag = true;
        }
        if (!textFieldPrice.getText().equals("")) {
            if (isInteger(textFieldPrice.getText()) && Integer.parseInt(textFieldPrice.getText()) > 0) {
                NewPrice = Integer.parseInt(textFieldPrice.getText());
                PriceFlag = true;
            } else
                JOptionPane.showMessageDialog(null, "价格应为大于0的整数！");
        }
        List<Flower> flowerList = new ArrayList<>();
        Flower flower = new Flower();

        if (NameFlag && ColorFlag && PriceFlag) {
            flower.setFlower_name(NewName);
            flower.setFlower_color(NewColor);
            flower.setFlower_price(NewPrice);
            flower.setStore_id(StoreID);
            flower.setFlower_num(0);
            flowerList.add(flower);
            if (FactoryService.getFlowerStoreService().Cultivate(flowerList)) {
                JOptionPane.showMessageDialog(null, "上传的图片名字请确保和花的名字一致且为png格式！");
                OnloadPicture(Newbutton,NewName);
                JOptionPane.showMessageDialog(null, "添加成功！");
                initOnSellList();
            } else
                JOptionPane.showMessageDialog(null, "该商店已有该品种！");
        } else
            JOptionPane.showMessageDialog(null, "信息错误！");
    }


    //endregion


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        manange_panel = new JPanel();
        scrollPane2 = new JScrollPane();
        OnSelll_List = new JTable();
        OnsSellTip = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        JSpinnerIn = new JSpinner();
        JSpinnerOut = new JSpinner();
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
        buttonIn = new JButton();
        buttonOut = new JButton();
        textFieldName = new JTextField();
        textFieldPrice = new JTextField();
        textFieldColor = new JTextField();
        label10 = new JLabel();
        label11 = new JLabel();
        label20 = new JLabel();
        Newbutton = new JButton();
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
        label21 = new JLabel();
        newStore_panel = new JPanel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        textName = new JTextField();
        textLocation = new JTextField();
        textTime = new JTextField();
        SaveNewStore = new JButton();
        label25 = new JLabel();

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
                scrollPane2.setBounds(0, 0, 685, 200);

                //---- OnsSellTip ----
                OnsSellTip.setText("\u5b81\u8fd8\u6ca1\u8fdb\u8d27\u5417\uff1f");
                OnsSellTip.setVisible(false);
                manange_panel.add(OnsSellTip);
                OnsSellTip.setBounds(575, 480, 90, OnsSellTip.getPreferredSize().height);

                //---- label12 ----
                label12.setText("\u8fdb\u8d27");
                label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 2f));
                manange_panel.add(label12);
                label12.setBounds(45, 225, 28, 18);

                //---- label13 ----
                label13.setText("\u51fa\u4ed3");
                label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 2f));
                manange_panel.add(label13);
                label13.setBounds(new Rectangle(new Point(45, 305), label13.getPreferredSize()));

                //---- JSpinnerIn ----
                JSpinnerIn.setModel(new SpinnerNumberModel(0, 0, 99999, 5));
                manange_panel.add(JSpinnerIn);
                JSpinnerIn.setBounds(95, 255, 70, JSpinnerIn.getPreferredSize().height);

                //---- JSpinnerOut ----
                JSpinnerOut.setModel(new SpinnerNumberModel(0, 0, 99999, 5));
                manange_panel.add(JSpinnerOut);
                JSpinnerOut.setBounds(95, 335, 70, JSpinnerOut.getPreferredSize().height);

                //---- comboBoxIn ----
                comboBoxIn.setSelectedIndex(-1);
                manange_panel.add(comboBoxIn);
                comboBoxIn.setBounds(180, 255, 75, comboBoxIn.getPreferredSize().height);

                //---- comboBoxOut ----
                comboBoxOut.setSelectedIndex(-1);
                manange_panel.add(comboBoxOut);
                comboBoxOut.setBounds(180, 335, 75, comboBoxOut.getPreferredSize().height);

                //---- label14 ----
                label14.setText("\u65b0\u589e\u54c1\u79cd");
                label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 2f));
                manange_panel.add(label14);
                label14.setBounds(new Rectangle(new Point(45, 385), label14.getPreferredSize()));

                //---- label15 ----
                label15.setText("\u7b5b\u9009");
                label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 2f));
                manange_panel.add(label15);
                label15.setBounds(new Rectangle(new Point(410, 225), label15.getPreferredSize()));

                //---- label16 ----
                label16.setText("\u82b1\u540d");
                label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 1f));
                label16.setLabelFor(comboBoxName);
                manange_panel.add(label16);
                label16.setBounds(new Rectangle(new Point(450, 260), label16.getPreferredSize()));

                //---- comboBoxName ----
                comboBoxName.setSelectedIndex(-1);
                manange_panel.add(comboBoxName);
                comboBoxName.setBounds(495, 255, 75, comboBoxName.getPreferredSize().height);

                //---- label17 ----
                label17.setText("\u989c\u8272");
                label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 1f));
                label17.setLabelFor(comboBoxColor);
                manange_panel.add(label17);
                label17.setBounds(new Rectangle(new Point(450, 310), label17.getPreferredSize()));

                //---- comboBoxColor ----
                comboBoxColor.setSelectedIndex(-1);
                manange_panel.add(comboBoxColor);
                comboBoxColor.setBounds(495, 305, 75, comboBoxColor.getPreferredSize().height);

                //---- label18 ----
                label18.setText("\u5e93\u5b58");
                label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 1f));
                manange_panel.add(label18);
                label18.setBounds(new Rectangle(new Point(450, 360), label18.getPreferredSize()));
                manange_panel.add(textFieldNum1);
                textFieldNum1.setBounds(500, 355, 49, 30);

                //---- label19 ----
                label19.setText("\u2014\u2014");
                manange_panel.add(label19);
                label19.setBounds(new Rectangle(new Point(560, 360), label19.getPreferredSize()));
                manange_panel.add(textFieldNum2);
                textFieldNum2.setBounds(590, 355, 49, 30);

                //---- Choose ----
                Choose.setText("\u7b5b\u9009");
                Choose.addActionListener(e -> ChooseActionPerformed(e));
                manange_panel.add(Choose);
                Choose.setBounds(565, 455, 90, Choose.getPreferredSize().height);

                //---- buttonIn ----
                buttonIn.setText("\u8fdb\u8d27");
                buttonIn.addActionListener(e -> buttonInActionPerformed(e));
                manange_panel.add(buttonIn);
                buttonIn.setBounds(265, 255, 65, 30);

                //---- buttonOut ----
                buttonOut.setText("\u51fa\u4ed3");
                buttonOut.addActionListener(e -> buttonOutActionPerformed(e));
                manange_panel.add(buttonOut);
                buttonOut.setBounds(265, 335, 65, 30);
                manange_panel.add(textFieldName);
                textFieldName.setBounds(95, 440, 50, 30);
                manange_panel.add(textFieldPrice);
                textFieldPrice.setBounds(176, 440, 50, 30);
                manange_panel.add(textFieldColor);
                textFieldColor.setBounds(257, 440, 50, 30);

                //---- label10 ----
                label10.setText("\u540d\u5b57");
                manange_panel.add(label10);
                label10.setBounds(new Rectangle(new Point(95, 415), label10.getPreferredSize()));

                //---- label11 ----
                label11.setText("\u4ef7\u683c");
                manange_panel.add(label11);
                label11.setBounds(new Rectangle(new Point(176, 415), label11.getPreferredSize()));

                //---- label20 ----
                label20.setText("\u989c\u8272");
                manange_panel.add(label20);
                label20.setBounds(new Rectangle(new Point(257, 415), label20.getPreferredSize()));

                //---- Newbutton ----
                Newbutton.setText("\u65b0\u589e");
                Newbutton.addActionListener(e -> NewbuttonActionPerformed(e));
                manange_panel.add(Newbutton);
                Newbutton.setBounds(338, 440, 65, 30);

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

                //---- label21 ----
                label21.setText("eg\uff1a7:00---19:00");
                information_panel.add(label21);
                label21.setBounds(new Rectangle(new Point(160, 225), label21.getPreferredSize()));

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
            tabbedPane1.addTab("\u5e97\u94fa\u4fe1\u606f", information_panel);

            //======== newStore_panel ========
            {
                newStore_panel.setLayout(null);

                //---- label22 ----
                label22.setText("\u5e97\u94fa\u540d\u5b57");
                label22.setFont(label22.getFont().deriveFont(label22.getFont().getSize() + 1f));
                label22.setLabelFor(textName);
                newStore_panel.add(label22);
                label22.setBounds(145, 135, 60, label22.getPreferredSize().height);

                //---- label23 ----
                label23.setText("\u5e97\u94fa\u4f4d\u7f6e");
                label23.setFont(label23.getFont().deriveFont(label23.getFont().getSize() + 1f));
                label23.setLabelFor(textLocation);
                newStore_panel.add(label23);
                label23.setBounds(145, 215, 60, 18);

                //---- label24 ----
                label24.setText("\u8425\u4e1a\u65f6\u95f4");
                label24.setFont(label24.getFont().deriveFont(label24.getFont().getSize() + 1f));
                label24.setLabelFor(textTime);
                newStore_panel.add(label24);
                label24.setBounds(145, 295, 60, 18);
                newStore_panel.add(textName);
                textName.setBounds(235, 130, 195, 30);
                newStore_panel.add(textLocation);
                textLocation.setBounds(235, 210, 195, 30);
                newStore_panel.add(textTime);
                textTime.setBounds(235, 290, 195, 30);

                //---- SaveNewStore ----
                SaveNewStore.setText("\u4fdd\u5b58");
                SaveNewStore.addActionListener(e -> SaveNewStoreActionPerformed(e));
                newStore_panel.add(SaveNewStore);
                SaveNewStore.setBounds(525, 435, 90, 30);

                //---- label25 ----
                label25.setText("\u5e97\u94fa\u4fe1\u606f");
                label25.setFont(label25.getFont().deriveFont(label25.getFont().getSize() + 2f));
                newStore_panel.add(label25);
                label25.setBounds(75, 55, label25.getPreferredSize().width, 20);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < newStore_panel.getComponentCount(); i++) {
                        Rectangle bounds = newStore_panel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = newStore_panel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    newStore_panel.setMinimumSize(preferredSize);
                    newStore_panel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u65b0\u589e\u5e97\u94fa", newStore_panel);
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
