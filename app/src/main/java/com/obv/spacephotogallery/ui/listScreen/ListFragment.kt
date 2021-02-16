package com.obv.spacephotogallery.ui.listScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obv.spacephotogallery.R
import com.obv.spacephotogallery.data.ImageDetail
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    private lateinit var rcv_list: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        rcv_list = view.findViewById(R.id.rcv_image_list)
        val list = initiateList()
        rcv_list.adapter = ImageGridAdapter(list)

        return view
    }

    private fun initiateList(): List<ImageDetail> {
        return listOf(ImageDetail("abc", Date(System.currentTimeMillis()),"explanation will afterward","John wick","http://njiujns789/mkjoas879/dd","","image"),
            ImageDetail("def", Date(System.currentTimeMillis()),"explanation will afterward","Matrix","http://njiujns789/mkjoas879/dd","","image"),
            ImageDetail("ghi", Date(System.currentTimeMillis()),"explanation will afterward","die hard","http://njiujns789/mkjoas879/dd","","image"),
            ImageDetail("jkl", Date(System.currentTimeMillis()),"explanation will afterward","motion pictures","http://njiujns789/mkjoas879/dd","","image"))
    }
}