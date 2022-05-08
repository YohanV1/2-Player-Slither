import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Random;

class Gameplay extends JPanel implements KeyListener, ActionListener
{
    MenuFrame ob; 
   
    ImageIcon title;
    ImageIcon rightmouth;
    ImageIcon upmouth;
    ImageIcon downmouth;
    ImageIcon leftmouth;
    ImageIcon sbody;
    ImageIcon enemy;

    ImageIcon title1;
    ImageIcon rightmouth1;
    ImageIcon upmouth1;
    ImageIcon downmouth1;
    ImageIcon leftmouth1;
    ImageIcon sbody1;
    ImageIcon enemy1;

    int xlength[] = new int[750];

    int ylength[] = new int[750];

    int xlength1[] = new int[750];

    int ylength1[] = new int[750];

    int xpose[] = {25,50,75,100,125,150,175,200,225,250,
            275,300,325,350,375,400,425,450,475,
            500,525,550,575,600,625,650,675,700,
            725,750,775,800,825,850};

    int xpose1[] = {25,50,75,100,125,150,175,200,225,250,
            275,300,325,350,375,400,425,450,475,
            500,525,550,575,600,625,650,675,700,
            725,750,775,800,825,850};

    int ypose[] = {75,100,125,150,175,200,225,250,
            275,300,325,350,375,400,425,450,475,
            500,525,550,575,600,625};

    int ypose1[] = {75,100,125,150,175,200,225,250,
            275,300,325,350,375,400,425,450,475,
            500,525,550,575,600,625};

    int speeds[] = {200 ,100, 50, 25};
    Random rand = new Random();

    int xposs = rand.nextInt(34);
    int yposs = rand.nextInt(23);

    int xposs1 = rand.nextInt(34);
    int yposs1 = rand.nextInt(23);

    int check = 0;

    int score = 0;
    int delay = speeds[ob.i];
    int length = 1;
    int moves = 0;    
    int highsc = 0;
    int counter = 0;

    int score1 = 0;
    int delay1 = speeds[ob.i];
    int length1 = 1;
    int moves1 = 0;
    int highsc1 = 0;
    int counter1 = 0;

    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    boolean left1 = false;
    boolean right1 = false;
    boolean up1 = false;
    boolean down1 = false;


    Timer timer;
    String fileName = "highscore.txt";
    String fileName1 = "highscore1.txt";

    Gameplay()
    {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();

    }

    public void paint(Graphics g)
    {
        repaint();
        try {
            Scanner file = new Scanner(new File("highscore.txt"));
            highsc = file.nextInt();

            while(file.hasNextInt()) {

                int number = file.nextInt();
                counter++;

                if(number > highsc) {
                    highsc = number;
                }

            }

            file.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Scanner file = new Scanner(new File("highscore1.txt"));
            highsc1 = file.nextInt();

            while(file.hasNextInt()) {

                int number = file.nextInt();
                counter1++;

                if(number > highsc1) {
                    highsc1 = number;
                }

            }

            file.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        ob = new MenuFrame();
        if(moves==0)
        {          
            xlength[0] = 50;      
            ylength[0] = 100;
        }
        if(moves1==0)
        {          
            xlength1[0] = 800;      
            ylength1[0] = 575;
        }
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55);
        title = new ImageIcon("snaketitle1.png");
        title.paintIcon(this, g, 25, 11);

        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);
        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,575);

        g.setColor(Color.white);
        g.setFont(new Font("Burbank Big", Font.PLAIN, 14));
        g.drawString(ob.x1, 780, 25);

        g.setColor(Color.white);
        g.setFont(new Font("Burbank Big", Font.PLAIN, 14));
        g.drawString(ob.x, 30, 25);

        g.setColor(Color.white);
        g.setFont(new Font("Burbank Big", Font.PLAIN, 14));
        g.drawString("Score:" + (length-1), 30, 43);

        g.setColor(Color.white);
        g.setFont(new Font("Burbank Big", Font.PLAIN, 14));
        g.drawString("Score: " + (length1-1), 780, 43);

        g.setColor(Color.white);
        g.setFont(new Font("Burbank Big", Font.PLAIN, 14));

        if(length-1<highsc)
        {
            g.drawString("High Score: " + highsc, 30, 61);
        }
        if(length>highsc)
        {

            highsc = length-1;
            g.drawString("High Score: " + highsc, 30, 61);
        }

        if(length1-1<highsc1)
        {
            g.drawString("High Score: " + highsc1, 780, 61);
        }
        if(length1>highsc1)
        {

            highsc1 = length1-1;
            g.drawString("High Score: " + highsc1, 780, 61);
        }

        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, xlength[0], ylength[0]);

        leftmouth1 = new ImageIcon("leftmouth1.png");
        leftmouth1.paintIcon(this, g, xlength1[0], ylength1[0]);

        for(int a = 0; a<length; a++)
        {
            if(a==0 && right)
            {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, g, xlength[a], ylength[a]);
            }

            if(a==0 && left)
            {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g, xlength[a], ylength[a]);
            }

            if(a==0 && up)
            {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, g, xlength[a], ylength[a]);
            }

            if(a==0 && down)
            {
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this, g, xlength[a], ylength[a]);
            }

            if(a!=0)
            {
                sbody = new ImageIcon("snakeimage.png");
                sbody.paintIcon(this, g, xlength[a], ylength[a]);
            }
        }

        for(int a1 = 0; a1<length1; a1++)
        {
            if(a1==0 && right1)
            {
                rightmouth1 = new ImageIcon("rightmouth1.png");
                rightmouth1.paintIcon(this, g, xlength1[a1], ylength1[a1]);
            }

            if(a1==0 && left1)
            {
                leftmouth1 = new ImageIcon("leftmouth1.png");
                leftmouth1.paintIcon(this, g, xlength1[a1], ylength1[a1]);
            }

            if(a1==0 && up1)
            {
                upmouth1 = new ImageIcon("upmouth1.png");
                upmouth1.paintIcon(this, g, xlength1[a1], ylength1[a1]);
            }

            if(a1==0 && down1)
            {
                downmouth1 = new ImageIcon("downmouth1.png");
                downmouth1.paintIcon(this, g, xlength1[a1], ylength1[a1]);
            }

            if(a1!=0)
            {
                sbody1 = new ImageIcon("snakeimage1.png");
                sbody1.paintIcon(this, g, xlength1[a1], ylength1[a1]);
            }
        }
        enemy = new ImageIcon("enemy.png");
        enemy1 = new ImageIcon("enemy.png");
        enemy.paintIcon(this, g ,xpose[xposs], ypose[yposs]);
        enemy1.paintIcon(this, g ,xpose1[xposs1], ypose1[yposs1]);
        if((xpose[xposs] == xlength[0] &&  ypose[yposs] == ylength[0]))
        {
            score++;
            length++;
            xposs = rand.nextInt(34);
            yposs = rand.nextInt(23);
        }
        if((xpose1[xposs1] == xlength[0] &&  ypose1[yposs1] == ylength[0]))
        {
            score++;
            length++;
            xposs1 = rand.nextInt(34);
            yposs1 = rand.nextInt(23);
        }  
        if((xpose[xposs] == xlength1[0] &&  ypose[yposs] == ylength1[0]))
        {
            score1++;
            length1++;
            xposs = rand.nextInt(34);
            yposs = rand.nextInt(23);
        }
        if((xpose1[xposs1] == xlength1[0] &&  ypose1[yposs1] == ylength1[0]))
        {
            score1++;
            length1++;
            xposs1 = rand.nextInt(34);
            yposs1 = rand.nextInt(23);
        }

        for(int p1 = 1; p1 < length; p1++)
        {

            if(xlength[p1] == xlength1[0] && ylength[p1] == ylength1[0])
            {
                right1 = false;
                left1 = false;
                up1= false;
                down1= false;
                g.setColor(Color.white);
                g.setFont(new Font("Burbank Big", Font.BOLD, 50));
                g.drawString(ob.x + " Wins!", 300, 300);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Space to RESTART", 350, 340);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Esc Key to EXIT", 365, 380);

                check = 1;

                writescores();
            }
        }
        for(int p1= 1; p1<length1; p1++)
        {
            if(xlength1[p1] == xlength1[0] && ylength1[p1] == ylength1[0])
            {
                right1 = false;
                left1 = false;
                up1= false;
                down1= false;
                g.setColor(Color.white);
                g.setFont(new Font("Burbank Big", Font.BOLD, 50));
                g.drawString(ob.x + " Wins!", 300, 300);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Space to RESTART", 350, 340);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Esc Key to EXIT", 365, 380);

                check = 1;

                writescores();
            }
        }

        for(int p = 1; p < length1; p++)
        {
            if(xlength1[p] == xlength[0] && ylength1[p] == ylength[0])
            {
                right = false;
                left = false;
                up = false;
                down = false;
                g.setColor(Color.white);
                g.setFont(new Font("Burbank Big", Font.BOLD, 50));
                g.drawString(ob.x1 + " Wins!", 300, 300);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Space to RESTART", 350, 340);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Esc Key to EXIT", 365, 380);

                check = 1;

                writescores();
            }
        }
        for(int p = 1; p < length; p++)
        {
            if(xlength[p] == xlength[0] && ylength[p] == ylength[0])
            {
                right = false;
                left = false;
                up = false;
                down = false;
                g.setColor(Color.white);
                g.setFont(new Font("Burbank Big", Font.BOLD, 50));
                g.drawString(ob.x1 + " Wins!", 300, 300);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Space to RESTART", 350, 340);
                g.setFont(new Font("Burbank Big", Font.BOLD, 20));
                g.drawString("Esc Key to EXIT", 365, 380);

                check = 1;

                writescores();
            }
        }

        if(xlength1[0] == xlength[0] && ylength1[0] == ylength[0])
        {
            right1 = false;
            left1 = false;
            up1= false;
            down1= false;
            right = false;
            left = false;
            up = false;
            down = false;
            g.setColor(Color.white);        
            g.setFont(new Font("Burbank Big", Font.BOLD, 50));
            g.drawString("It's a Draw!", 305, 300);
            g.setFont(new Font("Burbank Big", Font.BOLD, 20));
            g.drawString("Space to RESTART", 350, 340);
            g.setFont(new Font("Burbank Big", Font.BOLD, 20));
            g.drawString("Esc Key to EXIT", 365, 380);

            check = 1;

            writescores();
        }
        g.dispose();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(check==0)
        {
            timer.start();

            if(right)
            {
                for(int r = length - 1; r>=0 ; r--)
                {
                    ylength[r+1] = ylength[r];
                }
                for(int r = length; r>=0; r--)
                {
                    if(r==0)
                    {
                        xlength[r] = xlength[r] + 25;
                    }
                    else
                    {
                        xlength[r] = xlength[r-1];
                    }
                    if(xlength[r] > 850)
                    {
                        xlength[r] = 25;
                    }
                }
                repaint();
            }

            if(left)
            {
                for(int r = length - 1; r>=0 ; r--)
                {
                    ylength[r+1] = ylength[r];
                }
                for(int r = length; r>=0; r--)
                {
                    if(r==0)
                    {
                        xlength[r] = xlength[r] - 25;
                    }
                    else
                    {
                        xlength[r] = xlength[r-1];
                    }
                    if(xlength[r] < 25)
                    {
                        xlength[r] = 850;
                    }
                }
                repaint();
            }

            if(up)
            {
                for(int r = length - 1; r>=0 ; r--)
                {
                    xlength[r+1] = xlength[r];
                }
                for(int r = length; r>=0; r--)
                {
                    if(r==0)
                    {
                        ylength[r] = ylength[r] - 25;
                    }
                    else
                    {
                        ylength[r] = ylength[r-1];
                    }
                    if(ylength[r] < 75)
                    {
                        ylength[r] = 625;
                    }
                }
                repaint();
            }

            if(down)
            {
                for(int r = length - 1; r>=0 ; r--)
                {
                    xlength[r+1] = xlength[r];
                }
                for(int r = length; r>=0; r--)
                {
                    if(r==0)
                    {
                        ylength[r] = ylength[r] + 25;
                    }
                    else
                    {
                        ylength[r] = ylength[r-1];
                    }
                    if(ylength[r] > 625)
                    {
                        ylength[r] = 75;
                    }
                }
                repaint();
            }

            if(right1)
            {
                for(int r = length1 - 1; r>=0 ; r--)
                {
                    ylength1[r+1] = ylength1[r];
                }
                for(int r = length1; r>=0; r--)
                {
                    if(r==0)
                    {
                        xlength1[r] = xlength1[r] + 25;
                    }
                    else
                    {
                        xlength1[r] = xlength1[r-1];
                    }
                    if(xlength1[r] > 850)
                    {
                        xlength1[r] = 25;
                    }
                }
                repaint();
            }

            if(left1)
            {
                for(int r = length1 - 1; r>=0 ; r--)
                {
                    ylength1[r+1] = ylength1[r];
                }
                for(int r = length1; r>=0; r--)
                {
                    if(r==0)
                    {
                        xlength1[r] = xlength1[r] - 25;
                    }
                    else
                    {
                        xlength1[r] = xlength1[r-1];
                    }
                    if(xlength1[r] < 25)
                    {
                        xlength1[r] = 850;
                    }
                }
                repaint();
            }

            if(up1)
            {
                for(int r = length1 - 1; r>=0 ; r--)
                {
                    xlength1[r+1] = xlength1[r];
                }
                for(int r = length1; r>=0; r--)
                {
                    if(r==0)
                    {
                        ylength1[r] = ylength1[r] - 25;
                    }
                    else
                    {
                        ylength1[r] = ylength1[r-1];
                    }
                    if(ylength1[r] < 75)
                    {
                        ylength1[r] = 625;
                    }
                }
                repaint();
            }

            if(down1)
            {
                for(int r = length1 - 1; r>=0 ; r--)
                {
                    xlength1[r+1] = xlength1[r];
                }
                for(int r = length1; r>=0; r--)
                {
                    if(r==0)
                    {
                        ylength1[r] = ylength1[r] + 25;
                    }
                    else
                    {
                        ylength1[r] = ylength1[r-1];
                    }
                    if(ylength1[r] > 625)
                    {
                        ylength1[r] = 75;
                    }
                }
                repaint();
            }

        }

    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            moves++;
            right = true;
            if(!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }

            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            moves++;
            left = true;
            if(!right)
            {
                left = true;
            }
            else
            {
                left = false;
                right = true;
            }

            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            moves++;
            up = true;
            if(!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }

            left = false;
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            moves++;
            down = true;
            if(!up)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
            }

            left = false;
            right = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves1++;
            right1 = true;
            if(!left1)
            {
                right1 = true;
            }
            else
            {
                right1 = false;
                left1 = true;
            }

            up1 = false;
            down1 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves1++;
            left1 = true;
            if(!right1)
            {
                left1 = true;
            }
            else
            {
                left1 = false;
                right1 = true;
            }

            up1 = false;
            down1 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            moves1++;
            up1 = true;
            if(!down1)
            {
                up1 = true;
            }
            else
            {
                up1 = false;
                down1 = true;
            }

            left1 = false;
            right1 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves1++;
            down1 = true;
            if(!up1)
            {
                down1 = true;
            }
            else
            {
                down1 = false;
                up1 = true;
            }

            left1 = false;
            right1 = false;
        }
        if(check!=0)
        {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {

                moves= 0;
                score = 0;
                length = 1;
                moves1= 0;
                score1 = 0;
                length1 = 1;
                check = 0;
                repaint();

            }
            else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                MenuFrame.main(null);
            }
        }
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void writescores()
    {
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter outFile = new PrintWriter(bw);

            outFile.println(length-1) ;
            outFile.close();

        }
        catch(IOException e)
        {
            System.err.println(e);
        }

        try{
            FileWriter fw1 = new FileWriter(fileName1, true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter outFile1 = new PrintWriter(bw1);

            outFile1.println(length1-1) ;
            outFile1.close();

        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
} 
