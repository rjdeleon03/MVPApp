package com.rjdeleon.mvp_app.Modules.NewForm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Modules.NewForm.Menu.NewFormMenuPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.Menu.NewFormMenuFragment;
import com.rjdeleon.mvp_app.databinding.NewFormActivityBinding;

public class NewFormActivity extends AppCompatActivity implements NewFormContract.View {

    NewFormPresenter mPresenter;
    NewFormMenuFragment mMenuFragment;
    NewFormMenuPresenter mMenuPresenter;
    TextView mSubtitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        this.mPresenter = new NewFormPresenter(this);
        NewFormActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.new_form_activity);
        binding.setPresenter(mPresenter);

        // Initialize menu fragment and presenter
        this.mMenuFragment = new NewFormMenuFragment();
        this.mSubtitleView = findViewById(R.id.nf_subtitle);
        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.new_form_fragment_container, mMenuFragment).commit();
        }
        mMenuPresenter = new NewFormMenuPresenter(mMenuFragment);

        // Set toolbar title
        mPresenter.updateTitle(mMenuFragment.getFragmentTitle());
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            // If back stack is not empty, go back to previous frame
            closeFragment();

            int backStackCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackCount == 0) {
                mPresenter.updateTitle("New DNCA Form");
                mPresenter.updateSubtitle("");
                return;
            }
            BaseFragment newTopFragment = (BaseFragment) getSupportFragmentManager().getBackStackEntryAt(backStackCount - 1);
            mPresenter.updateTitle(newTopFragment.getFragmentTitle());
            mPresenter.updateSubtitle(newTopFragment.getFragmentTitle());

        } else {
            // Else, revert to previous activity
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public void switchToFragment(BaseFragment fragment) {

        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.new_form_fragment_container, fragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void closeFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        closeFragment();
    }

    @Override
    public void navigateBack(View view) {
        onBackPressed();
    }

    @Override
    public void showSubtitle(boolean willShow) {
        if (willShow) {
            if (mSubtitleView.getVisibility() == View.GONE) {
                mSubtitleView.setVisibility(View.VISIBLE);
            }
        } else {
            if (mSubtitleView.getVisibility() == View.VISIBLE) {
                mSubtitleView.setVisibility(View.GONE);
            }
        }
    }

    private void closeFragment() {

        // Pop topmost fragment from stack, closeFragment
        getSupportFragmentManager().popBackStackImmediate();

        // Hide keyboard
        AppUtil.hideSoftKeyboard(this);
    }
}
