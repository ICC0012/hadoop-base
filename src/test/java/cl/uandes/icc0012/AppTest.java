package cl.uandes.icc0012;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Such tests. Many good practice. Such software engineering.
 */
public class AppTest {
    @Test
    public void testAppCreation() {
        App app = new App();
        // Very relevant test...
        assertTrue("app should be an instance of App", app instanceof App);
    }
}
