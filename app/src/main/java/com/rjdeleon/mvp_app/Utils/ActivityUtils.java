package com.rjdeleon.mvp_app.Utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.rjdeleon.mvp_app.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId, boolean addToBackstack) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (addToBackstack) {
            Fragment previousFragment = fragmentManager.findFragmentById(R.id.new_dnca_fragment_container);
            if (previousFragment != null) {
                transaction.hide(previousFragment);
            }
            transaction.add(frameId, fragment);
            transaction.show(fragment);
            transaction.addToBackStack(null);
        } else {
            transaction.add(frameId, fragment);
        }
        transaction.commit();
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, tag);
        transaction.commit();
    }
}
