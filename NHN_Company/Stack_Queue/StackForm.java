package com.nhn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackForm extends JFrame {

    StackClass sClass = new StackClass() ;
    DefaultTableModel model;
    int size=0;    
    final int maxSize = 100;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btGetSize;
    private JButton btPush;
    private JButton btPop;
    private JButton btTop;
    private JLabel lbTop;
    private JLabel lbPop;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private JTextField tfSize;
    private JTextField tfPush;
    // End of variables declaration//GEN-END:variables

    private JPanel rootPanel;
    
    StackForm(){
        add(rootPanel);
        initComponents();
        setTitle("STACK");
        setSize(500,500);
    }


    private void initComponents() {

        jScrollPane = new JScrollPane();
        jTable = new JTable();
        tfPush = new JTextField();
        tfSize = new JTextField();
        lbPop = new JLabel();
        lbTop = new JLabel();
        btPush = new JButton();
        btPop = new JButton();
        btGetSize = new JButton();
        btTop = new JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Stack"
                }
        ));

        // Allow table scroll if size is big
        jScrollPane.setViewportView(jTable);

        // Get size of stack
        btGetSize.setText("setSize");
        btGetSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btGetSizeActionPerformed(evt);
            }
        });

        // Push a element to stack
        btPush.setText("Push");
        btPush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btPushActionPerformed(evt);
            }
        });

        // Pop top element to stack and show it on form
        btPop.setText("Pop");
        btPop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btPopActionPerformed(evt);
            }
        });

        // Show top element on form
        btTop.setText("Top");
        btTop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btTopActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(330, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbPop, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btPop, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbTop, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btTop, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(tfSize, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfPush))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btGetSize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btPush, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btGetSize)
                                                        .addComponent(tfSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfPush, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btPush))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btPop)
                                                        .addComponent(lbPop, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btTop)
                                                        .addComponent(lbTop, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 189, Short.MAX_VALUE))
                                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This function get size of stack from user
     * @param evt
     */
    private void btGetSizeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btGetSizeActionPerformed
        try {

            int p = Integer.parseInt(tfSize.getText());

            if(p > 0 && p<maxSize){
                size = p;
                sClass = new StackClass(p);
                model = new DefaultTableModel();
                model.addColumn("Stack                    Size: " +p);
                for(int i=0 ; i < p ; i++){
                    model.addRow(new Object[]{ ""});
                }

                jTable.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(rootPanel,"Please enter a valid Size (0<size<100)");
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(rootPanel,"Please enter a valid Size (0<size<100)");
    }

    }//GEN-LAST:event_btGetSizeActionPerformed

    /**
     * This function get Input for Stack from user
     * @param evt
     */
    private void btPushActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btPushActionPerformed
        lbPop.setText("");
        lbTop.setText("");
        if (sClass.isfull()){
            JOptionPane.showMessageDialog(rootPanel,"Stack is full");
            return;
        }
        sClass.push(tfPush.getText());
        tfPush.setText("");
        updateTable();

    }//GEN-LAST:event_btPushActionPerformed

    /**
     * This function pop a element in stack and show it to form
     * and update table
     * @param evt
     */
    private void btPopActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btPopActionPerformed
        lbTop.setText("");
        if ( sClass.isempty() ){
            lbPop.setText("Stack is empty!");
            return;
        };
        lbPop.setText("popped :  " + sClass.pop().toString());
        updateTable();
    }//GEN-LAST:event_btPopActionPerformed

    /**
     * This function get Top element of stack and show it on form
     * @param evt
     */
    private void btTopActionPerformed(ActionEvent evt){
        if ( sClass.isempty() ){
            lbTop.setText("Stack is empty!");
            return;
        };
        lbTop.setText("Top: " + sClass.top().toString());
    };

    /**
     * This function update information for table in form
     */
    private void updateTable(){
        Object[] s = sClass.getStack();

        // update white string for table
        for(int i =0;i<size;i++){
            jTable.setValueAt("", i, 0);

        }

        // update value of stack for table
        for(int i =0;i<sClass.getSC();i++){
            jTable.setValueAt(s[i].toString(), i, 0);
        }
    }

}
