package com.aolink.wallet.pages.wallet

import android.os.Bundle
import com.aolink.wallet.R
import com.aolink.wallet.base.BaseActivity

/**
 * @FileName WalletManagementActivity
 * @Description
 * @Author dingyan
 * @Date 2020/10/14 6:30 PM
 */
class WalletManagementActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_wallet_management)

        initRootFragment()
    }

    private fun initRootFragment() {
        val targetFragment = WalletManagementFragment()
        if (findFragment(targetFragment.javaClass) == null) {
            loadRootFragment(R.id.frame_layout, targetFragment)
        }
    }
}