package Exemplo4;

import FrameWork.BaseFrameworkClass4;
import FrameWork.TrackExecution;

public class UserClass extends BaseFrameworkClass4 {

    @TrackExecution
    public void methodOne() {
        System.out.println("Executing methodOne.");
    }

    @TrackExecution
    public void methodTwo() {
        System.out.println("Executing methodTwo.");
    }

    public void methodThree() {
        System.out.println("Executing methodThree.");
    }
}
