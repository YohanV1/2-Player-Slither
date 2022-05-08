import javax.swing.*;
import java.awt.*;
class Frame extends JPanel
{
    JFrame z;
    Frame()
    {
        z = new JFrame();
        Gameplay GP = new Gameplay();
        z.setBounds(10,10,905,700);
        z.setBackground(Color.DARK_GRAY);
        z.setResizable(false);
        z.setVisible(true);
        z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        z.add(GP);  
    }
}