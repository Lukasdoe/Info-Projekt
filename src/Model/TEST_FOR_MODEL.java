package Model;

import Liste.LISTE;

public class TEST_FOR_MODEL {

	public static void main(String[] args) {
		Model model = new Model();
		model.createMaze();
		System.out.println(model.getMaze());
	}

}
