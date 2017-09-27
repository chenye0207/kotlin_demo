package com.example.cyhr.fragmenttest.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cyhr.fragmenttest.R

/**
 * Created by cyhr on 9/23/17.
 */
class TestFragment3 : BaseFragment() {

    override fun getStringTag(): String {
        return "three"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState);
        val view = inflater?.inflate(R.layout.fragment_3,container,false);
        val bt = view?.findViewById<Button>(R.id.bt);
        bt?.setOnClickListener(View.OnClickListener { callback.callback("three") })
        return view;
    }
}