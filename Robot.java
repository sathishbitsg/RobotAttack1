import java.util.List;


public class Robot implements Runnable{

	List<Robot> connectedRobots;
	GridPosition initialPosition;
	GridPosition currentPosition;
	GridPosition targetPosition;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " :"+currentPosition);
	}
	Robot(GridPosition pos, GridPosition target){
		this.initialPosition = pos;
		this.currentPosition = pos;
		this.targetPosition = target;
	}
	
	public void setRobots(List<Robot> robots){
		this.connectedRobots = robots;
	}
	public List<Robot> getRobots(){
		return this.connectedRobots;
	}
	
}
