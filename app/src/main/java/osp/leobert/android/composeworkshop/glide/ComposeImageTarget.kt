package osp.leobert.android.composeworkshop.glide

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class ComposeImageTarget(private var imgRes: MutableLiveData<ImageBitmap>) :
    CustomTarget<Bitmap>() {

    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
        imgRes.value = resource.asImageBitmap()
    }

    override fun onLoadCleared(placeholder: Drawable?) {
//        imgRes.value.asAndroidBitmap().recycle()
        Log.e("lmsg", "onLoadCleared")
    }
}