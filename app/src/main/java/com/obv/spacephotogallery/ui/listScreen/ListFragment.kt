package com.obv.spacephotogallery.ui.listScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obv.spacephotogallery.R
import com.obv.spacephotogallery.data.ImageDetail
import com.obv.spacephotogallery.data.network.SPGServices
import com.obv.spacephotogallery.getJsonDataFromAssets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
//        val list0 = initiateList()


//        SPGServices.retrofitService.getSpacePhotos().enqueue(
//            object: Callback<List<ImageDetail>>{
//                override fun onResponse(call: Call<List<ImageDetail>>, response: Response<List<ImageDetail>>)
//                {
//                    Log.i("ListFragment","onResponse: from server fetching list")
//                    val body = response.body()
//                    if(body.isNullOrEmpty()){
//                        Log.e("ListFragment","onResponse: empty or null body received")
//                    } else{
//                        body.iterator().forEach {
//                            Log.i("ONSuccess",it.title)
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<List<ImageDetail>>, t: Throwable) {
//                    Log.e("ListFragment","on Failure: ${t.message}")
//                }
//            }
//        )

        val jsonFileString = context?.let { getJsonDataFromAssets(it) }
        val gson = Gson()
        val listImgaes = object : TypeToken<List<ImageDetail>>() {}.type
        var images: List<ImageDetail> = gson.fromJson(jsonFileString, listImgaes)
        images.iterator().forEach {
            Log.i("data", "> Item: ${it.title}")
        }
        rcv_list.adapter = ImageGridAdapter(images)
//        images.forEachIndexed { index, image ->
//            Log.i("data", "> Item $index:\t${image.title}")
//        }

        return view
    }

    private fun initiateList(): List<ImageDetail> {
        return listOf(ImageDetail("abc", "02-02-20121","explanation will afterward","John wick","http://njiujns789/mkjoas879/dd","","image","v1"),
            ImageDetail("def", "02-02-20121","explanation will afterward","Matrix","http://njiujns789/mkjoas879/dd","","image","v1"),
            ImageDetail("ghi", "02-02-20121","explanation will afterward","die hard","http://njiujns789/mkjoas879/dd","","image","v1"),
            ImageDetail("jkl", "02-02-20121","explanation will afterward","motion pictures","http://njiujns789/mkjoas879/dd","","image","v1"))
    }
}