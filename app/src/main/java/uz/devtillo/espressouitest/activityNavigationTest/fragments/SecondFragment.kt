package uz.devtillo.espressouitest.activityNavigationTest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.devtillo.espressouitest.R
import uz.devtillo.espressouitest.databinding.FragmentSecondBinding
import uz.devtillo.espressouitest.model.Movie

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {
    private var param1: Movie? = null
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        arguments?.let {
            param1 = it?.getSerializable("url") as Movie
        }

        binding.actors.text = param1?.star_actors.toString()
        binding.movie.text = param1?.title
        binding.descriptions.text = param1?.description

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}