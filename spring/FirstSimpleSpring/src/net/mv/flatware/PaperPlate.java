package net.mv.flatware;

public class PaperPlate implements Plate {

	@Override
	public void holdFood() {
		System.out.println("holding up your food...");

	}

	@Override
	public void disintegrate() {
		System.out.println("time to disintegrate");

	}

}
