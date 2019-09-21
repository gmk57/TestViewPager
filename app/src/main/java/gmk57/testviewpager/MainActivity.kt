package gmk57.testviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pagerAdapter = PagerAdapter(this)
        pager.adapter = pagerAdapter
        TabLayoutMediator(tabs, pager) { tab, position -> tab.text = "Tab $position" }.attach()
        pager.currentItem = 2

        button.setOnClickListener {
            pagerAdapter.count--
            pagerAdapter.notifyDataSetChanged()
        }
    }

    private class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        var count = 3
        override fun getItemCount() = count
        override fun createFragment(position: Int) = MainFragment.newInstance(position)
    }
}
