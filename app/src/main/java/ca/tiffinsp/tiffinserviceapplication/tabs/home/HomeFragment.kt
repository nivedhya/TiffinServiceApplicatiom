package ca.tiffinsp.tiffinserviceapplication.tabs.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import ca.tiffinsp.tiffinserviceapplication.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pager = view.findViewById<ViewPager2>(R.id.vp)
        pager.adapter = BannerSliderAdapter(
            requireContext(),
            arrayOf(
                "https://cdn.pixabay.com/photo/2016/12/26/17/28/spaghetti-1932466__340.jpg",
                "https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062__340.jpg",
                "https://cdn.pixabay.com/photo/2017/02/15/10/39/salad-2068220__340.jpg"
            )
        )
        view.findViewById<DotsIndicator>(R.id.dots_indicator).setViewPager2(pager)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_services)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ServiceAdapter(
            requireContext(),
            arrayOf(
                "https://cdn.pixabay.com/photo/2017/05/07/08/56/pancakes-2291908__480.jpg",
                "https://cdn.pixabay.com/photo/2014/06/16/23/10/spices-370114__480.jpg",
                "https://cdn.pixabay.com/photo/2014/12/11/02/55/cereals-563796__480.jpg"
            )
        )


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}