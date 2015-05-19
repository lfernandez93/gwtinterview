package com.luis.gwtinterview.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.luis.gwtinterview.gwtinterview";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}