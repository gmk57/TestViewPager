package gmk57.testviewpager

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {
    private var position: Int = -1

    companion object {
        private const val POSITION = "ARG_POSITION"

        fun newInstance(position: Int) = MainFragment().apply {
            arguments = bundleOf(POSITION to position)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = arguments?.getInt(POSITION, -1) ?: -1
        println("onCreate, position: $position")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "Fragment $position"
    }
}
