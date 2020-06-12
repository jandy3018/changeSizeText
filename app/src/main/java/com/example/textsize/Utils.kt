package com.example.textsize

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.preference.PreferenceManager
import java.util.*


object Utils {
    fun setSizeConfig(newBase: Context?, activity: Activity) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(newBase)
        val sizeUser = sharedPreferences.getString("SIZE_TEXT", "")
        if (sizeUser.equals("SYSTEM")) {
            val locale = Locale("MX")
            Locale.setDefault(locale)
        } else {
            val newOverride = Configuration(newBase?.resources?.configuration)
            newOverride.fontScale = if (sizeUser.equals("SMALL")) 0.8f else if (sizeUser.equals("BIG")) 1.4f else 1f
            activity.applyOverrideConfiguration(newOverride)
        }
    }

    fun changeToSize(activity: Activity) {
        activity.finish()
        activity.startActivity(Intent(activity, activity.javaClass))
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}