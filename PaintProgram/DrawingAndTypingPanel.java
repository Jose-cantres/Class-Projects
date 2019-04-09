package mylovelypaint;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
 
public class DrawingAndTypingPanel extends DrawingPanel implements KeyListener{
 
    private Font font;
    private FontMetrics fm;
    private int fontSize;
    private String fonts;
    protected static String FONT_NAME;
    protected static int FONT_STYLE = Font.PLAIN;
    public static final int BOLD = Font.BOLD;
    public static final int ITALICIZE = Font.ITALIC;
    public static final int BOTHSTYLES = Font.BOLD | Font.ITALIC;
    public static final String ARIAL = "Arial";
	public static final String BRUSHSCRIPTMT = "Brush Script MT";
	public static final String SERIF = "Serif";
	public static final String CASTELLAR = "Castellar";
	public static final String MAGNETO = "Magneto";
	public static final String IMPACT = "Impact";
     
 
    public DrawingAndTypingPanel(){
        super();
        fontSize = DrawingPanel.MEDIUM1;
        FONT_NAME = "Arial";
        font = new Font(FONT_NAME, FONT_STYLE, getDrawingSize());
        addKeyListener(this);//listen for keystrokes...
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
        String s = String.valueOf(e.getKeyChar());
        Graphics2D g = (Graphics2D)getGraphics();
        Font font1 = new Font("Arial", FONT_STYLE, getDrawingSize());
        Font font2 = new Font("Brush Script MT", FONT_STYLE, getDrawingSize());
        Font font3 = new Font("Serif", FONT_STYLE, getDrawingSize());
        Font font4 = new Font("CASTELLAR", FONT_STYLE, getDrawingSize());
        Font font5 = new Font("Magneto", FONT_STYLE, getDrawingSize());
        Font font6 = new Font("Impact", FONT_STYLE, getDrawingSize());
        fm = getFontMetrics(font);
        g.setFont(font);
        g.setColor(getColor());
        switch (FONT_NAME) {
		case ARIAL: 
			g.setFont(font1);
			g.drawString(s, getLatestX()+fm.stringWidth(s), getLatestY());
	        record(getLatestX()+fm.stringWidth(s), getLatestY());
			System.out.println("Default Arial font selected");
			break;
		case BRUSHSCRIPTMT: 
			g.setFont(font2);
			g.drawString(s, getLatestX()+fm.stringWidth(s), getLatestY());
	        record(getLatestX()+fm.stringWidth(s), getLatestY());
			System.out.println("Brush Script MT font selected.");
			break;
    	case SERIF: 
		g.setFont(font3);
		System.out.println("Serif font selected");
		g.drawString(s, getLatestX()+fm.stringWidth(s), getLatestY());
        record(getLatestX()+fm.stringWidth(s), getLatestY());
		break;
    	case CASTELLAR: 
    		g.setFont(font4);
    		System.out.println("Castellar font selected");
    		g.drawString(s, getLatestX()+fm.stringWidth(s), getLatestY());
            record(getLatestX()+fm.stringWidth(s), getLatestY());
    		break;
    	case MAGNETO: 
    		g.setFont(font5);
    		System.out.println("Magneto font selected");
    		g.drawString(s, getLatestX()+fm.stringWidth(s), getLatestY());
            record(getLatestX()+fm.stringWidth(s), getLatestY());
    		break;
    	case IMPACT: 
    		g.setFont(font6);
    		System.out.println("Impact font selected");
    		g.drawString(s, getLatestX()+fm.stringWidth(s), getLatestY());
            record(getLatestX()+fm.stringWidth(s), getLatestY());
    		break;
    	}
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
         
    }
    
    protected void setFonts(String theFont){
		if(theFont.equalsIgnoreCase(ARIAL)){
			FONT_NAME = ARIAL;
		}
		else if(theFont.equalsIgnoreCase(BRUSHSCRIPTMT)){
			FONT_NAME = BRUSHSCRIPTMT;
		}
		else if(theFont.equalsIgnoreCase(SERIF)){
			FONT_NAME = SERIF;
	        }
		 else if(theFont.equalsIgnoreCase(CASTELLAR)){
			 FONT_NAME = CASTELLAR;
	        }
		 else if(theFont.equalsIgnoreCase(MAGNETO)){
			 FONT_NAME = MAGNETO;
	        }
		 else if(theFont.equalsIgnoreCase(IMPACT)) {
			 FONT_NAME = IMPACT;
		 }
		else{
			FONT_NAME = ARIAL;
			System.out.println("Default font selected " + theFont);
		}
	}
}
