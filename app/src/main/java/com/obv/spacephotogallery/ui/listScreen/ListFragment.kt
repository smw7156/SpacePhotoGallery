package com.obv.spacephotogallery.ui.listScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obv.spacephotogallery.R
import com.obv.spacephotogallery.data.ImageDetail
import com.obv.spacephotogallery.databinding.FragmentListBinding
import com.obv.spacephotogallery.getJsonDataFromAssets
import com.obv.spacephotogallery.ingList
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
        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater, R.layout.fragment_list,container,false)

        val jsonFileString = context?.let { getJsonDataFromAssets(it) }
        val gson = Gson()
        val listImgaes = object : TypeToken<List<ImageDetail>>() {}.type
        var images: List<ImageDetail> = gson.fromJson(jsonFileString, listImgaes)
        images.iterator().forEach {
            Log.i("data", "> Item: ${it.title}")
        }
        ingList.sortedImageList = images.sortedByDescending { it.date }
        binding.rcvImageList.adapter = ImageGridAdapter(ingList.sortedImageList)

        return binding.root
    }

}