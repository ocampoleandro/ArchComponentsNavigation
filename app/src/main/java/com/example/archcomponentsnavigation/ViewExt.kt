package com.example.archcomponentsnavigation

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View

fun View.expandIconTouchArea() {
    val parentView = parent as View
    parentView.post {

        val touchableArea = Rect()
        getHitRect(touchableArea)
        val extra = resources.getDimensionPixelSize(R.dimen.padding)
        touchableArea.left -= extra
        touchableArea.top -= extra
        touchableArea.right += extra
        touchableArea.bottom += extra

        parentView.touchDelegate = TouchDelegate(touchableArea, this)
    }
}