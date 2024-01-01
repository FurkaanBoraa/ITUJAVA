package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int xDelta = width / 2, yDelta = height / 2;
	private BufferedImage img, subImage;

	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		importImg();
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/T_Lilith.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);

	}

	public void changeXDelta(int value) {
		this.xDelta += value;
	}

	public void changeyYDelta(int value) {
		this.yDelta += value;

	}

	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		subImage = img.getSubimage(0, 0, 32, 32);
		g.drawImage(subImage, xDelta, yDelta, 80, 80, null);
	}

}
