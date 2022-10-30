package clinton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class game extends JFrame {

        private JPanel contentPane;
        private JTextField playerGuess;
        private JTextField firstGuessHistory;
        private JTextField secondGuessHistory;
        private JTextField thirdGuessHistory;
        private JTextField winMessage;
        int round = 1;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        game frame = new game();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public game() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(400, 400, 400, 400);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel gameIcon = new JLabel("1.2.3.");
            gameIcon.setForeground(new Color(255, 255, 0));
            gameIcon.setFont(new Font("Tahoma", Font.BOLD, 34));
            gameIcon.setBounds(150, 30, 106, 61);
            contentPane.add(gameIcon);

            playerGuess = new JTextField();
            playerGuess.setBounds(85, 102, 236, 20);
            contentPane.add(playerGuess);
            playerGuess.setColumns(10);

            JButton checkMe = new JButton("Check Me");
            checkMe.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int randomNum =(int) Math.floor(Math.random()*100);
                    int input = Integer.valueOf(playerGuess.getText()).intValue();

                    if(input>=0 && input<=100) {
                        if(input == randomNum) {
                            winMessage.setText("Congratulations you won!");
                        }else if
                        (input == randomNum+10) {winMessage.setText("You are above but too close!");
                        }else if
                        (input == randomNum-10) {winMessage.setText("You are below but too close!");
                        }else if
                        (input > randomNum+10) {winMessage.setText("Your guess is too high!");
                        }else if
                        (input < randomNum-10) {winMessage.setText("Your guess is too low!");
                        }

                        round++;
                        //round ++;lets try using a loop to set the next number
//                       // for (round = 1; round < 4; round ++) {
//                            //performing the checks inside of loop and adding number too the next textfield
//                        }
                        if(round == 1) {firstGuessHistory.setText("You guessed "+input);
                        }
                        else if(round == 2) {secondGuessHistory.setText("You guessed "+input);
                        }

                        else if(round == 3) {thirdGuessHistory.setText("You guessed "+input);
                        }

                        else if(round == 4) {JOptionPane.showConfirmDialog(null,
                                "Opps Game Over! Please restart","Error Message",JOptionPane.ERROR_MESSAGE,
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                    }



                    else {
                        JOptionPane.showConfirmDialog(null,"Please enter a number between 0 and 100","Error Message",JOptionPane.ERROR_MESSAGE,JOptionPane.INFORMATION_MESSAGE);}

                    //round ++;+
                    //}*/

                }});
            checkMe.setEnabled(true);
            checkMe.setForeground(new Color(255, 255, 255));
            checkMe.setBackground(new Color(128, 128, 128));
            checkMe.setBounds(52, 184, 106, 34);
            contentPane.add(checkMe);

            JButton restart = new JButton("Restart");
            restart.setBounds(277, 184, 86, 34);
            contentPane.add(restart);
            


            firstGuessHistory = new JTextField();
            firstGuessHistory.setEditable(false);
            firstGuessHistory.setBounds(85, 235, 236, 28);
            contentPane.add(firstGuessHistory);
            firstGuessHistory.setColumns(10);

            secondGuessHistory = new JTextField();
            secondGuessHistory.setEditable(false);
            secondGuessHistory.setBounds(85, 264, 236, 28);
            contentPane.add(secondGuessHistory);
            secondGuessHistory.setColumns(10);

            thirdGuessHistory = new JTextField();
            thirdGuessHistory.setEditable(false);
            thirdGuessHistory.setBounds(85, 294, 236, 28);
            contentPane.add(thirdGuessHistory);
            thirdGuessHistory.setColumns(10);

            winMessage = new JTextField();
            winMessage.setEditable(false);
            winMessage.setBackground(new Color(207, 201, 69));
            winMessage.setForeground(new Color(128, 0, 64));
            winMessage.setBounds(72, 133, 271, 34);
            contentPane.add(winMessage);
            winMessage.setColumns(10);
        }

    }


