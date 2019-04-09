package mylovelypaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener,MouseMotionListener{

	public static final int EXTRA_SMALL1 = 10;
	public static final int SMALL1 = 25;
	public static final int MEDIUM1 = 50;
	public static final int LARGE1 = 75;
	public static final int EXTRA_LARGE1 = 100;
	public static final String NO_SHAPE = "none";
	public static final String CIRCLE = "circle";
	public static final String SQUARE = "square";
	public static final String RECTANGLE1 = "rectangle1";
	public static final String RECTANGLE2 = "rectangle2";
	public static final String EXTRA_SMALL = "extra small";
	public static final String SMALL = "small";
	public static final String MEDIUM = "medium";
	public static final String LARGE = "large";
	public static final String EXTRA_LARGE = "extra large";
    public static final String [] shapeNames = {NO_SHAPE, CIRCLE, SQUARE, RECTANGLE1, RECTANGLE2};
	public static final String [] shapeSize = {EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE};

	private int xStart=0, yStart=0;
	private int size;
	private Color color;
	private String shape;
	
	public DrawingPanel(){
		setBackground(Color.WHITE);
		color = Color.BLACK;//default
		size = MEDIUM1;
		shape = NO_SHAPE;
		addMouseListener(this);//make the JPanel listen for mouse events
		addMouseMotionListener(this);//make the JPanel listen for MORE mouse events
		//the section to display the current X&Y coordinate 
		//displayCoords = new JLabel();
		//add(displayCoords);
	}
	private void drawShape(int x, int y){
		Graphics2D g = (Graphics2D)getGraphics();
		g.setColor(color);
		switch(shape){
		case CIRCLE:
			g.drawOval(x - size/2, y - size/2, size, size);
			break;
		case SQUARE:
			g.fillRect(x - size/2, y - size/2, size, size);
			break;
		case RECTANGLE1:
            //Rectangle vertically mirroring Y-Axis:  this mirrors X   this mirrors y
			g.drawRect(x - size/4, y - size/2,        size/2,          size);
			break;
		 case RECTANGLE2:
			  //Rectangle vertically mirroring X-Axis:  this mirrors X   this mirrors y
			 g.fillRect(x - size/2, y - size/4,      size,           size/2);
			 break;
		default:
			shape = NO_SHAPE;
			g.setStroke(new BasicStroke(size/8));
			g.drawLine(x,y,x,y);//hahahaha just a dot
		}
		g.dispose();
	}
	protected void record(int x, int y){
		xStart = x;
		yStart = y;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		drawShape(x, y);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		record(e.getX(),e.getY()); //store the x,y
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();//need for typing
		record(e.getX(), e.getY());//need for typing
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int xEnd = e.getX();
		int yEnd = e.getY();

		Graphics2D g = (Graphics2D)getGraphics();
		g.setStroke(new BasicStroke(size/10));
		g.setColor(color);
		g.drawLine(xStart, yStart, xEnd, yEnd);
		g.dispose();
		record(xEnd,yEnd); //store the x,y
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		record(e.getX(), e.getY());

	}
	public Color getColor(){
		return color;
	}
	public int getDrawingSize(){
		return size;
	}
	
	protected void setColor(Color c){
		color = c;
	}
	protected void setShape(String theShape){
		if(theShape.equalsIgnoreCase(CIRCLE)){
			shape = CIRCLE;
		}
		else if(theShape.equalsIgnoreCase(SQUARE)){
			shape = SQUARE;
		}
		else if(theShape.equalsIgnoreCase(RECTANGLE1)){
	            shape = RECTANGLE1;
	        }
		 else if(theShape.equalsIgnoreCase(RECTANGLE2)){
	            shape = RECTANGLE2;
	        }
		else{
			shape = NO_SHAPE;
			System.out.println("Invalid shape was entered: " + theShape);
		}
	}
	protected void setSize(String theSize) {
		if(theSize.equalsIgnoreCase(EXTRA_SMALL)) {
			size = EXTRA_SMALL1;
		}
		else if(theSize.equalsIgnoreCase(SMALL)) {
			size = SMALL1;
		}
		else if(theSize.equalsIgnoreCase(LARGE)) {
			size = LARGE1;
		}
		else if(theSize.equalsIgnoreCase(EXTRA_LARGE)) {
			size = EXTRA_LARGE1;
		}
		else {
		size = MEDIUM1; 
		System.out.println("Default size was entered: " + theSize);
		}
	}

	public int getLatestX(){
		return xStart;
	}

	public int getLatestY(){
		return yStart;
	}
}
