package com.example.cyhr.fragmenttest.fragments

/**
 * Created by cyhr on 9/24/17.
 */
public class FragmentFactory constructor(){

    init {
        print("This $this is singleton")
    }

    companion object {
        val instance: FragmentFactory = FragmentFactory()
    }

    fun getFragment(tag:String?) : BaseFragment{
        var fragment : BaseFragment = TestFragment1();
        when(tag){
            "one"-> fragment = TestFragment1()
            "two"-> fragment = TestFragment2()
            "three"-> fragment = TestFragment3()
        }
        return fragment
    }
}