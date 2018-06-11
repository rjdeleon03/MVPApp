package com.cpu.quikdata.Presenters;

import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class HomePresenterTest {

    @Mock private HomeContract.View mView;
    @Mock private Button mNewDncaButton;

    private HomePresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mPresenter = new HomePresenter(mView);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void handleNewDncaClick() {
        this.mPresenter.onNewDncaButtonClick(mNewDncaButton);
        verify(mView).navigateToNewDnca();
    }
}