package mylovelypaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUI_Frame extends JFrame{

	private DrawingAndTypingPanel drawingAndTypingPanel;
	private JLabel jlshape, jlsize, jlcolor, jlfont, jlstyles;
	static JButton jbreset;
	

	public GUI_Frame(){
		setTitle("GUI_Paint_Program");
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout());
		drawingAndTypingPanel = new DrawingAndTypingPanel();

		JPanel westJP = new JPanel();
		westJP.setLayout(new GridLayout(6,1));


		ColorChooserPanel colorChooserJP = new ColorChooserPanel();
		jlcolor = new JLabel("Colors");
		//westJP.add(jlcolor);
		mainJP.add(colorChooserJP, BorderLayout.NORTH);
		mainJP.add(westJP, BorderLayout.WEST);
				

//reset button
		JButton jbreset = new JButton("Reset");
		jbreset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawingAndTypingPanel.setBackground(Color.WHITE);
				drawingAndTypingPanel.repaint();
				
			}
		});
		add(jbreset);
		mainJP.add(jbreset, BorderLayout.SOUTH);


//DrawingAndTypingPanel		
		mainJP.add(drawingAndTypingPanel, BorderLayout.CENTER);
		add(mainJP);

//Section that stores Shapes
		jlshape = new JLabel("Shapes");
		westJP.add(jlshape);
		ShapeSelectionPanel shapeSelectionPanel = new ShapeSelectionPanel();
		westJP.add(shapeSelectionPanel);

//Section that stores Shape Sizes
		jlsize = new JLabel("Sizes");
		westJP.add(jlsize);	
		SizeSelectionPanel sizeSelectionPanel = new SizeSelectionPanel();
		westJP.add(sizeSelectionPanel);

	
//Section that stores Fonts
	jlfont = new JLabel("Fonts");
	westJP.add(jlfont);
	FontPanel fontPanel = new FontPanel();
	westJP.add(fontPanel);
	}
	private class ShapeSelectionPanel extends JPanel implements ActionListener{
		private JRadioButton [] radBtnArr;
		private ButtonGroup radBtnGroup;
		private final int NUM_SHAPES = DrawingPanel.shapeNames.length;

		public ShapeSelectionPanel(){
			radBtnGroup = new ButtonGroup();
			radBtnArr = new JRadioButton[NUM_SHAPES];
			setLayout(new GridLayout(NUM_SHAPES,1));
			for(int i=0; i<radBtnArr.length; i++){
				radBtnArr[i] = new JRadioButton(DrawingPanel.shapeNames[i]);//initialized and put a String of text
				radBtnArr[i].setActionCommand(DrawingPanel.shapeNames[i]);//set the ActionCommand
				radBtnArr[i].addActionListener(this);//make it listen for events to trigger the actionPerformed
				radBtnGroup.add(radBtnArr[i]);//add to the group so only 1 is selected at a time
				add(radBtnArr[i]);//add the radio button to the ShapeSelection JPanel
			}
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			String actCmd = e.getActionCommand();
			drawingAndTypingPanel.setShape(actCmd);
		}
	}
	private class ColorChooserPanel extends JPanel implements ActionListener{
		  private JButton jb;
		  private JColorChooser colChooser;
		  private ImageIcon jbImg = new ImageIcon("images/colorpalette.png");
		  public ColorChooserPanel(){
		   colChooser = new JColorChooser();
		   jb = new JButton();
		   jb.addActionListener(this);
		   
		     Image colorpalette = ((ImageIcon) jbImg).getImage();
		       jbImg = new ImageIcon(colorpalette.getScaledInstance(500, 100, Image.SCALE_FAST));
		       jb = new JButton(jbImg);
		       jb.addActionListener(this);
		       add(jb);
		  }

		@Override
		public void actionPerformed(ActionEvent e) {
			Color chosenColor =
					colChooser.showDialog(null,
							"Choose Color",
							drawingAndTypingPanel.getColor());
			drawingAndTypingPanel.setColor(chosenColor);
		}
	}

	private class SizeSelectionPanel extends JPanel implements ActionListener{
		private JRadioButton [] radBtnArr;
		private ButtonGroup radBtnGroup2;
		private final int NUM_SIZES = DrawingPanel.shapeSize.length;
		public SizeSelectionPanel(){
			radBtnGroup2 = new ButtonGroup();
			radBtnArr = new JRadioButton[NUM_SIZES];
			setLayout(new GridLayout(NUM_SIZES,1));

			for(int i = 0; i < radBtnArr.length; i++) {
				radBtnArr[i] = new JRadioButton(DrawingPanel.shapeSize[i]);
				radBtnArr[i].setActionCommand(DrawingPanel.shapeSize[i]);
				radBtnArr[i].addActionListener(this);
				radBtnGroup2.add(radBtnArr[i]);
				add(radBtnArr[i]);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e2) {
			String actCmd2 = e2.getActionCommand();
			drawingAndTypingPanel.setSize(actCmd2);
			//drawingPanel1.setSize(actCmd2);
		}
	}
	
	private class FontPanel extends JPanel implements ActionListener{
		String[] fonts = {"Arial", "Brush Script MT", "Serif", "Castellar", "Magneto", "Impact"};
		JComboBox<String> list = new JComboBox<String>(fonts);
		public FontPanel(){
			list.setSelectedIndex(0);
			list.addActionListener(this);
			add(list);
			}

		@Override
		public void actionPerformed(ActionEvent e3) {
			String actCmd3 = e3.getActionCommand();
			if(e3.getSource() == list) {
				JComboBox box = (JComboBox)e3.getSource();
				String fonts = (String)box.getSelectedItem();
				switch (fonts) {
				case "Arial": 
					DrawingAndTypingPanel.FONT_NAME = DrawingAndTypingPanel.ARIAL;
					break;
				case "Brush Script MT": 
					DrawingAndTypingPanel.FONT_NAME = DrawingAndTypingPanel.BRUSHSCRIPTMT;
					break;
				case "Serif": 
					DrawingAndTypingPanel.FONT_NAME = DrawingAndTypingPanel.SERIF;
					break;
				case "Castellar": 
					DrawingAndTypingPanel.FONT_NAME = DrawingAndTypingPanel.CASTELLAR;
					break;
				case "Magneto": 
					DrawingAndTypingPanel.FONT_NAME = DrawingAndTypingPanel.MAGNETO;
					break;
				case "Impact": 
					DrawingAndTypingPanel.FONT_NAME = DrawingAndTypingPanel.IMPACT;
					break;
				}
			}
		}
	}
}
