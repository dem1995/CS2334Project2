package cleanMVCCircles;

public class CleanMVCDemoDriver {
	private CleanMVCCircleModel model = new CleanMVCCircleModel();
	private CleanMVCCircleView circleView = new CleanMVCCircleView();
	private CleanMVCFunctionView functionView = new CleanMVCFunctionView();
	private CleanMVCCircleController controller = new CleanMVCCircleController();

	public CleanMVCDemoDriver() {
		circleView.setModel(model);
		controller.setModel(model);
		controller.setFcnView(functionView);
	}

	public static void main(String[] args) {
		new CleanMVCDemoDriver();
	}
}