package com.vivek.androidmvvm.utilites

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import com.vivek.androidmvvm.R


class Utility  {

    companion object {

        private lateinit var dialog: Dialog
//private var dialog: Dialog? = null


        fun  makeFullScreen(activity: Activity){
           activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

        }


//        fun showProgress(activity: Activity): Dialog? {
//             dialog = Dialog(activity)
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            dialog.getWindow()?.setBackgroundDrawable(
//                ColorDrawable(0)
//            )
//            dialog.setContentView(R.layout.custom_loader)
//            val progressBar: ProgressBar = dialog.findViewById(R.id.progressBar)
//            progressBar.indeterminateDrawable.setColorFilter(
//                activity.resources.getColor(R.color.white),
//                PorterDuff.Mode.MULTIPLY
//            )
//            dialog.setCancelable(true)
//            dialog.show()
//            return dialog
//        }


    }
}