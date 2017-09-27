package com.example.cyhr.fragmenttest

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.cyhr.fragmenttest.fragments.BaseFragment
import com.example.cyhr.fragmenttest.fragments.FragmentCallback
import com.example.cyhr.fragmenttest.fragments.FragmentFactory
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by cyhr on 9/23/17.
 */
class MainActivity : AppCompatActivity(),FragmentCallback {

    var currentFragment : Fragment? = null

    var stack : Stack<WeakReference<BaseFragment>> = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        showFragment("one")
        val bt_switch = findViewById(R.id.bt_switch) as Button;
        bt_switch.setOnClickListener(
                View.OnClickListener {

                }
        )
    }

    private fun switchFragment(type:String){
        when(type){
            "one"-> showFragment("two")
            "two"-> showFragment("three")
            "three"-> showFragment("one")
        }
    }

    override fun callback(type: String) {
        switchFragment(type);
    }

    fun showFragment(tag : String?){
        val transaction : FragmentTransaction? = fragmentManager.beginTransaction();
        if(currentFragment != null){
            transaction?.hide(currentFragment)
        }
        currentFragment = fragmentManager.findFragmentByTag(tag)
        if(currentFragment == null){
            currentFragment = FragmentFactory().getFragment(tag)
            transaction?.add(R.id.fl,currentFragment,tag)
        }else{
            transaction?.show(currentFragment)
        }
        transaction?.addToBackStack(tag);
        val ref = WeakReference(currentFragment as BaseFragment)
        stack.push(ref)
        transaction?.commitAllowingStateLoss()
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
    }


    override fun onBackPressed() {
//        popByManager()
        popByStack()
    }

    fun popByManager(){
        val fragment = fragmentManager.findFragmentById(R.id.fl) as BaseFragment
        Log.i("eeeee",fragment.getStringTag())
        fragmentManager.popBackStack()
    }

    fun popByStack(){
        fragmentManager.popBackStack()
        if(!stack.empty()){
            var fragment = stack.pop().get()
            Log.i("eeeee",fragment?.getStringTag())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stack.clear();
    }
}
