package com.aolink.wallet.pages.wallet

import android.os.Bundle
import com.aolink.wallet.pages.common.type.GroupSectionItem
import com.aolink.wallet.base.BaseFragment
import com.aolink.wallet.pages.common.multitype.GroupItemBinder
import com.aolink.wallet.pages.common.multitype.GroupSectionItemBinder
import com.aolink.wallet.pages.common.type.GroupItem
import com.aolink.wallet.pages.wallet.enum.WalletGuideType
import com.aolink.wallet.utils.Constants
import com.aolink.wallet.utils.checkFastClick
import com.aolink.wallet.R
import com.aolink.wallet.db.WalletLocalType
import kotlinx.android.synthetic.main.fragment_wallet_import_type.*
import kotlinx.android.synthetic.main.include_topbar.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

/**
 * @FileName WalletAddFragment
 * @Description
 * @Author dingyan
 * @Date 2020/10/14 6:12 PM
 */
class WalletAddFragment : BaseFragment() {
    private var mWalletLocalType = WalletLocalType.LOCAL_TYPE_POK

    private lateinit var mItems: Items
    private lateinit var mAdapter: MultiTypeAdapter

    companion object {
        fun newInstance(walletLocalType: Int): WalletAddFragment {
            val fragment = WalletAddFragment()
            val bundle = Bundle()
            bundle.putInt(Constants.PARAM_WALLET_LOCAL_TYPE, walletLocalType)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getUi(): Int = R.layout.fragment_wallet_add

    override fun initData() {
        super.initData()

        initArgumentData()
    }

    private fun initArgumentData() {
        mWalletLocalType = arguments!!.getInt(Constants.PARAM_WALLET_LOCAL_TYPE)
    }

    override fun initView() {
        super.initView()

        initTopBar()
    }

    private fun initTopBar() {
        topbar?.setTitle(getString(R.string.title_add_wallet))
        topbar?.addLeftBackImageButton()?.setOnClickListener {
            if (activity is WalletAddActivity) {
                activity?.finish()
            } else {
                pop()
            }
        }
    }

    override fun initAdapter() {
        super.initAdapter()

        mItems = Items()
        mItems.add(GroupSectionItem(title = getString(R.string.title_import_wallet), topMargin = 10, bottomMargin = 0))

        mItems.add(
            GroupItem(title = getString(R.string.title_mnemonic_import),
                icon = R.mipmap.ic_wallet_import_by_mnemonic,
                onClockListener = {
                    mContext.checkFastClick {
                        start(WalletImportByMnemonicFragment.newInstance(walletLocalType = mWalletLocalType))
                    }
                })
        )

        mItems.add(GroupItem(title = getString(R.string.title_private_key_import),
                icon = R.mipmap.ic_wallet_import_by_private_key,
                onClockListener = {
                    mContext.checkFastClick {
                        start(WalletImportByPrivateKeyFragment.newInstance(walletLocalType = mWalletLocalType))
                    }
                }
        ))

        mItems.add(
            GroupItem(title = getString(R.string.title_key_store_import),
                icon = R.mipmap.ic_wallet_import_by_key_store,
                onClockListener = {
                    mContext.checkFastClick {
                        start(WalletImportByKeyStoreFragment.newInstance(walletLocalType = mWalletLocalType))
                    }
                })
        )

        addCreateWalletItems()

        mAdapter = MultiTypeAdapter(mItems)
        mAdapter.register(GroupSectionItem::class.java, GroupSectionItemBinder())
        mAdapter.register(GroupItem::class.java, GroupItemBinder())
        recycler_view?.adapter = mAdapter
    }

    private fun addCreateWalletItems() {
        mItems.add(GroupSectionItem(title = getString(R.string.title_create_wallet), topMargin = 20, bottomMargin = 0))
        mItems.add(
            GroupItem(title = getString(R.string.title_create_wallet),
                icon = R.mipmap.ic_create_wallet,
                onClockListener = {
                    mContext.checkFastClick {
                        start(
                            WalletFormFragment.newInstance(
                                guideType = WalletGuideType.Create,
                                walletLocalType = mWalletLocalType
                            )
                        )
                    }
                })
        )
    }

}