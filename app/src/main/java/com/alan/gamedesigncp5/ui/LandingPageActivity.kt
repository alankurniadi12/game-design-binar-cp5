package com.alan.gamedesigncp5.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2
import com.alan.gamedesigncp5.R
import com.alan.gamedesigncp5.databinding.ActivityLandingPageBinding
import com.alan.gamedesigncp5.ui.fragment.FormFragment
import com.alan.gamedesigncp5.ui.slider.SectionPagerAdapter
import com.alan.gamedesigncp5.ui.slider.SliderFragment
import com.alan.gamedesigncp5.utils.OnTextChange
import com.alan.gamedesigncp5.utils.Utils.hide
import com.alan.gamedesigncp5.utils.Utils.show

class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding
    private var namePlayer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSliderIntro()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initSliderIntro() {
        val sliderPagerAdapter = SectionPagerAdapter(supportFragmentManager, lifecycle)
        val formFragment = FormFragment()
        val items = mutableListOf(
            SliderFragment(
                ResourcesCompat.getDrawable(resources, R.drawable.landing_page1, null),
                "Bermain suit melawan sesama Pemain"
            ),
            SliderFragment(
                ResourcesCompat.getDrawable(resources, R.drawable.landing_page2, null),
                "Bermain suit melawan Komputer"
            ),
            formFragment
        )
        sliderPagerAdapter.setItem(items)

        formFragment.setOnTextChange(object : OnTextChange {
            override fun visibleButtonNext(name: String) {
                binding.imgNext.isInvisible = name.isEmpty()
                namePlayer = name
            }
        })

        binding.vpLandingPage.apply {
            adapter = sliderPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when {
                        position == 0 -> {
                            binding.imgNext.show()
                            binding.imgPrevious.hide()
                        }
                        position < sliderPagerAdapter.itemCount - 1 -> {
                            binding.imgNext.show()
                            binding.imgPrevious.show()
                        }
                        position == sliderPagerAdapter.itemCount - 1 -> {
                            binding.imgNext.hide()
                            binding.imgPrevious.show()
                        }
                    }
                    super.onPageSelected(position)
                }
            })
        }
        binding.dotsIndicator.setViewPager2(binding.vpLandingPage)

        binding.imgNext.setOnClickListener {
            if (binding.vpLandingPage.currentItem >= items.size.minus(1)) {
                val intent = Intent(this@LandingPageActivity, MenuActivity::class.java)
                intent.putExtra(MenuActivity.KEY_NAME, namePlayer)
                startActivity(intent)
            } else {
                if (getNextIndex() != -1) {
                    binding.vpLandingPage.setCurrentItem(getNextIndex(), true)
                }
            }
        }

        binding.imgPrevious.setOnClickListener {
            if (getPreviousIndex() != -1) {
                binding.vpLandingPage.setCurrentItem(getPreviousIndex(), true)
            }
        }
    }

    private fun getPreviousIndex(): Int {
        val currentPage = binding.vpLandingPage.currentItem
        return if (currentPage - 1 >= 0) {
            currentPage - 1
        } else {
            -1
        }
    }

    private fun getNextIndex(): Int {
        val maxPages = binding.vpLandingPage.adapter?.itemCount
        val currentIndex = binding.vpLandingPage.currentItem
        var selectedIndex = -1
        maxPages?.let {
            if (currentIndex + 1 < maxPages) {
                selectedIndex = currentIndex + 1
            }
        }
        return selectedIndex
    }
}