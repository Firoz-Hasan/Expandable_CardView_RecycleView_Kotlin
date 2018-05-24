package com.danielme.android.cardview

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView

import java.lang.reflect.Method

/**
 * Refactor from http://tech.chitgoks.com/2011/10/29/android-animation-to-expand-collapse-view-its-children/
 */
object ExpandAndCollapseViewUtil {


    fun expand(v: ViewGroup, duration: Int) {
        slide(v, duration, true)
    }

    fun collapse(v: ViewGroup, duration: Int) {
        slide(v, duration, false)
    }

    private fun slide(v: ViewGroup, duration: Int, expand: Boolean) {
        try {
            //onmeasure method is protected
            val m = v.javaClass.getDeclaredMethod("onMeasure", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
            m.isAccessible = true
            m.invoke(
                    v,
                    View.MeasureSpec.makeMeasureSpec((v.parent as View).measuredWidth, View.MeasureSpec.AT_MOST),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )
        } catch (e: Exception) {
            Log.e("slideAnimation", e.message, e)
        }

        val initialHeight = v.measuredHeight

        if (expand) {
            v.layoutParams.height = 0
        } else {
            v.layoutParams.height = initialHeight
        }
        v.visibility = View.VISIBLE

        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                var newHeight = 0
                if (expand) {
                    newHeight = (initialHeight * interpolatedTime).toInt()
                } else {
                    newHeight = (initialHeight * (1 - interpolatedTime)).toInt()
                }
                v.layoutParams.height = newHeight
                v.requestLayout()

                if (interpolatedTime == 1f && !expand) {
                    v.visibility = View.GONE
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        a.duration = duration.toLong()
        v.startAnimation(a)
    }
}
