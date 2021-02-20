package com.aolink.wallet.pages.wallet

import android.os.Bundle
import com.aolink.wallet.R
import com.aolink.wallet.base.BaseActivity

/**
 * @FileName WalletGuideActivity
 * @Description
 * @Author dingyan
 * @Date 2020-01-07 10:28
 */
class WalletGuideActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_wallet_guide)

        initRootFragment()
    }

    private fun initRootFragment() {
        val targetFragment = WalletGuideFragment()
        if (findFragment(targetFragment.javaClass) == null) {
            loadRootFragment(R.id.frame_layout, targetFragment)
        }
    }
}