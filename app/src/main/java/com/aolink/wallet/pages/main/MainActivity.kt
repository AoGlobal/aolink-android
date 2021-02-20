package com.aolink.wallet.pages.main

import android.content.pm.ActivityInfo
import android.os.Bundle
import com.aolink.wallet.R
import com.aolink.wallet.base.BaseActivity
import com.aolink.wallet.pages.assets.AssetsFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        initRootFragment()
    }

    private fun initRootFragment() {
        val targetFragment = AssetsFragment()
        if (findFragment(targetFragment.javaClass) == null) {
            loadRootFragment(R.id.frame_layout, targetFragment)
        }
    }

}
