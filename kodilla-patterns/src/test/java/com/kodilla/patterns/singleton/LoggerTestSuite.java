package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        // Given
        String newLog = "Something terrible happened, and not a single(ton) person took notice!";

        // When
        Logger.getInstance().log(newLog);

        // Then
        Assert.assertEquals(newLog, Logger.getInstance().getLastLog());
    }

    @Test
    public void testGetLastLogAfterLoggerReinitialisation() {
        // Given
        String newLog = "Something terrible happened, and not a single(ton) person took notice!";

        // When
        Logger firstLogger = Logger.getInstance();
        firstLogger.log(newLog);
        Logger nextLogger = Logger.getInstance();

        // Then
        Assert.assertEquals(newLog, firstLogger.getLastLog());
        Assert.assertEquals(newLog, nextLogger.getLastLog());
    }
}
