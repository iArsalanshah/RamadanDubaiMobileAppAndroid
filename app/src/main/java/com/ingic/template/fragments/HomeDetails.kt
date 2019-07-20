package com.ingic.template.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ingic.template.R
import com.ingic.template.fragments.abstracts.BaseFragment
import com.ingic.template.ui.views.TitleBar

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeDetails : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_details, container, false)
    }


    override fun setTitleBar(titleBar: TitleBar?) {
        super.setTitleBar(titleBar)
        titleBar?.showBackButton()
        titleBar?.setSubHeading("Rashid bin Mohammad Ramadan Forum")
    }
}
