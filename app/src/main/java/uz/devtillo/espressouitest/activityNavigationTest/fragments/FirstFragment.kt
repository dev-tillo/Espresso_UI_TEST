package uz.devtillo.espressouitest.activityNavigationTest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.devtillo.espressouitest.R
import uz.devtillo.espressouitest.activityNavigationTest.adapter.MovieAdapter
import uz.devtillo.espressouitest.databinding.FragmentFirstBinding
import uz.devtillo.espressouitest.model.Movie

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentFirstBinding
    private lateinit var list: ArrayList<Movie>
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        loadData()
        adapter = MovieAdapter(requireContext(), object : MovieAdapter.onItemClicked {
            override fun onClicked(url: Movie, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("url", url)
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            }
        })
        binding.rv.adapter = adapter
        adapter.submitList(list)

        return binding.root
    }

    private fun loadData() {
        list = ArrayList()

        list.add(
            Movie(
                0,
                "Avengers: Infinity War",
                "https://www.lifewire.com/thmb/4DwXgCqvz_AMANges8tW2tqRzqo=/2121x1414/filters:fill(auto,1)/GettyImages-1075570286-852a1ca9563e45f19749f9e8979f6b94.jpg",
                "The Avengers and their allies must be willing to sacrifice all in an attempt to " +
                        "defeat the powerful Thanos before his blitz of devastation and ruin puts an end to " +
                        "the universe.",
                arrayListOf("Anthony Russo", "Joe Russo"),
                arrayListOf("Robert Downey Jr.", "Chris Hemsworth", "Mark Ruffalo", "+ more...")
            )
        )
        list.add(
            Movie(
                1,
                "The Rundown",
                "https://images.app.goo.gl/4urpJQmDTrNSwq8K6",
                "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                        "becomes involved in the fight against an oppressive town operator and the search " +
                        "for a legendary treasure.",
                arrayListOf("R.J. Stewart", "James Vanderbilt"),
                arrayListOf(
                    "Dwayne Johnson",
                    "Seann William Scott",
                    "Rosario Dawson",
                    "Christopher Walken"
                )
            )
        )
        list.add(
            Movie(
                2,
                "The Godfather",
                "https://www.lifewire.com/thmb/4DwXgCqvz_AMANges8tW2tqRzqo=/2121x1414/filters:fill(auto,1)/GettyImages-1075570286-852a1ca9563e45f19749f9e8979f6b94.jpg",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                arrayListOf("Francis Ford Coppola"),
                arrayListOf("Marlon Brando", "Al Pacino", "James Caan")
            )
        )
        list.add(
            Movie(
                3,
                "The Dark Knight",
                "https://images.app.goo.gl/4urpJQmDTrNSwq8K6",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                arrayListOf("Christopher Nolan"),
                arrayListOf("Christian Bale", "Heath Ledger", "Aaron Eckhart")
            )
        )
        list.add(
            Movie(
                4,
                "The Lord of the Rings: The Return of the King",
                "https://www.lifewire.com/thmb/4DwXgCqvz_AMANges8tW2tqRzqo=/2121x1414/filters:fill(auto,1)/GettyImages-1075570286-852a1ca9563e45f19749f9e8979f6b94.jpg",
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                arrayListOf("Peter Jackson"),
                arrayListOf("Elijah Wood", "Viggo Mortensen", "Ian McKellen")
            )
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}