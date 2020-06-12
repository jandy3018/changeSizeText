package com.example.textsize

import android.content.Context
import android.content.res.Configuration
import android.opengl.Visibility
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_text_main.*


class AnotherTexActivity : AppCompatActivity() {


    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
    override fun attachBaseContext(newBase: Context?) {
        Utils.setSizeConfig(newBase, this)
        //val newOverride = Configuration(newBase?.resources?.configuration)
        //newOverride.fontScale =1.6f
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_main)

        tv_text.text="Git is a version control system. What’s that? Let’s say you were working on a large project with many developers. If everyone edited the project’s source code at once, there would be tons of conflicts and it would be hard to make sense of things. With version control, specifically Git, each developer makes changes to a local copy of the project, makes a commit, and pushes that change to a remote location if the project is hosted on an external server such as one of GitHub’s. Every change made under a version control system is tracked, so conflicts are greatly reduced and any you do encounter can be sorted out fairly easily."
        btn_next_view.text="Cerrar"
        btn_next_view.setOnClickListener {
            finish()
        }
    }
}
