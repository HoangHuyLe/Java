package com.nhn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueForm extends JFrame{
    QueueClass qClass = new QueueClass() ;
    DefaultTableModel model;
    int size=0;
    final int maxSize = 100;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btGetSize;
    private JButton btEnqueue;
    private JButton btDequeue;
    private JButton btFront;
    private JLabel lbFront;
    private JLabel lbDequeue;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private JTextField tfSize;
    private JTextField lbEnqueue;
    // End of variables declaration//GEN-END:variables

    private JPanel rootPanel;
    QueueForm(){
        initComponents();
        setTitle("Queue");
        setSize(500,500);
    }


    private void initComponents() {

        jScrollPane = new JScrollPane();
        jTable = new JTable();
        lbEnqueue = new JTextField();
        tfSize = new JTextField();
        lbDequeue = new JLabel();
        lbFront = new JLabel();
        btEnqueue = new JButton();
        btDequeue = new JButton();
        btGetSize = new JButton();
        btFront = new JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Queue"
                }
        ));

        // Allow table scroll if size is big
        jScrollPane.setViewportView(jTable);

        // Get size of Queue
        btGetSize.setText("setSize");
        btGetSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btGetSizeActionPerformed(evt);
            }
        });

        // Push a element to Queue
        btEnqueue.setText("Enqueue");
        btEnqueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btEnqueueActionPerformed(evt);
            }
        });

        // Pop top element to Queue and show it on form
        btDequeue.setText("Dequeue");
        btDequeue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btDequeueActionPerformed(evt);
            }
        });

        // Show top element on form
        btFront.setText("Front");
        btFront.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btFrontActionPerformed(evt);
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
                                                                .addComponent(lbDequeue, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btDequeue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbFront, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btFront, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(tfSize, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbEnqueue))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btGetSize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btEnqueue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                                        .addComponent(lbEnqueue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btEnqueue))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btDequeue)
                                                        .addComponent(lbDequeue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btFront)
                                                        .addComponent(lbFront, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 189, Short.MAX_VALUE))
                                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This function get size of Queue from user
     * @param evt
     */
    private void btGetSizeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btGetSizeActionPerformed
        try {

            int p = Integer.parseInt(tfSize.getText());

            if(p > 0 && p<maxSize){
                size = p;
                qClass = new QueueClass(p);
                model = new DefaultTableModel();
                model.addColumn("Queue                    Size: " +p);
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
     * This function get Input for Queue from user and put into queue
     * @param evt
     */
    private void btEnqueueActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btEnqueueActionPerformed
        lbDequeue.setText("");
        lbFront.setText("");
        if (qClass.isfull()){
            JOptionPane.showMessageDialog(rootPanel,"Queue is full!");
            return;
        }
        qClass.enqueue(lbEnqueue.getText());
        lbEnqueue.setText("");
        updateTable();

    }//GEN-LAST:event_btEnqueueActionPerformed

    /**
     * This function get out a element in Queue and show it to form
     * and update table
     * @param evt
     */
    private void btDequeueActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btDequeueActionPerformed
        lbFront.setText("");
        if ( qClass.isempty() ){
            lbDequeue.setText("Queue is empty!");
            return;
        };
        lbDequeue.setText("Dequeued :  " + qClass.dequeue().toString());
        updateTable();
    }//GEN-LAST:event_btDequeueActionPerformed

    /**
     * This function get Front element of Queue and show it on form
     * @param evt
     */
    private void btFrontActionPerformed(ActionEvent evt){
        if ( qClass.isempty() ){
            lbFront.setText("Queue is empty!");
            return;
        };
        lbFront.setText("Front: " + qClass.front().toString());
    };

    /**
     * This function update information for table in form
     */
    private void updateTable(){
        Object[] s = qClass.getQueue();

        // update white string for table
        for(int i =0;i<size;i++){
            jTable.setValueAt("", i, 0);
        }

        // update value of Queue for table
        for(int i =0; i < qClass.getQC();i++){
            jTable.setValueAt(s[i].toString(), i, 0);
        }
    }
}
