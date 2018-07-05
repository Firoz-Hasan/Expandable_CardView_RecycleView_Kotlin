//package com.example.firozhasan.cardviewwithrecycleview
//
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.support.v7.widget.Toolbar
//import android.util.Log
//import android.view.MenuItem
//import android.view.View
//import android.view.ViewGroup
//import android.view.animation.Animation
//import android.view.animation.RotateAnimation
//import android.widget.ImageView
//import android.widget.Toast
//
//class ExpandTest : AppCompatActivity() {
//
//    private var linearLayoutDetails: ViewGroup? = null
//    private var imageViewExpand: ImageView? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_expand_test)
////        val toolbar = findViewById(R.id.toolbar) as Toolbar
////        setSupportActionBar(toolbar)
//
//        linearLayoutDetails = findViewById(R.id.linearLayoutDetails) as ViewGroup?
//        imageViewExpand = findViewById(R.id.imageViewExpand) as ImageView?
//
////        val toolbarCard = findViewById(R.id.toolbarCard) as Toolbar
////        toolbarCard.setTitle(R.string.olinguito)
////        toolbarCard.setSubtitle(R.string.subtitle)
////        toolbarCard.inflateMenu(R.menu.menu_card)
////        toolbarCard.setOnMenuItemClickListener { item ->
////            when (item.itemId) {
////                R.id.action_option1 -> Toast.makeText(this@MainActivity, R.string.option1, Toast.LENGTH_SHORT).show()
////                R.id.action_option2 -> Toast.makeText(this@MainActivity, R.string.option2, Toast.LENGTH_SHORT).show()
////                R.id.action_option3 -> Toast.makeText(this@MainActivity, R.string.option3, Toast.LENGTH_SHORT).show()
////            }
////            true
////        }
//    }
//
//   /* fun toggleDetails(view: View) {
//        if (linearLayoutDetails!!.visibility == View.GONE) {
//            ExpandAndCollapseViewUtil.expand(linearLayoutDetails!!, DURATION)
//            Log.d("debugg", "iftoggleDetails: $DURATION")
//            linearLayoutDetails!!.visibility= View.VISIBLE
//            imageViewExpand!!.setImageResource(R.mipmap.more)
//            rotate(-180.0f)
//        } else {
//            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails!!, DURATION)
//            linearLayoutDetails!!.visibility= View.GONE
//            Log.d("debugg", "elsetoggleDetails: $DURATION")
//            imageViewExpand!!.setImageResource(R.mipmap.less)
//            rotate(180.0f)
//        }
//    }*/
//
//    private fun rotate(angle: Float) {
//        val animation = RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f)
//        animation.fillAfter = true
//        animation.duration = DURATION.toLong()
//        imageViewExpand!!.startAnimation(animation)
//    }
//
//    companion object {
//
//        private val DURATION = 10
//    }
//
//
//}
//
