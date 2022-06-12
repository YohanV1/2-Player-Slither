import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MenuFrame
{
    static String x = "";
    static String x1 =  "";
    static Font font_ = new Font("Burbank Big Condensed Black", Font.BOLD, 50);
    static Font font= new Font("Burbank Big Condensed Black", Font.BOLD, 25);
    static JFrame f;
    static JFrame f1;
    static Frame q;
    static JComboBox cb;
    static JLayeredPane p = new JLayeredPane();
    static JTextField tf, tf1;
    static int i;
    public static void main(String[] args)
    {
        x = "";
        f = new JFrame("https://slitherbyyohqn.com");

        JLabel label = new JLabel("S L I T H E R");

        label.setLocation(522, -150);
        label.setSize(700, 400);

        JLabel background = new JLabel(new ImageIcon("images/wallp.png"));
        background.setSize(1366,768);

        label.setFont(font_);

        JLabel label1 = new JLabel("Player 1:");
        label1.setLocation(395,0);
        label1.setSize(700, 400);
        label1.setFont(font);

        JLabel label2 = new JLabel("Player 2:");
        label2.setLocation(705,0);
        label2.setSize(700, 400);
        label2.setFont(font);

        JLabel label3 = new JLabel("Set Speed:");
        label3.setLocation(632,300);
        label3.setSize(90, 20);

        tf = new JTextField(30);
        tf.setLocation(395,225);
        tf.setSize(250,40);

        tf1 = new JTextField(30);
        tf1.setLocation(705,225);
        tf1.setSize(250,40);

        JButton b2 = new JButton("Play Game!");    
        b2.setBounds(525,375,300,100);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.setFont(font);

        String[] speeds = {"0.5x", "1x","2x","4x"};

        cb = new JComboBox(speeds);
        cb.setBounds(632,320,90,20);
        cb.setSelectedIndex(1);
        cb.setVisible(true);
        p.add(cb, JLayeredPane.POPUP_LAYER);

        p.add(b2, JLayeredPane.POPUP_LAYER);
        p.add(label, JLayeredPane.POPUP_LAYER);
        p.add(label1, JLayeredPane.POPUP_LAYER);
        p.add(label3, JLayeredPane.POPUP_LAYER);
        p.add(label2, JLayeredPane.POPUP_LAYER);
        p.add(tf, JLayeredPane.POPUP_LAYER);
        p.add(tf1, JLayeredPane.POPUP_LAYER);
        p.add(background, JLayeredPane.DEFAULT_LAYER);

        f.add(p);
        f.setVisible(true);        
        f.setSize(1366,768);

        b2.addActionListener(new ActionListener()
            {

                public void actionPerformed(ActionEvent e)

                {

                    try{

                        i = cb.getSelectedIndex();
                        x = tf.getText();
                        x1= tf1.getText();
                        tf.setText("");
                        tf1.setText("");
                        if(x.equals("") || x.equals(" ") || x1.equals("") || x1.equals(" "))
                        {

                            JPanel panel = new JPanel();

                            JOptionPane.showMessageDialog(panel, "Enter Both the Player's Names!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        else
                        {
                            f.dispose();
                            q = new Frame();
                            f1.add(q);
                        }

                    }catch(Exception e1)
                    {
                    }}

            });
    }
}