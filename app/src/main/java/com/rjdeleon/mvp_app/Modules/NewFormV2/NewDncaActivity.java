package com.rjdeleon.mvp_app.Modules.NewFormV2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaActivityBinding;

public class NewDncaActivity extends AppCompatActivity implements NewDncaContract.View {

    private NewDncaPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new NewDncaPresenter(this);
        NewDncaActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.new_dnca_activity);

//        Toolbar toolbar = findViewById(R.id.custom);
//        setSupportActionBar(toolbar);
        binding.setPresenter(mPresenter);
    }

    @Override
    public void navigateBack(View view) {
        finish();
    }
}
