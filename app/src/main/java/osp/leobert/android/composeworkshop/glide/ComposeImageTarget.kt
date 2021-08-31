package osp.leobert.android.composeworkshop.glide

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

/**
 * <p><b>Package:</b> osp.leobert.android.composeworkshop.glide </p>
 * <p><b>Project:</b> ComposeWorkShop </p>
 * <p><b>Classname:</b> ComposeImageTarget </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/8/31.
 */
class ComposeImageTarget(var imgRes: MutableState<ImageBitmap>) : CustomTarget<Bitmap>() {

    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
        Log.e("lmsg","onResourceReady:")
        imgRes.value = resource.asImageBitmap()
    }

    override fun onLoadCleared(placeholder: Drawable?) {
    }


}