package usantatecla.draughts.controllers;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ControllerTest.class,
        LogicTest.class,
        InteractorControllerTest.class,
        StartControllerTest.class,
        ResumeController.class})
public class AllControllers {
}
