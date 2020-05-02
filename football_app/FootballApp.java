import java.util.*;
import java.lang.*;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.*;

public class FootballApp extends javax.swing.JFrame {

    private PlayerTextFile player_file;
    private final int NAME_FIELD = 15;
    private final int SURNAME_FIELD = 15;
    
    
    public FootballApp() {
        initComponents();
        
        player_file = new PlayerTextFile();
        updateComboBox(player1ComboBox);
        updateComboBox(player2ComboBox);
        
        Font font = new Font( "Monospaced", Font.PLAIN, 12 );
        resultsTextArea.setFont( font );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        addPlayerButton = new javax.swing.JButton();
        success1TextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addResultButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        score1TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        score2TextField = new javax.swing.JTextField();
        success2TextField = new javax.swing.JTextField();
        player1ComboBox = new javax.swing.JComboBox<>();
        player2ComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTextArea = new javax.swing.JTextArea();
        showTableButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Entry"));

        jLabel1.setText("First name:");

        jLabel2.setText("Last name:");

        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyTyped(evt);
            }
        });

        addPlayerButton.setText("Add");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addPlayerButton)
                        .addGap(118, 118, 118)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(success1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlayerButton)
                    .addComponent(success1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Results Entry"));

        jLabel3.setText("Player 1:");

        jLabel4.setText("Player 2:");

        addResultButton.setText("Add");
        addResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addResultButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Score");

        jLabel6.setText("-");

        player1ComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player1ComboBoxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(addResultButton)))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(score1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(score2TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                            .addComponent(success2TextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(player1ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player2ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(player1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(player2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(score1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(score2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addResultButton)
                    .addComponent(success2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel7.setText("Table:");

        resultsTextArea.setColumns(20);
        resultsTextArea.setRows(5);
        jScrollPane1.setViewportView(resultsTextArea);

        showTableButton.setText("Show Table");
        showTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTableButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(showTableButton)
                .addGap(30, 30, 30)
                .addComponent(exitButton)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showTableButton)
                    .addComponent(exitButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed
        
        String first_name = nameTextField.getText();
        String surname = surnameTextField.getText();
        
        if (player_file.addPlayer(first_name, surname)){
            success1TextField.setText("Player added!");
            nameTextField.requestFocusInWindow();
            nameTextField.selectAll();
            updateComboBox(player1ComboBox);
            updateComboBox(player2ComboBox);
        }
       
        else{
            JOptionPane.showMessageDialog(this, "The player could not be added", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_addPlayerButtonActionPerformed

    private void updateComboBox(javax.swing.JComboBox<String> box){
        
        box.removeAllItems();
        
        box.addItem("");
        ArrayList<Player> player_list = player_file.getPlayers();
        
        player_list.sort(Comparator.comparing(Player :: getSurname).thenComparing(Player :: getName));
        
        for (Player p : player_list){
            box.addItem(p.getName() + " " + p.getSurname());
        }
    }
    
    private void addResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addResultButtonActionPerformed
        
        String selection1 = (String) player1ComboBox.getSelectedItem();
        String selection2 = (String) player2ComboBox.getSelectedItem();
        
        String[] split1 = selection1.split(" ");
        String[] split2 = selection2.split(" ");
        
        split1 = validatePlayers(split1, split2);
        
        String player_1 = split1[0];
        String player_2 = split2[0];

        int goals_1 = Integer.parseInt(validateScore(score1TextField));
        int goals_2 = Integer.parseInt(validateScore(score2TextField));


        if (player_file.processResult(player_1, player_2, goals_1, goals_2)){
            success2TextField.setText("Result added!");
            player1ComboBox.requestFocusInWindow();
            player1ComboBox.setSelectedIndex(0);
            player2ComboBox.setSelectedIndex(0);
        }
        
        else{
            JOptionPane.showMessageDialog(this, "The result could not be added", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_addResultButtonActionPerformed
 
    private String[] validatePlayers(String[] player1, String[] player2){
        
        String[] split = player1;
        boolean check = player1[0].equals(player2[0]) && player1[1].equals(player2[1]);
        while (check){
            
            List<String> options = new ArrayList<String>();

            ComboBoxModel model = player1ComboBox.getModel();
            int size = model.getSize();
            
            for (int i = 0; i < size; i ++){
                String element = (String) model.getElementAt(i);
                options.add(element);
            }
            
            String[] model2 = new String[options.size()];
            for (int i = 0; i < model.getSize(); i++){
                model2[i] = options.get(i);
            }
            
            String selection = (String) JOptionPane.showInputDialog(this, "The players must be different. Select another player: ", "Invalid Selection", JOptionPane.ERROR_MESSAGE, null, model2, model2[0]);
            player1ComboBox.setSelectedItem(selection);
            split = selection.split(" ");
            
            check = split[0].equals(player2[0]) && split[1].equals(player2[1]);
        }
        
        return split;
        
        
    }

    
    private String validateScore(javax.swing.JTextField textfield){
        
        String number = textfield.getText();
        
        while (!Validator.checkValidNumber(number)){
            String num_entry = JOptionPane.showInputDialog(new JFrame(), "Please enter a valid number", JOptionPane.ERROR_MESSAGE);
            textfield.setText(num_entry);
            number = textfield.getText();
            Validator.checkValidNumber(number);
            
        }
        
        return number;
    }
    
    private void showTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTableButtonActionPerformed
        
        ArrayList<String> results = player_file.formatResults();
        
        String message = "";
        
        for (String s : results){
            message = message + s + "\n";
        }
        
        resultsTextArea.setText(message);
        
    }//GEN-LAST:event_showTableButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void nameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyTyped
        success1TextField.setText("");
        surnameTextField.setText("");
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void player1ComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player1ComboBoxMouseClicked
        score1TextField.setText("");
        score2TextField.setText("");
        success2TextField.setText("");
    }//GEN-LAST:event_player1ComboBoxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FootballApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FootballApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FootballApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FootballApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FootballApp app = new FootballApp();
                app.setVisible(true);
                app.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JButton addResultButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox<String> player1ComboBox;
    private javax.swing.JComboBox<String> player2ComboBox;
    private javax.swing.JTextArea resultsTextArea;
    private javax.swing.JTextField score1TextField;
    private javax.swing.JTextField score2TextField;
    private javax.swing.JButton showTableButton;
    private javax.swing.JTextField success1TextField;
    private javax.swing.JTextField success2TextField;
    private javax.swing.JTextField surnameTextField;
    // End of variables declaration//GEN-END:variables
}
