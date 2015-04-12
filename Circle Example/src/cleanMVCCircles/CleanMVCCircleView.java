package cleanMVCCircles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CleanMVCCircleView extends JFrame implements ActionListener {
	private static final long serialVersionUID = -4458385638291201488L;

	private CirclePanel circlePanel = new CirclePanel();

	private CleanMVCCircleModel model;
	
	public CleanMVCCircleView(){
		add(circlePanel);
		setSize(500,200);
		setLocation(400, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		repaint();
	}

	/** Set a model */
	public void setModel(CleanMVCCircleModel newModel) {
		model = newModel;

		if (model != null)
			// Register the view as listener for the model
			model.addActionListener(this);

		repaint();
	}

	public CleanMVCCircleModel getModel() {
		return model;
	}

	class CirclePanel extends JPanel{
		private static final long serialVersionUID = 2063631996957718381L;

		public CirclePanel() {
			// empty
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (model == null) return;

			g.setColor(model.getColor());

			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;
			int radius = (int)model.getRadius();

			if (model.isFilled()) {
				g.fillOval(xCenter - radius, yCenter - radius,
						2 * radius, 2 * radius);
			}
			else {
				g.drawOval(xCenter - radius, yCenter - radius,
						2 * radius, 2 * radius);
			}
		}
	}
}