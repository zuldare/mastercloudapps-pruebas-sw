package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        usantatecla.draughts.views.AllViews.class,
        usantatecla.draughts.models.AllModels.class,
        usantatecla.draughts.controllers.AllControllers.class
})
public class AllTests {
}
