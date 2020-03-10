package com.hdquan;

import java.awt.*;
import javax.swing.*;
public class BlockView extends JPanel {
   JLabel blockName;
   JButton blockCover;
   CardLayout card;
   BlockView() {
     card=new CardLayout();
     setLayout(card);
     blockName=new JLabel();
     blockCover=new JButton(); 
     add("cover",blockCover);
     add("name",blockName);
   }
   public void setName(String name) {
     blockName.setText(name);
   }
   public String getName() {
     return blockName.getText();
   }
   public void seeBlockName() {
      card.show(this,"name");
      validate();
   }
   public void seeBlockCover() {
      card.show(this,"cover");
      validate();
   }
   public JButton getBlockCover() {
      return blockCover;
   } 
}
