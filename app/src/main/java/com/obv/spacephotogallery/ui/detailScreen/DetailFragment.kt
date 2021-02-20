package com.obv.spacephotogallery.ui.detailScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.obv.spacephotogallery.R
import com.obv.spacephotogallery.data.ImageDetail
import com.obv.spacephotogallery.databinding.FragmentDetailBinding
import com.obv.spacephotogallery.ingList

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private var index: Int = 0
    private lateinit var imagedetail: ImageDetail
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail,container,false)
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        index = args.sortedListIndex
        binding.btnLeft.setOnClickListener { view: View ->
            if (--index>=0) {
                setButtonStateForindex(index)
                setData(index)
            }
        }
        binding.btnRight.setOnClickListener { view: View ->
            if (++index < ingList.sortedImageList.size) {
                setButtonStateForindex(index)
                setData(index)
            }

        }
        setData(index)
        setButtonStateForindex(index)
        return binding.root
    }

    private fun setButtonStateForindex(index: Int) {
        when (index) {
            0 -> binding.btnLeft.visibility = View.GONE
            1 -> binding.btnLeft.visibility = View.VISIBLE
            (ingList.sortedImageList.size-1) -> binding.btnRight.visibility = View.GONE
            (ingList.sortedImageList.size-2) -> binding.btnRight.visibility = View.VISIBLE
        }
    }

    private fun setData(index: Int){
        imagedetail = ingList.sortedImageList[index]
        Glide.with(binding.root).load(imagedetail.url).apply(RequestOptions().placeholder(R.drawable.loading_animation)).into(binding.imgvSpacePic)
        binding.tvDetailText.text = imagedetail.explanation
        binding.tvTitle.text = imagedetail.title
        if (imagedetail.copyright.isNullOrEmpty()){
            binding.tvPhotographer.visibility = View.GONE
            binding.tvBy.visibility = View.GONE
        } else {
            binding.tvPhotographer.visibility = View.VISIBLE
            binding.tvBy.visibility = View.VISIBLE
            binding.tvPhotographer.text = imagedetail.copyright
        }


    }
}