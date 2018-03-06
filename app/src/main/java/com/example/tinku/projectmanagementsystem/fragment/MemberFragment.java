package com.example.tinku.projectmanagementsystem.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;


/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class MemberFragment extends Fragment {
    /**
     * declaration
     */
    RecyclerView recyclerViewMember;
    TextView textViewMember;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment,container,false);
        /**
         * initialization
         */
        recyclerViewMember = view.findViewById(R.id.recyclerView_member);
        textViewMember = view.findViewById(R.id.textView_member);

        /**
         * set up recyclerView
         */
        recyclerViewMember.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMember.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerViewMember.setHasFixedSize(true);
        recyclerViewMember.setItemAnimator(new DefaultItemAnimator());

        sendMemberRequest();
        return view;
    }
    public void sendMemberRequest(){

    }
}
