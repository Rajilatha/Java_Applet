/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Car extends Applet implements Runnable,ActionListener{
   Thread t;
 
 int x1=0,x2=380,y1=50,y2=250;
  int v; int u; int w;int t1,t2;
  Button g1;
 Button g2;
 Button g3;

 String msg=" ";
 
  void slep()                  //for delay

 {

      try {

    Thread.sleep(20);

          }catch(Exception ex) {

      }

}

   public void start()
 {
  if(t==null)
  {
   t=new Thread(this,"New Thread");//New side Thread created on start of applet.
   t.start();
  }
  
   
 }
   
   public void stop()
 {
  if(t!=null)
  {
   t=null;//On stop of applet the created thread is destroyed.
  }
 }
  
  
    public void init() {
         

         t1=0;t2=1;

 u=300;

 v=260;

 setLayout(new FlowLayout(FlowLayout.CENTER));

 Label l=new Label("Anupam");

 g1=new Button("back");

 add(g1);

 g2=new Button("forward");

 g3=new Button("stop");

 add(g3);add(g2);

 g1.addActionListener(this);

 g2.addActionListener(this);

 g3.addActionListener(this);
         
         Thread t1 = new Thread(this);
        t1.start();
        setSize(60, 60);
    }
    
    

    // TODO overwrite start(), stop() and destroy() methods
int i;
    @Override
    public void run()
 {
  for (i = 0; i < 1000; i += 3) {

            repaint();
   try
   {
    Thread.sleep(100);
   }
   catch(Exception ex)
   { Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);  }
  }
  
  
 }
    
    
    
    public void paint(Graphics g)
 {
     
     drawLetters(g,i);
 drawImage(g);
 car(g);
 drawSun(g,i);
 }
    
 private void drawSun(Graphics g, int i) {
       if(i<180){
           g.setColor(Color.YELLOW);    
        g.fillOval(70, 105-i/2, 80, 80);
        g.setColor(Color.ORANGE);    
        g.fillOval(85, 120-i/2, 50, 50);
        }else{
           g.setColor(Color.YELLOW);    
        g.fillOval(70, 15, 80, 80);
        g.setColor(Color.ORANGE);  
        g.fillOval(85, 30, 50, 50);
    }
 }
       
    public void car(Graphics g)
    {
  setBackground(Color.cyan);
  g.setColor(Color.BLACK);
  x1=(x1+16)%400;
  x2=x2-16;
  y1=(y1+12)%300;
  y2=y2-12;
  if(y2<0)
   y2=288;
  if(x2<0)
   x2=384;
  //Draw the roads using 2 filled rectangles using black color.
  g.fillRect(0,130,400,40);
  g.fillRect(180,0,40,305);
  //Draw the white colored lines.
  g.setColor(Color.white);
  for(int i=0;i<20;i++)
  {
   if(i!=9 && i!=10)
    g.drawLine(i*20,150,i*20+10,150);
  }
  for(int j=0;j<15;j++)
  {
   if(j!=7 && j!=8)
    g.drawLine(200,j*20,200,j*20+10);
  }
  //Draw 4 colored cars using filled round rectangles.
  g.setColor(Color.red);
  g.fillRoundRect(x2,152,20,8,2,2);
  g.fillRoundRect(x1,140,20,8,2,2);
  g.fillRoundRect(190,y1,8,20,2,2);
  g.fillRoundRect(202,y2,8,20,2,2);
  
  
   setBackground(Color.cyan);

       w=getWidth();

       Color c1=new Color(20,160,200);

       Color c2=new Color(200,60,200);

       g.setColor(c1);    

       g.drawLine(0,u+75,w,u+75);

       g.setColor(c2);

       g.fillRoundRect(v,u+20,100,40,5,5);

       g.fillArc(v+90,u+20,20,40,270,180);

       g.setColor(c1);  

       g.fillRoundRect(v+10,u,70,25,10,10);

       g.setColor(Color.white);

       g.fillRect(v+20,u+5,20,25);

       g.fillRect(v+50,u+5,20,25);

       g.setColor(Color.black);

       g.fillRoundRect(v+55,u+10,10,20,10,10);

       g.fillOval(v+10,u+50,25,25);

       g.fillOval(v+60,u+50,25,25);

       g.setColor(Color.white);

       g.fillArc(v+20,u+60,5,5,0,360);

    g.fillArc(v+70,u+60,5,5,0,360);

    slep();
    if(msg.equals("forward"))

  {          
  if(v+360<w)
   {

    v=v+1;
    showStatus("press back for moving backward");

    repaint();
   }
  }
    if(msg.equals("back"))
      {
       if(v>0)
    {
    v=v-1;
    showStatus("press forward for moving forward");
    repaint();}
      }
     
    
}
     public void drawLetters(Graphics g,int x) {//////////////////////////////////////////Letters
        
              
        Font f = new Font("Arial", Font.BOLD, 45);
        g.setFont(f);
         g.setColor(Color.BLACK);  
  
        if(x<280){
        g.drawString("Drive Slowly", x/2-100, 300); 
        }else{
        g.drawString("Drive Slowly", 800, 300); 
        }
        
        
        }
    
public void drawImage(Graphics g) {////////////////////////////////////////////////mountain
      Image img = getImage(getDocumentBase(),"trafficlight.jpg");
      
       g.drawImage(img, 1200, 60, null);
       
        

    }
 

    @Override
    public void actionPerformed(ActionEvent e)

 {

  String s=e.getActionCommand();

 if(s.equals("back"))

 {

  msg="back";

  repaint();

 }

 else if(s.equals("forward"))

    {

     msg="forward";

  repaint();

  }

 else if(s.equals("stop"))

  {

   msg="  ";
   repaint(); }

 }
}