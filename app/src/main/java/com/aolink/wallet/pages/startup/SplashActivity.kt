package com.aolink.wallet.pages.startup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.aolink.wallet.R
import com.aolink.wallet.base.BaseActivity
import com.aolink.wallet.pages.main.MainActivity
import com.aolink.wallet.pages.wallet.WalletGuideActivity
import com.aolink.wallet.utils.SharedPrefKt

/**
 * @FileName: SplashActivity
 * @Description: 启动页
 * @Author: haoyanhui
 * @Date: 2020-06-25 12:52
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun initView() {
        super.initView()

        openNextPageBySetting()
    }

    private fun Activity.openNextPageBySetting() {
        when {
            SharedPrefKt.getCurrentWalletAddress().isNullOrEmpty() -> {
                // 未创建/导入钱包，则打开创建/导入钱包选择页
                startActivity(Intent(this, WalletGuideActivity::class.java))
            }
            else -> {
                // 非以上情况，则进入 App
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        finish()
    }
}