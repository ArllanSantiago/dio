package asc;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.logging.Logger;

public class UserTest {
    private Logger logger = Logger.getLogger(UserTest.class.getName());

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "arlla")
    @DisabledIfEnvironmentVariable(named = "USERNAME", matches = "lorena")
    void UserAdmin(){
        var userLogado = System.getenv("USERNAME");
        logger.info("UserAdmin:" + userLogado);
        Assumptions.assumeTrue("arlla".equals(userLogado));
    }
}
