package com.dennnoval.res;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageLoader extends JComponent {
	private Image image;
	
	public ImageLoader() {
		image = new ImageIcon(getClass().getResource("/com/dennnoval/res/computer_icon.jpg")).getImage();
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D gd = (Graphics2D) graphics.create();
		gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		gd.dispose();
	}
  
  public void setImage(String imgPath) {
		image = new ImageIcon(getClass().getResource(imgPath)).getImage();
	}
}
