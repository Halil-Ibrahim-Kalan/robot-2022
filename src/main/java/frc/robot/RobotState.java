package frc.robot;

public class RobotState {
    public enum State {
        DISABLED,
        ENABLED,
        VISION,
    }
    
    private State state;

    public RobotState() {}

    public RobotState.State getState() { 
        return state != null ? state : State.DISABLED;
    }

    public void update(RobotState.State updatedState){
        state = updatedState;
    }
}
