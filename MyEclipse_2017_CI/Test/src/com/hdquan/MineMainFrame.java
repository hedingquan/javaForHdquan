package com.hdquan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MineMainFrame extends JFrame implements ActionListener {
   JButton reStart;
   Block block[][];
   BlockView blockView[][];
   LayMines lay;
   int row=10,colum=12,mineCount=22;
   int colorSwitch=0;
   JPanel pCenter,pNorth;
   public MineMainFrame() {
       reStart=new JButton("重新开始");
       pCenter=new JPanel();
       pNorth=new JPanel();
       pNorth.setBackground(Color.cyan);
       block=new Block[row][colum];
       for(int i=0;i<row;i++) {
          for(int j=0;j<colum;j++) 
             block[i][j]=new Block();
       }
       lay=new LayMines();
       lay.layMinesForBlock(block,mineCount);    
       blockView=new BlockView[row][colum];
       pCenter.setLayout(new GridLayout(row,colum));
       for(int i=0;i<row;i++) {
         for(int j=0;j<colum;j++) {
              blockView[i][j]=new BlockView(); 
              blockView[i][j].setName(block[i][j].getName());
              pCenter.add(blockView[i][j]);
              blockView[i][j].getBlockCover().addActionListener(this);
         }
       }
      reStart.addActionListener(this);
      pNorth.add(reStart);
      add(pNorth,BorderLayout.NORTH);
      add(pCenter,BorderLayout.CENTER);
      setSize(200,232);
      setVisible(true);
      validate();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      JButton source=(JButton)e.getSource();
      if(source!=reStart) {  
        int m=-1,n=-1; 
        for(int i=0;i<row;i++) {
          for(int j=0;j<colum;j++) {
            if(source==blockView[i][j].getBlockCover()) {
                m=i;
                n=j;
                break;
            }
          }
        }
        if(block[m][n].isMine()) {
          for(int i=0;i<row;i++) {
             for(int j=0;j<colum;j++) {
                blockView[i][j].getBlockCover().removeActionListener(this);
                if(block[i][j].isMine())
                  blockView[i][j].seeBlockName(); 
             }
          }
        }
        else {
           if(block[m][n].getNumber()>0)
             blockView[m][n].seeBlockName();
           else if(block[m][n].getNumber()==0)
           for(int k=Math.max(m-1,0);k<=Math.min(m+1,row-1);k++) {
              for(int t=Math.max(n-1,0);t<=Math.min(n+1,colum-1);t++) 
                blockView[k][t].seeBlockName(); 
           }
        }
      }
      if(source==reStart) {
         for(int i=0;i<row;i++) {
           for(int j=0;j<colum;j++)
              block[i][j].setIsMine(false);
         }
         lay.layMinesForBlock(block,mineCount); 
         for(int i=0;i<row;i++) {
           for(int j=0;j<colum;j++) {  
               blockView[i][j].setName(block[i][j].getName());
               blockView[i][j].seeBlockCover();
               blockView[i][j].getBlockCover().addActionListener(this);
           }
         }
      }
   }
   public static void main(String args[]) {
      new MineMainFrame();
   }
}

