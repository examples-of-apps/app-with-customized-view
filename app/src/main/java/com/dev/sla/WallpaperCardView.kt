package com.dev.sla

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.card.MaterialCardView

class WallpaperCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
	private val TAG = "Wallpaper"
	
    private var mediaView: ImageView
    private var titleView: TextView
    private var subtitleView: TextView
    private var contentView: TextView

    var media: Drawable? = null
        set(value) {
            field = value
            value?.let {
                mediaView.setImageDrawable(it)
            }
        }

    var title: String = ""
        set(value) {
            field = value
            titleView.text = value
        }

    var subtitle: String = ""
        set(value) {
            field = value
            subtitleView.text = value
        }

    var content: String = ""
        set(value) {
            field = value
            contentView.text = value
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.test, this, true)

        mediaView = findViewById(R.id.media)
        titleView = findViewById(R.id.title)
        subtitleView = findViewById(R.id.subtitle)
        contentView = findViewById(R.id.content)

        
		val typedArray = context.obtainStyledAttributes(attrs, R.styleable.WallpaperCardView)
		
		val mediaRes = typedArray.getResourceId(R.styleable.WallpaperCardView_media, -1)
		if (mediaRes != -1) {
			media = AppCompatResources.getDrawable(context, mediaRes)
		}
		
		title = typedArray.getString(R.styleable.WallpaperCardView_title) ?: ""
		subtitle = typedArray.getString(R.styleable.WallpaperCardView_subtitle) ?: ""
		content = typedArray.getString(R.styleable.WallpaperCardView_content) ?: ""
		
		typedArray.recycle()
    }
}
