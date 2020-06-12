package com.example.textsize

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_select_size.*


class SelectSizeTextFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.activity_select_size, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences (context)
        btn_applied.setOnClickListener {
            val editor: Editor = sharedPreferences.edit()
            editor.putString("SIZE_TEXT", if(rd_small.isChecked)"SMALL" else if(rd_normal.isChecked)"NORMAL" else if(rd_big.isChecked) "BIG" else "SYSTEM")
            editor.commit()

            Utils.changeToSize(activity!!)
        }
        val sizeUser = sharedPreferences.getString("SIZE_TEXT", "")
        rd_small.isChecked= sizeUser.equals("SMALL")
        rd_normal.isChecked= sizeUser.equals("NORMAL")
        rd_big.isChecked= sizeUser.equals("BIG")
        rd_system.isChecked= sizeUser.equals("SYSTEM")

        rd_system.setOnClickListener {
            if(rd_system.isChecked)
            {
                rd_small.isChecked=false
                rd_normal.isChecked=false
                rd_big.isChecked=false
            }
        }

        rd_small.setOnClickListener {
            if(rd_small.isChecked)
            {
                rd_system.isChecked=false
                rd_normal.isChecked=false
                rd_big.isChecked=false
            }
        }
        rd_normal.setOnClickListener {
            if(rd_normal.isChecked)
            {
                rd_system.isChecked=false
                rd_small.isChecked=false
                rd_big.isChecked=false
            }
        }

        rd_big.setOnClickListener {
            if(rd_big.isChecked)
            {
                rd_system.isChecked=false
                rd_small.isChecked=false
                rd_normal.isChecked=false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    companion object {
        val TAG=SelectSizeTextFragment::class.java.simpleName
        @JvmStatic
        fun newInstance()=SelectSizeTextFragment()
    }
}
