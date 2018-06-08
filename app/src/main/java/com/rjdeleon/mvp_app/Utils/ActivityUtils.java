package com.rjdeleon.mvp_app.Utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.ViewModelHolder;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId, boolean addToBackstack, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (addToBackstack) {
            Fragment previousFragment = fragmentManager.findFragmentById(R.id.new_dnca_fragment_container);
            if (previousFragment != null) {
                transaction.hide(previousFragment);
            }
            transaction.add(frameId, fragment, tag);

            transaction.show(fragment);
            transaction.addToBackStack(null);

        } else {
            transaction.add(frameId, fragment, tag);
        }
        transaction.commit();
    }

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId, boolean addToBackstack) {

        addFragmentToActivity(fragmentManager, fragment, frameId, addToBackstack, null);
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, tag);
        transaction.commit();
    }

    /**
     * Finds a sub-fragment with the given tag
     * @param fragmentManager
     * @param tag
     * @return
     */
    public static BaseSubFragment findSubFragment(FragmentManager fragmentManager, String tag) {
        List<Fragment> fragments = fragmentManager.getFragments();
        BaseSubFragment selectedFragment = null;
        for(Fragment fragment : fragments) {
            if (!(fragment instanceof BaseSubFragment)) continue;

            selectedFragment = (BaseSubFragment)fragment;
            if ((selectedFragment.getFragmentTag().equals(tag))) {
                break;
            }
            selectedFragment = null;
        }
        return selectedFragment;
    }

    /**
     * Wrap viewModel inside viewModelHolder
     * @param fragmentManager
     * @param viewModelHolder
     * @param viewModel
     * @param tag
     */
    public static void bindViewModel(FragmentManager fragmentManager, ViewModelHolder<NewDncaBaseViewModel> viewModelHolder,
                                     NewDncaBaseViewModel viewModel, String tag) {

        if (viewModelHolder != null) {
            // If container already exists, just inject viewModel into container
            viewModelHolder.setViewModel(viewModel);

        } else {

            // Bind viewModel to activity's lifecycle using fragment manager
            addFragmentToActivity(fragmentManager, ViewModelHolder.createContainer(viewModel), tag);
        }
    }

}
