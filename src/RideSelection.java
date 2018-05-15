
public enum RideSelection {
	BumperCar("Bumper Car", 2.50),
	JumpNSmile("Jump and Smile", 2.25),
	MirrorMaze("Mirror Maze", 2.75),
	HauntedHouse("Haunted House", 3.20),
	TopSpin("Top Spin", 2.90),
	Tornado("Tornado", 5.00);
	
	private final String name;
	private final double price;
    private RideSelection(String name, double price) {
        this.name = name;
        this.price = price;
    }

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
