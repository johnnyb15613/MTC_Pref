package com.jb15613.themechooser.utility

import android.content.res.Resources
import android.os.AsyncTask
import android.widget.ImageView
import java.lang.ref.WeakReference
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import android.graphics.PorterDuff
import com.jb15613.themechooser.mtcpref.R
import android.graphics.drawable.BitmapDrawable

class ImageLoader(imageView: ImageView, r: Resources, id: Int, color: Int) : AsyncTask<String, Void, Drawable>() {


        private val mImageViewReference: WeakReference<ImageView> = WeakReference(imageView)
        private val mResources: Resources = r
        private val mId: Int = id
        private val mColor: Int = color
        private val fieldData = 0
        private var colorMode: PorterDuff.Mode? = null

    override fun onPreExecute() {
        super.onPreExecute()
    }

        override fun doInBackground(vararg params: String?): Drawable? {
            colorMode = if (mId == R.drawable.themechooser_shape_circle) {
                PorterDuff.Mode.MULTIPLY
            } else {
                PorterDuff.Mode.SRC_IN
            }
            return ResourcesCompat.getDrawable(mResources, mId, null)
        }

        override fun onPostExecute(d: Drawable?) {
            super.onPostExecute(d)
            var dd = d
            if (isCancelled) {
                dd = null
            }
            if (dd != null) {
                val imageView: ImageView? = mImageViewReference.get()
                val imageLoader: ImageLoader? = getImageLoaderTask(imageView)
                if (this === imageLoader) {
                    imageView!!.setImageDrawable(dd)
                    if (Integer.toHexString(mColor) != "ff000000") {
                        imageView.setColorFilter(mColor, colorMode)
                    }
                }
            }
        }

    class AsyncDrawable(res: Resources?, imageLoader: ImageLoader) :
        BitmapDrawable(res) {
        private val imageLoaderTaskReference: WeakReference<ImageLoader> = WeakReference(imageLoader)
        val imageLoader: ImageLoader?
            get() = imageLoaderTaskReference.get()
    }

    fun cancelPotentialWork(data: String, imageView: ImageView): Boolean {
        val imageLoaderTask: ImageLoader? = getImageLoaderTask(imageView)
        val imageData = imageLoaderTask?.fieldData
        if (imageData == 0 || imageData != data.toInt()) {
            imageLoaderTask?.cancel(true)
        } else {
            return false
        }
        return true
    }

    private fun getImageLoaderTask(imageView: ImageView?): ImageLoader? {
        val drawable = imageView?.drawable
        if (drawable is AsyncDrawable) {
            return drawable.imageLoader
        }
        return null
    }

}