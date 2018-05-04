package com.rjdeleon.mvp_app.Modules.NewFormV2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewFormV2.Menu.NewDncaMenuFragment;
import com.rjdeleon.mvp_app.Modules.NewFormV2.Menu.NewDncaMenuPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaActivityBinding;

public class NewDncaActivity extends AppCompatActivity implements NewDncaContract.View {

    private NewDncaPresenter mPresenter;
    private NewDncaMenuFragment mMenuFragment;
    private NewDncaMenuPresenter mMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setup presenter and binding for this view
        mPresenter = new NewDncaPresenter(this);
        NewDncaActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.new_dnca_activity);
        binding.setPresenter(mPresenter);

        // Initialize menu fragment and presenter
        // Presenter will bind itself to view once it is constructed
        mMenuFragment = new NewDncaMenuFragment();
        if(findViewById(R.id.nd_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.nd_fragment_container, mMenuFragment).commit();
        }
        mMenuPresenter = new NewDncaMenuPresenter(mMenuFragment);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.custom);
        setSupportActionBar(toolbar);
    }

    @Override
    public void navigateBack(View view) {
        finish();
    }
}
