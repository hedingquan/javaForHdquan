package com.hdquan;

import java.util.*;
public class LayMines {
   public void layMinesForBlock(Block block[][],int mineCount) {
      int row=block.length;
      int column=block[0].length;
      LinkedList<Block> list=new LinkedList<Block>(); //创建空链表list 
      for(int i=0;i<row;i++) {
         for(int j=0;j<column;j++)
           list.add(block[i][j]); // list添加节点，其中的数据为block[i][j]
      } 
      while(mineCount>0) {
         int size=list.size(); // list返回节点的个数
         int randomIndex=(int)(Math.random()*size);
         Block b= list.get(randomIndex); // list返回索引为randomIndex的节点中的数据
         b.setName("雷");
         b.setIsMine(true);
         list.remove(randomIndex); 
         mineCount--;
      } 
      for(int i=0;i<row;i++) {
         for(int j=0;j<column;j++) {
           if(block[i][j].isMine()){}
           else {
             int mineNumber=0;
             for(int k=Math.max(i-1,0);k<=Math.min(i+1,row-1);k++){
                 for(int t=Math.max(j-1,0);t<=Math.min(j+1,column-1);t++){
                    if(block[k][t].isMine())
                        mineNumber++;         
                 }
             }
             if(mineNumber>0){
               block[i][j].setName(""+mineNumber);
               block[i][j].setNumber(mineNumber);
             }
             else {
               block[i][j].setName(" ");
               block[i][j].setNumber(mineNumber);
             } 
           }
         }    
      }
   }
}
