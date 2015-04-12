package cleanMVCCircles;

import java.awt.event.*;

public class CleanMVCCircleController {
	private CleanMVCCircleModel model;
	private CleanMVCFunctionView fcnView;

	/** Creates new TrueMVCCircleController */
	public CleanMVCCircleController() {
		// empty
	}

	private class RadiusListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (model == null) return; // No model associated yet. Do nothing
			model.setRadius(new Double(fcnView.getJtfRadius().getText()).doubleValue());
		}
	}

	private class FilledListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (model == null) return; // No model associated yet. Do nothing
			model.setFilled(
					((Boolean)fcnView.getJcboFilled().getSelectedItem()).booleanValue());
		}
	}

	public void setModel(CleanMVCCircleModel newModel) {
		model = newModel;
	}

	public CleanMVCCircleModel getModel() {  // future use
		return model;
	}

	public void setFcnView(CleanMVCFunctionView newView) {
		fcnView = newView;
		
		// Register listeners
		ActionListener radiusListener = new RadiusListener();  // could be anonymous
		fcnView.getJtfRadius().addActionListener(radiusListener);

		ActionListener filledListener = new FilledListener();  // could be anonymous
		fcnView.getJcboFilled().addActionListener(filledListener);
	}

	public CleanMVCFunctionView getFcnView() {  // future use
		return fcnView;
	}
}