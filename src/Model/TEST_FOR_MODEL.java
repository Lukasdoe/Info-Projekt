package Model;
public class TEST_FOR_MODEL {

	public static void main(String[] args) {
		Model model = new Model();
		model.createMaze();
		System.out.println(model.getMaze().toString());
	}

}
