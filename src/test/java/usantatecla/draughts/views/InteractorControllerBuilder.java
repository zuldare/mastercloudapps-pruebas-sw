package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class InteractorControllerBuilder {
    
    StartController startController;
    PlayController playController;
    ResumeController  resumeController;

    InteractorControllerBuilder(){
      this.startController = mock(StartController.class);
      this.playController = mock(PlayController.class);
      this.resumeController = mock(ResumeController.class);
    }
}
