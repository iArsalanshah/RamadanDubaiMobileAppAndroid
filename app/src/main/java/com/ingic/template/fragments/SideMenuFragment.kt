package com.ingic.template.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ingic.template.R
import com.ingic.template.fragments.abstracts.BaseFragment
import com.ingic.template.interfaces.OnViewHolderClick
import com.ingic.template.ui.views.TitleBar

import com.ingic.template.ui.adapters.SideMenuAdapter
import kotlinx.android.synthetic.main.fragment_sidemenu.*
import kotlin.math.log

class SideMenuFragment : BaseFragment(), OnViewHolderClick {

    private var adapter: SideMenuAdapter? = null

    companion object {
        fun newInstance(): SideMenuFragment {
            return SideMenuFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = SideMenuAdapter(dockActivity, this@SideMenuFragment)
        adapter?.addAll(listOf("Login", "Register", "Features", "About Ramadan Dubai", "Setting", "العربية‎"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sidemenu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun setTitleBar(titleBar: TitleBar) {
        super.setTitleBar(titleBar)
        titleBar.hideTitleBar()
    }

    private fun setupRecyclerView() {
        recyclerViewSideMenu?.layoutManager = LinearLayoutManager(dockActivity)
        recyclerViewSideMenu?.adapter = adapter
    }

    override fun onItemClick(view: View?, position: Int) {
        if (position == 0) {//login
            dockActivity.replaceDockableFragment(LoginFragment())
        }
    }
}