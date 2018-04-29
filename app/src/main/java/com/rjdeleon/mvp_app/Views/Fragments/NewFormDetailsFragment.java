package com.rjdeleon.mvp_app.Views.Fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GenderTuple;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewFormDetailsFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class NewFormDetailsFragment extends BaseFragment {

    private FormInfo mFormInfo;

    public NewFormDetailsFragment() {
        // Required empty public constructor
    }

    public static NewFormDetailsFragment newInstance() {
        NewFormDetailsFragment fragment = new NewFormDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mFormInfo = seedData();
        NewFormDetailsFragmentBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.new_form_details_fragment, container, false);
        binding.setFormInfo(mFormInfo);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    /* SAMPLE SEED DATA */
    private FormInfo seedData() {

        List<PopulationDataRow> rows = new ArrayList<>();
        List<VulnerablePopulationDataRow> vpRows = new ArrayList<>();
        List<CasualtiesDataRow> cdRows = new ArrayList<>();
        List<DeathCauseDataRow> dcdRows = new ArrayList<>();
        List<InfrastructureDamageDataRow> iddRows = new ArrayList<>();

        for (int i = 0; i < PopulationData.AgeGroup.values().length - 1; i++) {
            PopulationData.AgeGroup ageGroup = PopulationData.AgeGroup.values()[i];
            PopulationDataRow row = new PopulationDataRow(ageGroup,
                    new GenderTuple(1,2),
                    new GenderTuple(3,4),
                    new GenderTuple(5,6));
            rows.add(row);

            GenderTuple gt = new GenderTuple(55, 66);

            VulnerablePopulationDataRow vpRow = new VulnerablePopulationDataRow(ageGroup, 11, 22, 33, 44, gt, gt, gt, "vpRow");
            vpRows.add(vpRow);

            CasualtiesDataRow cdRow = new CasualtiesDataRow(ageGroup, gt, gt, gt);
            cdRows.add(cdRow);

            DeathCauseDataRow dcdRow = new DeathCauseDataRow(ageGroup, gt, gt, gt, gt, gt, gt, gt, gt, gt);
            dcdRows.add(dcdRow);
        }

        for (int i = 0; i < InfrastructureDamageData.InfraType.values().length; i++) {
            InfrastructureDamageDataRow iddRow = new InfrastructureDamageDataRow(InfrastructureDamageData.InfraType.values()[i], 77, true, "damagedInfra");
            iddRows.add(iddRow);
        }

        PopulationData populationData = new PopulationData(rows);
        CalamityDesc calamityDesc = new CalamityDesc("xxx", "yyy", "zzz");
        FamilyData familyData = new FamilyData(11, 22, 33, 44, 55, 66);
        VulnerablePopulationData vulnerablePopulationData = new VulnerablePopulationData(vpRows);
        CasualtiesData casualtiesData = new CasualtiesData(cdRows);
        DeathCauseData deathCauseData = new DeathCauseData(dcdRows);
        InfrastructureDamageData infrastructureDamageData = new InfrastructureDamageData(iddRows);

        GenInfo genInfo = new GenInfo(calamityDesc, "affectedArea", populationData, familyData, vulnerablePopulationData, casualtiesData, deathCauseData, infrastructureDamageData);
        return new FormInfo("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", genInfo);
    }
    /* ================ */
}
