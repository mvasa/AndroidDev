package com.vasa.android.fragmentexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.content.Context
import android.widget.Button
import com.vasa.android.fragmentexample.R.id.button1
import com.vasa.android.fragmentexample.R.id.seekBar1
import kotlinx.android.synthetic.main.toolbar_fragment.*

class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener{

    var seekvalue = 10

    var activityCallback: ToolbarFragment.ToolbarListener? = null

    interface ToolbarListener
    {
        fun onButtonClick(position: Int, text: String)
    }

    override fun onAttach(context: Context?){
        super.onAttach(context)
        try
        {
            activityCallback = context as ToolbarListener
        }
        catch (e: ClassCastException)
        {
            throw ClassCastException(context?.toString() + " must implement ToolbarListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.toolbar_fragment, container, false)

        val seekBar: SeekBar? = view?.findViewById(R.id.seekBar1)
        val button: Button? = view?.findViewById(R.id.button1)

        seekBar?.setOnSeekBarChangeListener(this)

        button1?.setOnClickListener { v: View -> buttonClicked(v) }
        return view
    }

    private fun buttonClicked(view:View)
    {
        activityCallback?.onButtonClick(seekvalue, editText1.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
    {
        seekvalue = progress
    }
    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}

