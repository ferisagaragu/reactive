import org.javabrain.rest.helper.Interpret;

public class App {

	public static void main(String[] args) {
		String test = "type as type_1_2 use data";
		System.out.println(Interpret.asUse(test));
		System.out.println(Interpret.asCall(test, 1));
	}

}
