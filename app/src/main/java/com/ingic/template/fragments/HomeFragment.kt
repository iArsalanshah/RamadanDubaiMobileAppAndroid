package com.ingic.template.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ingic.template.R
import com.ingic.template.fragments.abstracts.BaseFragment
import com.ingic.template.ui.views.TitleBar
import kotlinx.android.synthetic.main.fragment_home.*

//import com.google.android.gms.location.places.Place;


class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun setTitleBar(titleBar: TitleBar) {
        super.setTitleBar(titleBar)
        titleBar.hideButtons()
        titleBar.showMenuButton()
        titleBar.setSubHeading("Ramadan Dubai")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickEvents()
    }

    private fun setupClickEvents() {
        forumImageView.setOnClickListener { dockActivity.replaceDockableFragment(HomeDetails()) }
        calendarCardView.setOnClickListener { dockActivity.replaceDockableFragment(CalendarFragment()) }
    }
}

