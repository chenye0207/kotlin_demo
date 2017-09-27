package com.example.cyhr.fragmenttest.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by cyhr on 9/24/17.
 */
abstract class BaseFragment : Fragment() {

    protected lateinit var callback : FragmentCallback;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        callback = activity as FragmentCallback;
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    public abstract fun getStringTag() : String
}