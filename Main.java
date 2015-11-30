import java.util.ArrayList;
import java.util.List;

public class Main {

	static int l;
	static int b;
	static int k;

	public static void main(String[] args) {
		int i = 0;
		String arg;
		GridPosition target = null;
		List<GridPosition> robotsPositions = new ArrayList<GridPosition>();
		while (i < args.length) {
			arg = args[i++];
			if (arg.equals("-l")) {
				l = Integer.parseInt(args[i++]);
			} else if (arg.equals("-b")) {
				b = Integer.parseInt(args[i++]);
			} else if (arg.equals("-k")) {
				k = Integer.parseInt(args[i++]);
			} else if (arg.equals("-t")) {
				String[] position = args[i++].split(",");
				target = new GridPosition(Integer.parseInt(position[0]),
						Integer.parseInt(position[1]));
			} else {
				String[] position = arg.split(",");
				robotsPositions.add(new GridPosition(Integer
						.parseInt(position[0]), Integer.parseInt(position[1])));
			}
		}
		System.out.println("l:" + l + ":b" + b + ":k" + k);
		System.out.println("target:" + target);
		for (GridPosition pos : robotsPositions) {
			System.out.println("pos:" + pos);
		}
		List<Robot> robots = new ArrayList<Robot>();
		for (GridPosition pos : robotsPositions) {
			Robot newRobot = new Robot(pos,target);
			robots.add(newRobot);
		}

		for (Robot robot : robots) {
			robot.setRobots(robots);
			(new Thread(robot)).start();
		}

	}
}

class GridPosition {
	int i, j;

	GridPosition(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public String toString() {
		return new String("[" + this.i + "," + this.j + "]");
	}
}