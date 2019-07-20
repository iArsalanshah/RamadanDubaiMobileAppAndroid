package com.ingic.template.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ingic.template.R
import com.ingic.template.fragments.abstracts.BaseFragment
import com.ingic.template.ui.adapters.CalendarAdapter
import com.ingic.template.ui.views.TitleBar
import kotlinx.android.synthetic.main.fragment_calendar.*


/**
 * A simple [Fragment] subclass.
 *
 */
class CalendarFragment : BaseFragment() {

    private var adapter: CalendarAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CalendarAdapter(dockActivity)
        val dataSource = mutableListOf<String>()
        for (i in 1..20) {
            dataSource.add("Sunday, $i Ramadan 1440")
        }
        adapter?.addAll(dataSource)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun setTitleBar(titleBar: TitleBar?) {
        super.setTitleBar(titleBar)
        titleBar?.showBackButton()
        titleBar?.setSubHeading("Calendar")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerViewCalendar?.layoutManager = LinearLayoutManager(dockActivity)
        recyclerViewCalendar?.adapter = adapter
    }
}
