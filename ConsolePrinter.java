import Interfaces.*;

public class ConsolePrinter implements ToUserOutputUI<String>{
	@Override
	public void toOutput(String outputUI) {
		System.out.println(outputUI);
	}
}
