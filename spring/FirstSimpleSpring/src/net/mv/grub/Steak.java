package net.mv.grub;

import net.mv.flatware.Plate;

public class Steak implements Food {
	
	private Plate paperPlate;
	private int size;
	
	public Steak(int size){
		this.size = size;
	}
	
	public void setPaperPlate(Plate paperPlate){
		this.paperPlate = paperPlate;
	}

	@Override
	public void getEaten() {
		System.out.println("You ate me!!!");

	}

	@Override
	public void rot() {
		System.out.println("I'm decaying!");

	}

	@Override
	public void tasteDelicious() {
		System.out.println("I taste delicious when eaten rare");

	}

	@Override
	public void setPlate() {
		paperPlate.disintegrate();

	}

	@Override
	public void printSize() {
		System.out.println(this.size);

	}

}
