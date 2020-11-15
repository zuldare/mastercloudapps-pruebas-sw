package usantatecla.draughts.controllers;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CancelControllerTest.class,
        ControllerTest.class,
        InteractorControllerTest.class,
        LogicTest.class,
        MoveControllerTest.class,
        PlayControllerTest.class,
        StartControllerTest.class,
        ResumeControllerTest.class
        })
public class AllControllers {
}
