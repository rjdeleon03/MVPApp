package com.cpu.quikdata.Views.Activities;

import com.cpu.quikdata.Modules.Home.HomeActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HomeActivityTest {

    private HomeActivity mActivity;

    @Before
    public void setUp() throws Exception {
        this.mActivity = new HomeActivity();
    }

    @After
    public void tearDown() throws Exception {
        this.mActivity = null;
    }

    @Test
    public void onCreate() {
        assertTrue(this.mActivity != null);
    }

    @Test
    public void navigateToNewDnca() {
    }
}